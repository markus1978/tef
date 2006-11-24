package editortest.mof.template;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.IndentationTemplate;
import hub.sam.tef.templates.Template;
import editortest.mof.model.MofModelElementImpl;

public class MofIndentationTemplate extends IndentationTemplate {

	public MofIndentationTemplate(Template template) {
		super(template);
	}

	@Override
	protected int getDepth(IModelElement model) {
		cmof.reflection.Object modelObject = 
			((MofModelElementImpl)model).getMofObject().container();
		int i = 0;
		while (modelObject != null) {
			modelObject = modelObject.container();
			i++;
		}
		return i;
	}	
}
