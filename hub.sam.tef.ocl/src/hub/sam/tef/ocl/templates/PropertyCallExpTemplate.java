package hub.sam.tef.ocl.templates;

import hub.sam.tef.layout.ExpressionLayout;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;

public class PropertyCallExpTemplate extends ElementTemplate {

	public PropertyCallExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("PropertyCallExp"));	
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
				new TerminalTemplate(this, "."),
				new WhitespaceTemplate(this, ExpressionLayout.EMTPY),
				new SingleValueTemplate<IModelElement>(this, "referredProperty") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {						
						return new ReferenceTemplate(this, getModel().getMetaElement("EStructuralFeature")) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new EIdentifierTemplate(this);
							}						
						};						
					}					
				}
		};
	}	
}
