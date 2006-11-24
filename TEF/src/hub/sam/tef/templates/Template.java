package hub.sam.tef.templates;

import hub.sam.tef.models.IModel;
import hub.sam.tef.views.DocumentText;

/**
 * A Template describes how a model elements is viewed. It creates the initial views
 * for a model element. Creates and installes all controller necessary to react to
 * user input, model changes, etc.
 * 
 * This is the base class for all Templates. It provides access to the global elements
 * such as the edited model and the used view (DocumentText)
 */
public abstract class Template {

	private final DocumentText fDocument;
	
	public Template(DocumentText document) {
		fDocument = document;
	}
	
	public Template(Template template) {
		fDocument = template.getDocument();
	}
	
	/**
	 * Provides access to the used view.
	 * @return The view, a toplevel Text element.
	 */
	public DocumentText getDocument() {
		return fDocument;
	}
	
	/**
	 * Provides access to the edited model.
	 * @return The edited model.
	 */
	public IModel getModel() {
		return fDocument.getDocument().getModel();
	}

}
