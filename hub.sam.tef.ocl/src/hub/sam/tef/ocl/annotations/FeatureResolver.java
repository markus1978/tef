package hub.sam.tef.ocl.annotations;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.annotations.IIdentifierResolver;
import hub.sam.tef.emf.model.EMFModel;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.utilities.PredefinedType;

public class FeatureResolver extends AbstractOclIdentifierResolver implements IIdentifierResolver {

	public IModelElement resolveIdentifier(IModel model, ASTElementNode node,
			IModelElement context, IModelElement topLevelElement,
			IMetaModelElement expectedType, String property) throws CouldNotResolveIdentifierException {
		String name = node.getNode("name").getContent();
		EObject eContext = (EObject)((EMFModelElement)context).getEMFObject();
		while (eContext != null) {
			if (eContext instanceof PropertyCallExp) {
				PropertyCallExp propertyCall = (PropertyCallExp)eContext;						
				OCLExpression source = propertyCall.getSource();
				EClassifier sourceType = null;
				if (source == null && selfVar != null) {
					sourceType = ((Variable)selfVar).getType();
				} else {
					sourceType = TypeHelper.getTypeFor(source);
				}
				if (sourceType == null) {
					CouldNotResolveIdentifierException ex = new CouldNotResolveIdentifierException(
							"Could not resolve the reference because the type of the referee is unknown.");
					TEFPlugin.getDefault().getLog().log(new Status(Status.WARNING,
							TEFPlugin.PLUGIN_ID, Status.OK, 
							getClass().getCanonicalName() + ": sourceType not set",
							null));	
					throw ex;
				}
				if (sourceType instanceof EClass) {
					EClass sourceClass = (EClass)sourceType;
					for (Object featureObj: sourceClass.getEAllStructuralFeatures()) {
						EStructuralFeature feature = (EStructuralFeature)featureObj;
						if (name.equals(feature.getName())) {
							// TODO type check
							return (IModelElement)EMFModel.getModelForEMFObject(feature);
						}
					}
					throw new CouldNotResolveIdentifierException("The type " + sourceType.getName() + " has no property " + name + ".");
				} 
				throw new CouldNotResolveIdentifierException("Could not resolve the reference because the referee is not a class instance.");
			} else if (eContext instanceof OperationCallExp) {
				OperationCallExp operationCall = (OperationCallExp)eContext;				
				EClassifier sourceType =  TypeHelper.getTypeFor(operationCall.getSource());
				
				if (sourceType == null) {
					CouldNotResolveIdentifierException ex = new CouldNotResolveIdentifierException("Could not resolve the reference because the type of the referee is unknown.");
					TEFPlugin.getDefault().getLog().log(new Status(Status.WARNING,
							TEFPlugin.PLUGIN_ID, Status.OK, 
							getClass().getCanonicalName() + ": sourceType not set",
							null));	
					throw ex;
				}
				
				PredefinedType predefinedSourceType = TypeHelper.getPredefinedType(sourceType);
				if (sourceType instanceof EClass) {
					EClass sourceClass = (EClass)sourceType;
					for (Object operationObj: sourceClass.getEAllOperations()) {
						EOperation operation = (EOperation)operationObj;
						if (name.equals(operation.getName())) {
							// TODO type check, parameter?
							return (IModelElement)EMFModel.getModelForEMFObject(operation);
						}
					}
					throw new CouldNotResolveIdentifierException("The type " + sourceType.getName() + " has no operation " + name + ".");
				} else if (predefinedSourceType != null) {
					for (Object operationObj: predefinedSourceType.getOperations()) {
						EOperation operation = (EOperation)operationObj;
						if (name.equals(operation.getName())) {
							// TODO type check, parameter?
							return (IModelElement)EMFModel.getModelForEMFObject(operation);
						}
					}
					throw new CouldNotResolveIdentifierException("The type " + predefinedSourceType.toString() + " has no operation " + name + ".");
				}
				throw new CouldNotResolveIdentifierException("Could not resolve the reference because the referee is not a class instance nor an instance of a predefined type.");
			} else if (eContext instanceof Constraint) {
				throw new CouldNotResolveIdentifierException("unkown reason");
			}
			eContext = eContext.eContainer();
		}
		throw new CouldNotResolveIdentifierException("unkown reason");
	}

	

	public void addToEnvironment(IModelElement element) {
		// TODO Auto-generated method stub	
	}

	public void removeFromEnvironment(IModelElement element) {
		// TODO Auto-generated method stub	
	}
}
