package hub.sam.tef.expressions.templates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.IntegerTemplate;

public class NumberTemplate extends ElementTemplate {

	public NumberTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Number"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<Integer>(this, "value") {
				@Override
				protected ValueTemplate<Integer> createValueTemplate() {
					return new IntegerTemplate(this, 0);
				}				
			}
		};
	}
	
}
