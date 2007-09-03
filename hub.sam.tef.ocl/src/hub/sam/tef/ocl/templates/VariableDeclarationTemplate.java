package hub.sam.tef.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.OptionalTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class VariableDeclarationTemplate extends ElementTemplate {

	public VariableDeclarationTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Variable"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {			
					return new IdentifierTemplate(this);
				};
			},
			new SingleValueTemplate<IModelElement>(this, "type") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new OptionalTemplate(this, this.getModel().getMetaElement("EClassifier")) {
							@Override
							public Template[] createOptionTemplate() {
								return new Template[] {
									new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
									new TerminalTemplate(this, ":"),
									new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
									new ReferenceTemplate(this, getModel().getMetaElement("EClassifier")) {
										@Override
										protected ElementTemplate getElementTemplate() {
											return new ElementTemplate(this, this.getModel().getMetaElement("EClassifier")) {
												@Override
												public Template[] createTemplates() {
													return new Template[] {	
															new SingleValueTemplate<String>(this, "name") {
																@Override
																protected ValueTemplate<String> createValueTemplate() {			
																	return new IdentifierTemplate(this);
																};
															}
													};
												}
											};
										}						
									}																
								};
							}				
					};
				}				
			},			
			new SingleValueTemplate<IModelElement>(this, "initExpression") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new OptionalTemplate(this, this.getModel().getMetaElement("OCLExpression")) {
							@Override
							public Template[] createOptionTemplate() {
								return new Template[] {
									new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
									new TerminalTemplate(this, "="),
									new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
									new OclExpressionTemplate(this)																
								};
							}				
					};
				}
			}
		};
	}
	
	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}
	
	@Override
	protected String getAlternativeSymbol() {
		return "VariableDeclaration";
	}	
}
