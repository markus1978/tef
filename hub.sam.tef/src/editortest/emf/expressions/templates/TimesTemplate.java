package editortest.emf.expressions.templates;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.templates.Template;

public class TimesTemplate extends OperatorTemplate {

	public TimesTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Times"));
	}

	@Override
	protected String getOperatorString() {
		return "*";
	}
}
