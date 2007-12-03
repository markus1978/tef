package hub.sam.tef.editor;

import hub.sam.tef.layout.AbstractLayoutManager;


/**
 * Model editors do not edit text files, but files containing EMF model XMI. These
 * model editors use a specific document provider.
 * 
 * A model editor provides the following information about the used language:
 * <ul>
 * 	<li>layout manager</li>
 * </ul>
 */
public abstract class ModelEditor extends TextEditor {

	public ModelEditor() {
		super();
		setDocumentProvider(new ModelDocumentProvider(this));
	}
	
	protected abstract AbstractLayoutManager createLayout();

}
