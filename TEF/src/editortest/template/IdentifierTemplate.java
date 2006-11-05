package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.text.ITextStatusListener;
import editortest.text.Text;

public class IdentifierTemplate extends ElementTemplate {

	private final boolean fReadOnly;
	
	public IdentifierTemplate(Template template, IMetaModelElement metaModel, boolean readOnly) {
		super(template, metaModel);	
		fReadOnly = readOnly;
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new SingleValueTemplate(this, "name") {
					@Override
					protected ValueTemplate createValueTemplate() {
						return new StringTemplate(this);
					}
				}
		};
	}

	@Override
	public Text createView(IModelElement model, IModelElement propagateValueTo) {
		final Text result = super.createView(model, propagateValueTo);
		getDocument().getDocument().addOccurence(model, result);
		result.addTextStatusListener(new ITextStatusListener() {
			public void hidden() {
				getDocument().getDocument().removeOccurence(result);
			}			
		});
		return result;
	}
}
