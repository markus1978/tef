package hub.sam.tef.ocl.templates;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ElementTemplateSemantics;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;

public class MulTemplate extends ElementTemplate {

	public MulTemplate(Template template) {
		super(template, template.getModel().getMetaElement("OperationCallExp"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new SingleValueTemplate<IModelElement>(this, "source") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new TermTemplate(this);
					}				
				},			
				new WhitespaceTemplate(this, ExpressionLayout.SPACE),
				new SingleValueTemplate<IModelElement>(this, "referredOperation") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {						
						return new ReferenceTemplate(this, getModel().getMetaElement("EOperation"), "mulOps_ref") {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new OperandIdentifierTemplate(this, "mulOps", 
										operationNames.toArray(new String[] {}));
							}						
						};						
					}					
				},					
				new WhitespaceTemplate(this, ExpressionLayout.SPACE),
				new SingleValueTemplate<IModelElement>(this, "argument") {				
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new FactorTemplate(this);
					}				
				}				
		};
	}		
	
	private static final Collection<String> operationNames = Arrays.asList(new String[] {
			"*", "/", "div", "=", ">=", "<=", "<>", ">", "<", "and", "xor", "implies"
	});
	
	@Override
	public boolean isTemplateFor(IModelElement model) {
		IModelElement operation = (IModelElement)model.getValue("referredOperation");
		if (operation != null) {
			String name = (String)operation.getValue("name");
			if (name != null && operationNames.contains(name)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter) {
			return (T)new MySyntaxProvider(this);
		} else {
			return super.getAdapter(adapter);
		}
	}
	
	class MySyntaxProvider extends ElementTemplateSemantics {
		public MySyntaxProvider(ElementTemplate elementTemplate) {
			super(elementTemplate);		
		}
		
		@Override
		public String getNonTerminal() {	
			return "Mul";
		}				
	}
}
