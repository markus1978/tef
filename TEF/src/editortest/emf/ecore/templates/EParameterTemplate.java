package editortest.emf.ecore.templates;

import java.util.Arrays;
import java.util.List;

import editortest.emf.model.EMFMetaModelElement;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.FlagTemplate;
import hub.sam.tef.templates.LayoutElementTemplate;
import hub.sam.tef.templates.LayoutManager;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class EParameterTemplate extends ElementTemplate {

	public EParameterTemplate (Template template) {
		super(template, template.getModel().getMetaElement("EParameter"));
	}
	
	@Override
	public Template[] createTemplates() {
		return new Template[] {							
				new SingleValueTemplate<String>(this, "eType") {
					@Override
					protected ValueTemplate createValueTemplate() {
						return new ReferenceTemplate(this, getModel().getMetaElement("EClassifier"), null) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new EIdentifierTemplate(this);
							}						
						};
					}					
				},	
				new TerminalTemplate(this, " "),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new IdentifierValueTemplate(this);
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
