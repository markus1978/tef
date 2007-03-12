package editortest.emf.ocl.templates;

import java.util.Arrays;
import java.util.List;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.parse.ISyntaxProvider;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ElementTemplateSemantics;
import hub.sam.tef.templates.OptionalTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import editortest.emf.ecore.templates.EIdentifierTemplate;
import editortest.emf.model.EMFMetaModelElement;

public class OperationCallExp1Template extends ElementTemplate {

	public OperationCallExp1Template(Template template) {
		super(template, template.getModel().getMetaElement("OperationCallExp"));	
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
				new SingleValueTemplate<IModelElement>(this, "referredOperation") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {						
						return new ReferenceTemplate(this, getModel().getMetaElement("EOperation"), null) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new EIdentifierTemplate(this);
							}						
						};						
					}					
				},
				new SingleValueTemplate<IModelElement>(this, "argument") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new OclExpressionTemplate(this);
					}				
				},
		};
	}	
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ..." + "[1]", null, 0)
		});
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
			return super.getNonTerminal() + "1";
		}				
	}
}
