package hub.sam.tef.completion;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;

import java.util.Collection;

public interface IValidModelElementProvider {
	Collection<IModelElement> getValidElements(IModel model, IMetaModelElement metaModelElement, 
			IModelElement topLevelElement);
}
