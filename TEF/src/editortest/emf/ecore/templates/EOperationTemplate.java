package editortest.emf.ecore.templates;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.IntegerTemplate;
import hub.sam.tef.templates.LayoutElementTemplate;
import hub.sam.tef.templates.LayoutManager;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.List;

import editortest.emf.model.EMFMetaModelElement;

public class EOperationTemplate extends ElementTemplate {

	public EOperationTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EOperation"));
	}
	
	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new LayoutElementTemplate(this, LayoutManager.INDENT),				
				new TerminalTemplate(this,  "operation ", TerminalTemplate.KEY_WORD_HIGHLIGHT),
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
				new TerminalTemplate(this, "["),
				new SingleValueTemplate(this, "lowerBound") {
					@Override
					protected ValueTemplate<Integer> createValueTemplate() {
						return new IntegerTemplate(this, 0);
					}					
				},
				new TerminalTemplate(this, ".."),
				new SingleValueTemplate(this, "upperBound") {
					@Override
					protected ValueTemplate<Integer> createValueTemplate() {
						return new IntegerTemplate(this, 1);
					}					
				},
				new TerminalTemplate(this, "] "),							
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new IdentifierValueTemplate(this);
					}					
				},	
				new TerminalTemplate(this, "("),
				new SequenceTemplate<IModelElement>(this, "eParameters", ", ", false, true) {
					@Override					
					protected ValueTemplate createElementTemplate() {
						return new EParameterTemplate(this);						
					}
				},
				new TerminalTemplate(this, ")"),
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}
}
