package hub.sam.tef.expressions.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class UnaryOperatorTemplate extends ElementTemplate {

	private final String operatorSymbol;
	
	public UnaryOperatorTemplate(Template template, String metaClassName, String operatorSymbol) {
		super(template, template.getModel().getMetaElement(metaClassName));
		this.operatorSymbol = operatorSymbol;
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new TerminalTemplate(this, operatorSymbol),
			new SingleValueTemplate<IModelElement>(this, "op") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ExpressionTemplate(this);
				}				
			},
		};
	}
	
}
