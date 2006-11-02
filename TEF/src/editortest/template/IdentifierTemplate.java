package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.template.text.IdentifierText;
import editortest.text.ITextEventListener;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;

public class IdentifierTemplate extends ElementTemplate {

	private final boolean fReadOnly;
	
	public IdentifierTemplate(Template template, IMetaModelElement metaModel, boolean readOnly) {
		super(template, metaModel);	
		fReadOnly = readOnly;
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { new PrimitiveTemplate(this, "name", fReadOnly) };
	}
	
}
