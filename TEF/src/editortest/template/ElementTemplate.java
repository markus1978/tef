package editortest.template;

import java.util.Map;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.widgets.CompoundText;
import editortest.widgets.Text;
import editortest.widgets.TextEvent;

public abstract class ElementTemplate extends Template<IModelElement> {
	
	private final IMetaModelElement fMetaModel;
	private Template[] fTemplates;

	public ElementTemplate(final IMetaModelElement metaModel) {
		super();		
		fMetaModel = metaModel;
	}	

	public abstract Template[] createTemplates();
	
	private Template[] getTemplates() {
		if (fTemplates == null) {
			fTemplates = createTemplates();
		}
		return fTemplates;
	}
	
	protected IMetaModelElement getMetaModel() {
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
		IModelElement result = getMetaModel().createElement();
		result.setValue("name", "<unnamed>");
		return result;
	}	
	
	@Override
	public boolean isTemplateFor(Object model) {
		if (model instanceof IModelElement) {
			return getMetaModel().isMetaModelFor((IModelElement)model);
		} else {
			return false;
		}
	}
	
}
