package editortest.template;

import editortest.model.IModelElement;
import editortest.text.FixText;
import editortest.text.Text;
import editortest.text.TextEvent;

public abstract class IndentationTemplate extends Template {

	@Override
	public IModelElement createModelFromEvent(TextEvent event) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected abstract int getDepth(IModelElement model);

	@Override
	public Text createText(IModelElement model) {
		StringBuffer indent = new StringBuffer("");
		int depth = getDepth(model);
		for (int i = 0; i < depth; i++) {
			indent.append("    ");
		}
		return new FixText(indent.toString());
	}

}
