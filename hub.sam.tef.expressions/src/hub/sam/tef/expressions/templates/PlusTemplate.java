package hub.sam.tef.expressions.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class PlusTemplate extends ElementTemplate {

	public PlusTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Plus"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<IModelElement>(this, "op1") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ExpressionTemplate(this);
				}				
			},
			new TerminalTemplate(this, "+"),
			new SingleValueTemplate<IModelElement>(this, "op2") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ExpressionTemplate(this);
				}				
			},
		};
	}
	
}
