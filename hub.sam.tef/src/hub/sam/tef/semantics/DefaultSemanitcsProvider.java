package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.ParseTreeRuleNode;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Provides the default semantics. Is also intended as a superclass for user
 * defined semantics. It relies on a given {@link IIdentificationScheme} to
 * realise reference resolution and content assist.
 */
public class DefaultSemanitcsProvider implements ISemanticsProvider {
	
	private final IPropertyCreationSemantics fPropertyCreationSemantics = new PropertyCreationSemantics();
	private final IPropertyResolutionSemantics fPropertyResolutionSemantics;
	
	private final IValueCheckSemantics fValueCheckSemantics = new ValidationFrameworkValueCheckSemantics();
	
	public DefaultSemanitcsProvider(IIdentificationScheme idScheme) {
		super();
		fPropertyResolutionSemantics = new IdSchemePropertyResolutionSemantics(
				idScheme);
	}
	
	private static class PropertyCreationSemantics extends AbstractPropertySemantics implements
			IPropertyCreationSemantics {
		
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
			
			if (EObjectHelper.getIdAttribute((EObject)actual) == binding.getProperty()) {
				context.addOccurence((EObject)actual, parseTreeNode.getPosition());
			}
		}
	}
	
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

	public IPropertyCreationSemantics getPropertyCreationSemantics(
			CompositeBinding binding) {
		return fPropertyCreationSemantics;
	}

	public IPropertyResolutionSemantics getPropertyResolutionSemantics(
			ReferenceBinding binding) {
		return fPropertyResolutionSemantics;
	}

	public IValueCreationSemantics getValueCreationSemanitcs(
			ValueBinding binding) {
		return fValueCreationSemantics;
	}

	public IValuePrintSemantics getValuePrintSemantics(ValueBinding binding) {
		return fValuePrintSemantics;
	}

	public IValueCheckSemantics getValueCheckSemantics(ElementBinding binding) {
		return fValueCheckSemantics;
	}

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

	public IDefaultValuePrintSemantics getDefaultValuePrintSemantics(
			PropertyBinding binding) {
		return fDefaultValuePrintSemantics;
	}
}
