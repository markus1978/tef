package hub.sam.tef.semantics;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.ParseTreeRuleNode;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.PrimitiveBinding;
import hub.sam.tef.tsl.ReferenceBinding;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
				Object value, ModelCreatingContext context,
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
		public UnresolvableReferenceError resolve(ParseTreeNode parseTreeNode, Object actual,
				Object value, ModelCreatingContext context,
				ReferenceBinding binding) throws ModelCreatingException {
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
					new MyIterable<Notifier>((Iterator)context.getAllContents()));
			} catch (AmbiguousReferenceException ex) {
				context.addError(new ModelCheckError("Reference is ambiguous", (EObject)actual));				
			}
			if (resolution == null) {
				return new UnresolvableReferenceError("Could not resolve " + value, parseTreeNode);	
			} else {
				setValue((EObject)actual, resolution, binding.getProperty());
				return null;
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

		@Override
		public Collection<ContentAssistProposal> createProposals(
				ContentAssistContext context) {
			List<String> result = new ArrayList<String>();
			Iterator<EObject> content = context.getEditor().getCurrentModel().getAllContents();
			if (content == null) {
				return Collections.emptyList();
			}
			while (content.hasNext()) {
				EObject next = content.next();
				if (next.eClass() == metaType) {
					EStructuralFeature idAttribute = EObjectHelper.getIdAttribute(next);
					if (idAttribute != null) {
						result.add(next.eGet(idAttribute).toString());
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
				ModelCreatingContext context, ValueBinding binding)
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
		public String printValue(Object modelValue, ValueBinding binding) 
				throws ModelCreatingException {
			if (modelValue instanceof EObject) {
				if (binding instanceof PrimitiveBinding) {
					throw new ModelCreatingException("An element used as value for a primitive binding.");
				}
				return null;
			} else {
				if (binding instanceof PrimitiveBinding) {
					for(PrimitiveTypeDescriptor type: PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
						if (type.isTypeDescriptorFor(binding)) {
							IValuePrintSemantics semantics = type.getValuePrintSemantics();
							if (semantics != null) {
								return semantics.printValue(modelValue, binding);
							} else {							
								return modelValue.toString();
							}
						}
					}
					throw new ModelCreatingException("No type descriptor for used primitive binding.");
				} else {
					return modelValue.toString();
				}
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
}
