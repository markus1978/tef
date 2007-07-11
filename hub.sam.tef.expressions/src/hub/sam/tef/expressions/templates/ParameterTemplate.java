package hub.sam.tef.expressions.templates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class ParameterTemplate extends ElementTemplate {

	public ParameterTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Parameter"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new IdentifierTemplate(this);
				}				
			}
		};
	}
	
}
