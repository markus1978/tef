package editortest.emf.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;
import editortest.emf.ecore.templates.EIdentifierTemplate;

public class OperationCallExp1Template extends AbstractOperationCallExpTemplate {

	public OperationCallExp1Template(Template template) {
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
				new SingleValueTemplate<IModelElement>(this, "referredOperation") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {						
						return new ReferenceTemplate(this, getModel().getMetaElement("EOperation")) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new EIdentifierTemplate(this);
							}						
						};						
					}					
				},
				new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
				new TerminalTemplate(this, "("),
				new SequenceTemplate<IModelElement>(this, "argument", ",", false) {				
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return ExpTemplate.getExpTemplate(this);
					}				
				},
				new TerminalTemplate(this, ")")
		};
	}	
}
