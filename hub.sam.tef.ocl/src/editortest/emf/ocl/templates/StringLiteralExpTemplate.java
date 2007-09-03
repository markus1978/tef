package editortest.emf.ocl.templates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.StringLiteralTemplate;

public class StringLiteralExpTemplate extends ElementTemplate {
	
	public StringLiteralExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("StringLiteralExp"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<String>(this, "stringSymbol") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new StringLiteralTemplate(this);
				}			
			}
		};
	}

}
