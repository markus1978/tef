package editortest.emf.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;

public class LetExpTemplate extends ElementTemplate {

	public LetExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("LetExp"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate(this, "let"),
				new WhitespaceTemplate(this, ExpressionLayout.SPACE),
				new SingleValueTemplate<IModelElement>(this, "variable") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new VariableDeclarationTemplate(this);
					}				
				},				
				new WhitespaceTemplate(this, ExpressionLayout.SPACE),
				new TerminalTemplate(this, "in"),
				new WhitespaceTemplate(this, ExpressionLayout.SPACE),
				new SingleValueTemplate<IModelElement>(this, "in") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {						
						return new FactorTemplate(this);					
					}					
				}
		};
	}	
}
