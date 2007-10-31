package hub.sam.tef.ocl.templates;

import hub.sam.tef.layout.ExpressionLayout;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.EnumerationTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;

public class IteratorExpTemplate1 extends AbstractIteratorExpTemplate {

	public IteratorExpTemplate1(Template template) {
		super(template, "1");	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<IModelElement>(this, "source") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new OclExpressionTemplate(this);
				}				
			},
			new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
			new TerminalTemplate(this, "->"),
			new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new EnumerationTemplate(this, "oclLoops", new String[] { "forAll", "exists", "select", "collect", "any" });
				}				
			},			
			new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
			new TerminalTemplate(this, "("),
			new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
			new SequenceTemplate<IModelElement>(this, "iterator", ",", false) {	
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new VariableTemplate(this);
				}
				@Override
				protected WhitespaceTemplate createSeparatorWhitespace() {
					return new WhitespaceTemplate(this, ExpressionLayout.SPACE_SEPARATOR);
				}				
			},
			new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
			new TerminalTemplate(this, "|"),
			new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
			new SingleValueTemplate<IModelElement>(this, "body") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return ExpTemplate.getExpTemplate(this);
				}				
			},
			new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
			new TerminalTemplate(this, ")")
		};
	}	
}
