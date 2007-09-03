package editortest.emf.ocl.annotations;

import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.annotations.IIdentifierResolver;
import hub.sam.tef.emf.model.EMFModel;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.uml.Constraint;


public class VariableResolver extends AbstractOclIdentifierResolver implements IIdentifierResolver {
	
	public IModelElement resolveIdentifier(IModel model, ASTElementNode node,
			IModelElement context, IModelElement topLevelElement,
			IMetaModelElement expectedType, String property) throws CouldNotResolveIdentifierException{
		String name = node.getNode("name").getContent();
		EObject eContext = (EObject)((EMFModelElement)context).getEMFObject();
		while (eContext != null) {
			if (eContext instanceof LoopExp) {
				for (Object varObj: ((LoopExp)eContext).getIterator()) {
					Variable variable = (Variable)varObj;
					if (variable.getName().equals(name)) {
						return (IModelElement)EMFModel.getModelForEMFObject(variable);
					}
				}
			} else if (eContext instanceof LetExp) {
				if (((LetExp)eContext).getVariable().getName().equals(name)) {
					return (IModelElement)EMFModel.getModelForEMFObject(((LetExp)eContext).getVariable());
				}
			} else if (eContext instanceof Constraint) {
				if (name.equals("self")) {
					if (this.selfVar == null) {
						throw new CouldNotResolveIdentifierException("Self is not valid since this expression has no context.");
					} else {						
						return (IModelElement)EMFModel.getModelForEMFObject(this.selfVar);
					}
				}
			}
			eContext = eContext.eContainer();
		}
		throw new CouldNotResolveIdentifierException("There is no variable " + name);
	}

	public void addToEnvironment(IModelElement element) {
		// TODO Auto-generated method stub
	}

	public void removeFromEnvironment(IModelElement element) {
		// TODO Auto-generated method stub		
	}
}
