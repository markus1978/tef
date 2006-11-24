package editortest.emf.model;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;

import org.eclipse.emf.ecore.EClass;


public class EMFMetaModelElement implements IMetaModelElement {

	private final EClass fMetaElement;
	
	public EMFMetaModelElement(final EClass metaElement) {
		super();
		fMetaElement = metaElement;
	}
	
	public boolean isMetaModelFor(IModelElement e) {
		if (e.getMetaElement() instanceof EMFMetaModelElement) {
			return ((EMFMetaModelElement)e.getMetaElement()).fMetaElement.equals(fMetaElement);
		} else {
			return false;
		}
	}

	public EClass getEMFObject() {
		return fMetaElement;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EMFMetaModelElement) {
			return fMetaElement.equals(((EMFMetaModelElement)obj).fMetaElement);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fMetaElement.hashCode();
	}
	
	
}
