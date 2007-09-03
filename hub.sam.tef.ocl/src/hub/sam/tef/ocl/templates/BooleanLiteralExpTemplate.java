package hub.sam.tef.ocl.templates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.BooleanLiteralTemplate;

public class BooleanLiteralExpTemplate extends ElementTemplate {
	
	public BooleanLiteralExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("BooleanLiteralExp"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<Boolean>(this, "booleanSymbol") {
				@Override
				protected ValueTemplate<Boolean> createValueTemplate() {
					return new BooleanLiteralTemplate(this);
				}			
			}
		};
	}
}
