package hub.sam.tef.ocl;

import hub.sam.tef.editor.popup.IPopupEditor;
import hub.sam.tef.editor.popup.EMFOpenPopupEditor;

import org.eclipse.swt.widgets.Shell;

public class EMFOpenOclPopupEditor extends EMFOpenPopupEditor {

	@Override
	protected IPopupEditor createEditor(Shell shell) {
		return new OclPopupEditor();
	}

}
