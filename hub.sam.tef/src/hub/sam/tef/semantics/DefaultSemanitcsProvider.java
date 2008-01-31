package hub.sam.tef.semantics;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.ParseTreeRuleNode;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.semantics.UnresolvableReferenceError.UnresolveableReferenceErrorException;
import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ConstantBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.PrimitiveBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.util.EObjectHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.Position;

/**
 * Provides the default semantics. Is also intended as a superclass for
 * user defined semantics.
 */
public class DefaultSemanitcsProvider implements ISemanticsProvider {
	
	private final PropertySemantics fPropertySemantics = new PropertySemantics();
	
	private static class PropertySemantics extends AbstractPropertySemantics implements
			IPropertyResolutionSemantics, IPropertyCreationSemantics {
		/**
		 * Expects an {@link EObject} as actual, and a non null value. Ignores
		 * the parseTreeNode. Simply sets or adds the value to the
		 * {@link EStructuralFeature} represented by the binding, depending on its
		 * multiplicity.
		 */
		public void addValue(ParseTreeNode parseTreeNode, Object actual,
				Object value, IModelCreatingContext context,
				CompositeBinding binding) throws ModelCreatingException {
			
			if (value == null) {
				throw new ModelCreatingException("Composite value must not be null");
			}
			if (!(actual instanceof EObject)) {
				throw new ModelCreatingException("Attempt to set property to non object value");
			}
			
			setValue((EObject)actual, value, binding.getProperty());					
		}

		/**
		 * Expects an {@link EObject} as actual. If the value is null, it takes the
		 * string represented by the parseTreeNode. If the value is not null, it has
		 * to contain a string. Tries to resolve the given value based on the
		 * property type, all the objects contained in the given context, and the
		 * named of these elements. If the referenced can be resolved, it simply
		 * sets or adds the resolved value to the {@link EStructuralFeature}
		 * represented by the binding, depending on its multiplicity, other wise an
		 * {@link UnresolvableReferenceError} is created and returned.
		 */
		@SuppressWarnings("unchecked")
		public EObject resolve(ParseTreeNode parseTreeNode, Object actual,
				Object value, IModelCreatingContext context,
				ReferenceBinding binding) throws ModelCreatingException, 
						UnresolveableReferenceErrorException {
			if (!(actual instanceof EObject)) {
				throw new ModelCreatingException(
						"Atempt to set property value to a non object value");
			}
			if (value == null) {
				Position range = parseTreeNode.getPosition();
				int offset = range.getOffset();
				value = context.getText().substring(offset, offset + range.getLength());
			}
			if (!(value instanceof String)) {
				throw new ModelCreatingException(
						"Unacceptable property value: " + value.toString());
			}
			
			EObject resolution = null;
			try {
				resolution = resolve("name", value, binding.getProperty().getEType(), 			
					new MyIterable<Notifier>((Iterator)context.getResource().getAllContents()));
			} catch (AmbiguousReferenceException ex) {
				context.addError(new ModelCheckError("Reference is ambiguous", (EObject)actual));				
			}
			if (resolution == null) {
				new UnresolvableReferenceError("Could not resolve " + value, parseTreeNode).throwIt();
				return null;
			} else {
				return resolution;				
			}									
		}
	}
	
	/**
	 * Default content assist semantics for reference bindings. They use the id
	 * attribute ({@link EObjectHelper#getIdAttribute(EObject)}) of the
	 * reference binding's type to identify instances of this type in the model
	 * and propose the id of identified instances.
	 */
	private class DefaultReferenceContentAssistSemantics implements IContentAssistSemantics {
		private final EClass metaType;
				
		public DefaultReferenceContentAssistSemantics(EClass metaType) {
			super();
			this.metaType = metaType;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<ContentAssistProposal> createProposals(
				ContentAssistContext context) {
			List<String> result = new ArrayList<String>();
			Resource currentModel = context.getEditor().getCurrentModel();
			Iterator content = null;
			if (currentModel.getResourceSet() != null) {
				content = currentModel.getResourceSet().getAllContents();
			} else {
				content = currentModel.getAllContents();
			}
			
			if (content == null) {
				return Collections.emptyList();
			}
			while (content.hasNext()) {
				Object nextObj = content.next();
				if (nextObj instanceof EObject) {
					EObject next = (EObject)nextObj; 
					if (metaType.isSuperTypeOf(next.eClass())) {
						EStructuralFeature idAttribute = EObjectHelper.getIdAttribute(next);
						if (idAttribute != null) {
							result.add(next.eGet(idAttribute).toString());
						}
					}
				}
			}			
			return ContentAssistProposal.createProposals(
					result, context, 
					null, ContentAssistProposal.REFERENCE_IMAGE, ContentAssistProposal.REFERENCE);
		}		
	};
	
	private final IValueCreationSemantics fValueCreationSemantics = new IValueCreationSemantics() {		
		/**
		 * For element bindings, it simply instantiates the binding's meta-class
		 * using the context as factory. For primitive bindings it converts the
		 * string represented by the parseTreeNode into an according primitive
		 * value.
		 */	
		public Object createValue(ParseTreeNode parseTreeNode,
				IModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			if (binding instanceof ElementBinding) {
				return context.instantiate(((ElementBinding)binding).getMetaclass(), 
						(ParseTreeRuleNode)parseTreeNode);
			} else if (binding instanceof PrimitiveBinding) {
				for(PrimitiveTypeDescriptor type: PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
					if (type.isTypeDescriptorFor(binding)) {
						IValueCreationSemantics semantics = type.getValueCreationSemantics();
						if (semantics != null) {
							return semantics.createValue(parseTreeNode, context, binding);
						} else {							
							String stringValue = parseTreeNode.getNodeText();
							return stringValue;
						}
					}
				}
				throw new ModelCreatingException("No type descriptor for used primitive binding.");
			} else if (binding instanceof ConstantBinding) {
				ConstantBinding constantBinding = ((ConstantBinding)binding);
				String constantBindingType = constantBinding.getType();
				if (constantBindingType.equals("Boolean")) {
					return new Boolean(constantBinding.getValue());
				} else if (constantBindingType.equals("String")) {
					return constantBinding.getValue();
				} else {
					EEnum enumType = null;
					for (EPackage metaModel: context.getMetaModelPackages()) {
						EClassifier classifier = metaModel.getEClassifier(constantBindingType);
						if (classifier != null && classifier instanceof EEnum) {
							enumType = ((EEnum)classifier);
						}
					}
					if (enumType == null) {
						throw new ModelCreatingException(
								"Unknown constant binding type: " + constantBindingType);
					} else {
						enumType.getInstanceTypeName();
						EEnumLiteral literal = 
								enumType.getEEnumLiteral(constantBinding.getValue());
						if (literal == null) {
							throw new ModelCreatingException(
									"Unknown enum literal: " + constantBindingType + ":" + constantBinding.getValue());
						} else {
							return literal.getInstance();
						}
					}
				}				
			} else {
				Assert.isTrue(false);
				return null;
			}
		}
	};
	
	private final IValuePrintSemantics fValuePrintSemantics = new IValuePrintSemantics() {
		/**
		 * Returns null for model object values, and uses toString() for primitive
		 * values with no specific semantics.
		 */
		@Override
		public boolean printValue(Object modelValue, ValueBinding binding,
				PrettyPrintState state, PrettyPrinter printer) throws ModelCreatingException {
			if (modelValue == null) {
				return false;
			} else if (modelValue instanceof EObject) {
				if (binding instanceof PrimitiveBinding) {
					throw new ModelCreatingException("An element used as value for a primitive binding.");
				}
				return false;
			} else {
				if (binding instanceof PrimitiveBinding) {
					for(PrimitiveTypeDescriptor type: PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
						if (type.isTypeDescriptorFor(binding)) {
							IValuePrintSemantics semantics = type.getValuePrintSemantics();
							if (semantics != null) {
								return semantics.printValue(modelValue, binding, state, printer);
							} else {	
								if (modelValue == null) {
									return false;
								} else {
									state.append(modelValue.toString());
									return true;
								}
							}
						}
					}
					throw new ModelCreatingException("No type descriptor for used primitive binding.");
				} else if (binding instanceof ConstantBinding) {
					if (modelValue.toString().equals(((ConstantBinding)binding).getValue())) {
						printer.print((Rule)binding.eContainer(), state, true);
						return true;
					} else {
						return true;
					}
				} else {
					state.append(modelValue.toString());
					return true;
				}
			}
		}
	};
	
	private final IDefaultValuePrintSemantics fDefaultValuePrintSemantics = new IDefaultValuePrintSemantics() {

		@Override
		public boolean printDefaultValue(Object parentValue,
				PropertyBinding binding, PrettyPrintState state)
				throws ModelCreatingException {
			if (binding.getProperty().getLowerBound() >= 1) {
				state.append("<unknown>");
				return true;
			} else {
				return false;
			}
		}		
	};

	@Override
	public IPropertyCreationSemantics getPropertyCreationSemantics(
			CompositeBinding binding) {
		return fPropertySemantics;
	}

	@Override
	public IPropertyResolutionSemantics getPropertyResolutionSemantics(
			ReferenceBinding binding) {
		return fPropertySemantics;
	}

	@Override
	public IValueCreationSemantics getValueCreationSemanitcs(
			ValueBinding binding) {
		return fValueCreationSemantics;
	}

	@Override
	public IValuePrintSemantics getValuePrintSemantics(ValueBinding binding) {
		return fValuePrintSemantics;
	}

	@Override
	public IValueCheckSemantics getValueCheckSemantics(ElementBinding binding) {
		return null;
	}

	@Override
	public IContentAssistSemantics getContentAssistSemantics(Binding binding) {	
		if (binding instanceof PrimitiveBinding) {
			for(PrimitiveTypeDescriptor type: PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
				if (type.isTypeDescriptorFor((ValueBinding)binding)) {
					return type.getContentAssistSemantics();
				}
			}			
		} else if (binding instanceof ReferenceBinding) {
			ReferenceBinding refBinding = (ReferenceBinding)binding;
			if (refBinding.getProperty().getEType() instanceof EClass) {
				return new DefaultReferenceContentAssistSemantics(
						(EClass)refBinding.getProperty().getEType());
			}
		} else if (binding instanceof ElementBinding) {
			return new DefaultElementContentAssistSemantics((ElementBinding)binding);
		}
	 	return null;
	}

	@Override
	public IDefaultValuePrintSemantics getDefaultValuePrintSemantics(
			PropertyBinding binding) {
		return fDefaultValuePrintSemantics;
	}
	
	
}
