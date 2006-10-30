package editortest.template;

import java.util.Map;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.text.CompoundText;
import editortest.text.Text;
import editortest.text.TextEvent;

public abstract class ElementTemplate extends ModelBasedTemplate {
	
	private final IMetaModelElement fMetaModel;
	private Template[] fTemplates;

	public ElementTemplate(IModel model, IMetaModelElement metaModel) {
		super(model);		
		fMetaModel = metaModel;
	}	

	public abstract Template[] createTemplates();
	
	private Template[] getTemplates() {
		if (fTemplates == null) {
			fTemplates = createTemplates();
		}
		return fTemplates;
	}
	
	protected IMetaModelElement getMetaElement() {
		return this.fMetaModel;
	}

	@Override
	public Text createText(IModelElement model) {
		CompoundText result = new CompoundText();
		for (Template template: getTemplates()) {
			result.addText(template.createText(model));
		}
		return result;
	}	
	
	@Override
	public IModelElement createModelFromEvent(TextEvent event) {
		IModelElement result = getModel().createElement(getMetaElement());
		result.setValue("name", "<unnamed>");
		return result;
	}	
	
	@Override
	public boolean isTemplateFor(Object model) {
		if (model instanceof IModelElement) {
			return getMetaElement().isMetaModelFor((IModelElement)model);
		} else {
			return false;
		}
	}
	
}
