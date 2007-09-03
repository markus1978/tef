package hub.sam.tef.ocl.annotations;

import hub.sam.tef.annotations.IChecker;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IModelElement;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.utilities.PredefinedType;

@Deprecated
public class OclChecker implements IChecker {

	public String check(IModelElement modelElement) {
		if (modelElement instanceof EMFModelElement) {
			EObject emfModelElement = ((EMFModelElement)modelElement).getEMFObject();
			if (emfModelElement instanceof OperationCallExp) {
				//return checkOperationCallExp((OperationCallExp)emfModelElement);
				return null;
			} else if (emfModelElement instanceof IteratorExp) {				
				//return checkIteratorExp((IteratorExp)emfModelElement);
				return null;
			} else {
				return null;
			}		
		} else {
			return null;
		}
	}
	
	/*
	public String checkOperationCallExp(OperationCallExp exp) {
		EOperation operation = exp.getReferredOperation();
		if (operation != null) {
			EList arguments = exp.getArgument();
			EList parameters = operation.getEParameters();
			if (arguments.size() != parameters.size()) {
				return "'" + operation.getName() + "' requires a different numbers of arguments";
			}
			int i = 0;
			for(Object parameterAsObj: parameters) {
				EParameter parameter = (EParameter)parameterAsObj;
				EClassifier requiredType = parameter.getEType();
				EClassifier actualType = TypeHelper.getTypeFor((OCLExpression)arguments.get(i));
				if (actualType == null) {
					return null;
				}
				if (!TypeHelper.isAssignableFrom(requiredType, actualType)) {
					return "wrong arguments for '" + operation.getName() + "'";
				}
				i++;
			}
			return null;
		} else {
			return null;
		}
	}
	*/
	
	public String checkIteratorExp(IteratorExp exp) {
		String iteratorName = exp.getName();		
		CollectionType predefinedSourceType = TypesFactory.eINSTANCE.createCollectionType(TypeHelper.getTypeFor(exp.getSource()));
		EOperation operation = null;
		
		for(Object operationAsObj: predefinedSourceType.getOperations()) {
			if (((EOperation)operationAsObj).getName().equals(iteratorName)) {
				operation = (EOperation)operationAsObj;
			}
		}
			
		EClassifier actualType = TypeHelper.getTypeFor(exp.getBody());
		if (actualType == null) {
			return null;
		}
		if (operation != null) {			
			EClassifier requiredType = ((EParameter)operation.getEParameters().iterator().next()).getEType();				
			if (!TypeHelper.isAssignableFrom(requiredType, actualType)) {
				return "wrong arguments for '" + operation.getName() + "'";
			}	
		} else {
			int code = predefinedSourceType.getOperationCodeFor(iteratorName);
			EClassifier requiredType = getTypeForIterator(predefinedSourceType, code);		
			if (!TypeHelper.isAssignableFrom(requiredType, actualType)) {
				return "wrong arguments for '" + iteratorName + "'";
			}
		}
		return null;
	}

	private static  EClassifier getTypeForIterator(CollectionType type, int code) {
		switch(code) {
		case PredefinedType.EXISTS:				
		case PredefinedType.FOR_ALL:
		case PredefinedType.ONE:
		case PredefinedType.ANY:			
			return TypesFactory.eINSTANCE.createPrimitiveBoolean();
		case PredefinedType.SELECT:			
		case PredefinedType.IS_UNIQUE:			
		case PredefinedType.REJECT:
			return type.getElementType();
		case PredefinedType.COLLECT:			
		case PredefinedType.COLLECT_NESTED:
		case PredefinedType.SORTED_BY:						
		case PredefinedType.CLOSURE:
		default:
			return TypesFactory.eINSTANCE.createAnyType();				
		}
	}
}
