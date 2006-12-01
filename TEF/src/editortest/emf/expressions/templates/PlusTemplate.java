package editortest.emf.expressions.templates;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.templates.Template;

public class PlusTemplate extends OperatorTemplate {

	public PlusTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Plus"));
	}

	@Override
	protected String getOperatorString() {
		return "+";
	}
}
