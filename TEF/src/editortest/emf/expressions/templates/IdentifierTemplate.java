package editortest.emf.expressions.templates;

import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class IdentifierTemplate extends AbstractExpressionTemplate {

	public IdentifierTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Identifier"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new SingleValueTemplate<String>(this, "id") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				}
		};
	}	
}
