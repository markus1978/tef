package hub.sam.tef.emf;

import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.annotations.IIdentifierResolver;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import java.util.Collection;
import java.util.Vector;

public class EMFIdentifierResolver implements IIdentifierResolver {

	public IModelElement resolveIdentifier(IModel model, ASTElementNode identifier, IModelElement context,
			IModelElement topLevelElement,
			IMetaModelElement exprectedType, String property) throws CouldNotResolveIdentifierException {
		try {
			for (IModelElement possibility: getValidElements(model, exprectedType, topLevelElement)) {
				if (possibility.getValue("name") != null && 
						possibility.getValue("name").equals(identifier.getNode("name").getContent())) {						
					return possibility;				
				}
			}					
			throw new CouldNotResolveIdentifierException("Model element for identifier " + 
					identifier.getNode("name").getContent() + " could not be found");
		} catch (CouldNotResolveIdentifierException ex) {
			throw ex;
		} catch (Throwable ex) {
			throw new CouldNotResolveIdentifierException("Could not resolve this reference because of internal errors: "
					+ ex.getMessage());
		}
	}
	
	public Collection<IModelElement> getValidElements(IModel model, IMetaModelElement metaModelElement, IModelElement topLevelElement) {
		Collection<IModelElement> result = new Vector<IModelElement>();
		for (Object o: model.getElementExceptEditedResource(metaModelElement)) {
			result.add((IModelElement)o);
		}
		collectValidElementsFromModel(topLevelElement, 	metaModelElement, result);
		return result;
	}
	
	private void collectValidElementsFromModel(IModelElement element, IMetaModelElement metaModelElement, 
			Collection<IModelElement> values) {
		if (element.getMetaElement().equals(metaModelElement)) {
			values.add(element);
		}
		for (Object o: element.getComponents()) {
			collectValidElementsFromModel((IModelElement)o, metaModelElement, values);
		}
	}

	public void addToEnvironment(IModelElement element) {
		
	}

	public void removeFromEnvironment(IModelElement element) {
		
	}
	
	
}
