package hub.sam.tef.editor;

import hub.sam.tef.layout.AbstractLayoutManager;


public abstract class ModelEditor extends TextEditor {

	public ModelEditor() {
		super();
		setDocumentProvider(new ModelDocumentProvider(this));
	}
	
	protected abstract AbstractLayoutManager createLayout();

}
