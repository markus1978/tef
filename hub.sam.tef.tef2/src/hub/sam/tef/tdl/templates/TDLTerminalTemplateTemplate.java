package hub.sam.tef.tdl.templates;

import hub.sam.tef.reconciliation.syntax.BlockLayout;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;
import hub.sam.tef.templates.primitives.StringLiteralTemplate;

public class TDLTerminalTemplateTemplate extends ElementTemplate {

	public TDLTerminalTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLTerminalTemplate"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new WhitespaceTemplate(this, BlockLayout.INDENT),
				new SingleValueTemplate<String>(this, "terminal") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringLiteralTemplate(this);
					}			
				},
				new WhitespaceTemplate(this, BlockLayout.EMPTY),
				new TerminalTemplate(this, ";"),
				new WhitespaceTemplate(this, BlockLayout.STATEMENT),
		};
	}
	
	
}
