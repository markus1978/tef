package hub.sam.tef.gmf;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;

import hub.sam.tef.editor.popup.PopupEditor;

public abstract class GMFPopupEditor extends PopupEditor {

	/**
	 * For GMF editors, not the actual edited model is the actual model (this
	 * would be the diagram).
	 */
	@Override
	protected Resource getEditedModel() { 
		Resource superResult = super.getEditedModel();
		if (superResult instanceof GMFResource) {
			return superResult.getResourceSet().getResources().get(1);
		} else {
			return superResult;
		}
	}
	
}
