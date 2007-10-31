package hub.sam.tef.tdl.templates;

import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class TDLWhiteSpaceTemplateTemplate extends ElementTemplate {
	public TDLWhiteSpaceTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLWhiteSpaceTemplate"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new WhitespaceTemplate(this, BlockLayout.INDENT),
			new TerminalTemplate(this, "WS"),
			new WhitespaceTemplate(this, BlockLayout.EMPTY),
			new TerminalTemplate(this, "("),
			new WhitespaceTemplate(this, BlockLayout.EMPTY),
			new SingleValueTemplate<String>(this, "role") {
				@Override
				protected ValueTemplate<String> createValueTemplate() { 
					return new IdentifierTemplate(this);
				}				
			},
			new WhitespaceTemplate(this, BlockLayout.EMPTY),
			new TerminalTemplate(this, ")"),
			new WhitespaceTemplate(this, BlockLayout.EMPTY),
			new TerminalTemplate(this, ";")
		};
	}
}
