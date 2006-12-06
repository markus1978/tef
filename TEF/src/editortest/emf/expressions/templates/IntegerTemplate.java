package editortest.emf.expressions.templates;

import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class IntegerTemplate extends AbstractExpressionTemplate {

	public IntegerTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Integer"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new SingleValueTemplate<String>(this, "value") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this, "[0-9]+");
					}					
				}
		};
	}	
}
