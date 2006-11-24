package editortest.mof.model;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import cmof.UmlClass;

public class MofMetaModelElementImpl implements IMetaModelElement {

	private final UmlClass fClass;

	public MofMetaModelElementImpl(UmlClass theClass) {
		super();
		fClass = theClass;
	}

	public boolean isMetaModelFor(IModelElement e) {
		if (e instanceof MofModelElementImpl) {
			return ((MofModelElementImpl)e).getMofObject().getMetaClass().equals(fClass);
		} else {
			return false;
		}
	}

	protected UmlClass getMofElement() {
		return fClass;
	}
}
