package editortest.mof.template;

import editortest.model.IModelElement;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.IndentationTemplate;

public class MofIndentationTemplate extends IndentationTemplate {

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
