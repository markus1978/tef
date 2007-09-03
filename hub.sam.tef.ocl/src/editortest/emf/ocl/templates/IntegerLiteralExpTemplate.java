package editortest.emf.ocl.templates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.IntegerTemplate;

public class IntegerLiteralExpTemplate extends ElementTemplate {
	
	public IntegerLiteralExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("IntegerLiteralExp"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<Integer>(this, "integerSymbol") {
				@Override
				protected ValueTemplate<Integer> createValueTemplate() {
					return new IntegerTemplate(this, 0);
				}			
			}
		};
	}
}
