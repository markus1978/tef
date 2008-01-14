package hub.sam.tef.editor.model;

import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.layout.AbstractLayoutManager;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;


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
		initialiseDocumentProvider();
	}
	
	protected void initialiseDocumentProvider() {
		setDocumentProvider(new ModelDocumentProvider(this));
	}
	
	public abstract AbstractLayoutManager createLayout();

	/**
	 * Ads the given resource to the resource set of this editor. This is the primary
	 * resource that is supposed to contain the edited model. This method
	 * can only be called once in the life cycle of this editor.
	 */
	public final void setModel(Resource resource) {
		fResourceSet = resource.getResourceSet();
		if (fResourceSet == null || fResourceSet.getResources().size() == 0) {
			fResourceSet = new ResourceSetImpl();
			fResourceSet.getResources().add(resource);
		}	
	}
	
}
