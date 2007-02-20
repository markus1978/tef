package editortest.emf.ocl.templates;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.List;

import editortest.emf.model.EMFMetaModelElement;

public class VariableExpTemplate extends ElementTemplate {

	public VariableExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("VariableExp")); 
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new SingleValueTemplate<IModelElement>(this, "referredVariable") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {						
						return new ReferenceTemplate(this, getModel().getMetaElement("Variable"), null) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new VariableTemplate(this);
							}						
						};						
					}				
				}
			};
		}

		@Override
		public List<Proposal> getProposals() {
			return Arrays.asList(new Proposal[] { 
					new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
			});
		}

	
}
