package editortest.template;

import editortest.model.IModelElement;
import editortest.text.FixText;
import editortest.text.Text;

public abstract class IndentationTemplate extends ElementTemplate {

	public IndentationTemplate(Template template) {
		super(template, null);
	}

	protected abstract int getDepth(IModelElement model);

	@Override
	public Text createView(IModelElement model) {
		StringBuffer indent = new StringBuffer("");
		int depth = getDepth(model);
		for (int i = 0; i < depth; i++) {
			indent.append("    ");
		}
		return new FixText(indent.toString());
	}

	@Override
	public Template[] createTemplates() {
		return new Template[]{};
	}
	
}
