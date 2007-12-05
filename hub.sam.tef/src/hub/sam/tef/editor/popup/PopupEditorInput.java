package hub.sam.tef.editor.popup;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.part.FileEditorInput;

public class PopupEditorInput extends FileEditorInput {

	private final EObject fEditedObject;
	
	public PopupEditorInput(IFile file, EObject editedObject) {
		super(file);
		fEditedObject = editedObject;
	}

	public EObject getEditedObject() {
		return fEditedObject;
	}
}
