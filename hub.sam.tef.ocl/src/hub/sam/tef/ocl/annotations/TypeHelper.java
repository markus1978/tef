package hub.sam.tef.ocl.annotations;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.impl.PrimitiveIntegerImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveRealImpl;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import com.sun.org.apache.xerces.internal.impl.xs.util.StringListImpl;

public class TypeHelper {
	public static EClassifier getTypeFor(OCLExpression expression) {
		if (expression instanceof VariableExp) {
			Variable var = ((VariableExp)expression).getReferredVariable();
			if (var != null) {
				EClassifier type = var.getType();
				if (type == null) {
					if (var.eContainer() instanceof IteratorExp) {
						IteratorExp iteratorExp = (IteratorExp)var.eContainer();						
						OCLExpression source = iteratorExp.getSource();
						if (source != null && getTypeFor(source) != null) {
							EClassifier typeForSource = getTypeFor(source);
							if (typeForSource instanceof CollectionType) {
								return ((CollectionType)getTypeFor(source)).getElementType();
							} else {
								return typeForSource; // signle valued property interpreted as collection								
							}
						}
					}
				}
				return type;	
			}		
			return null;
		} else if (expression instanceof PropertyCallExp) {
			EStructuralFeature property = ((PropertyCallExp)expression).getReferredProperty();
			if (property != null) {
				return getType(property);
			}
			return null;
		} else if (expression instanceof OperationCallExp) {
			EOperation operation = ((OperationCallExp)expression).getReferredOperation();
			if (operation != null) {
				return getType(operation);				
			}
			return null;
		} else if (expression instanceof IteratorExp) {
			String iteratorName = ((IteratorExp)expression).getName();			
			try {
				PredefinedType predefinedSourceType = TypesFactory.eINSTANCE.createCollectionType();
				return predefinedSourceType.getResultTypeFor(null, 
						predefinedSourceType.getOperationCodeFor(iteratorName), null);
			} catch (SemanticException ex) {
				// TODO
				return null;
			}
		} else if (expression instanceof IntegerLiteralExp) {
			return TypesFactory.eINSTANCE.createPrimitiveInteger();
		} else if (expression instanceof StringLiteralExp) {
			return TypesFactory.eINSTANCE.createPrimitiveString();
		} else if (expression instanceof BooleanLiteralExp) {
			return TypesFactory.eINSTANCE.createPrimitiveBoolean();
		} else if (expression instanceof RealLiteralExp) {
			return TypesFactory.eINSTANCE.createPrimitiveReal();
		} else {
			return null;
		}
	}
	
	public static PredefinedType getPredefinedType(EClassifier classifier) {
		EcorePackage ecore = EcorePackage.eINSTANCE;
		if (classifier instanceof PredefinedType) {
			return (PredefinedType)classifier;
		} else  if (classifier.equals(ecore.getEBoolean()) || classifier.equals(ecore.getEBooleanObject())) {
			return TypesFactory.eINSTANCE.createPrimitiveBoolean();			
		} else  if (classifier.equals(ecore.getEInt()) || classifier.equals(ecore.getEIntegerObject()) || classifier.equals(ecore.getELong()) || classifier.equals(ecore.getELongObject())) {
				return TypesFactory.eINSTANCE.createPrimitiveInteger();
		} else  if (classifier.equals(ecore.getEString())) {
			return TypesFactory.eINSTANCE.createPrimitiveString();		
		} else {
			return null;
		}
	}
	
	public static EClassifier getType(ETypedElement element) {
		EClassifier baseType = element.getEType();
		if (element.getUpperBound() > 1 || element.getUpperBound() < 0) {
			if (element.isOrdered()) {
				return TypesFactory.eINSTANCE.createOrderedSetType(baseType);
			} else if (element.isUnique()) {
				return TypesFactory.eINSTANCE.createSetType(baseType);
			} else {
				return TypesFactory.eINSTANCE.createBagType(baseType);
			}
		} else {
			return baseType;
		}
	}

	public static boolean isAssignableFrom(EClassifier requiredType, EClassifier actualType) {		
		Class requiredInstanceClass = requiredType.getInstanceClass();
		Class actualInstanceClass = actualType.getInstanceClass();
		if (requiredType instanceof PrimitiveRealImpl && actualType instanceof PrimitiveIntegerImpl) {
			return true;
		}
		if (requiredInstanceClass != null && actualInstanceClass != null) {
			return requiredInstanceClass.isAssignableFrom(actualInstanceClass);
		} else {
			return requiredType.equals(actualType);
		} 		
	}	
}
