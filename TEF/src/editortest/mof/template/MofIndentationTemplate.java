package editortest.mof.template;

import editortest.model.IModelElement;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.IndentationTemplate;
import editortest.template.Template;

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
