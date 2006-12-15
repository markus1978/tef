package editortest.emf.ecore.templates;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.LayoutElementTemplate;
import hub.sam.tef.templates.LayoutManager;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.List;

import editortest.emf.model.EMFMetaModelElement;

public class EDataTypeTemplate extends ElementTemplate {

	public EDataTypeTemplate (Template template) {
		super(template, template.getModel().getMetaElement("EDataType"));
	}
	
	@Override
	public Template[] createTemplates() {
		return new Template[] {			
				new LayoutElementTemplate(this, LayoutManager.INDENT),	
				new TerminalTemplate(this, "data type", TerminalTemplate.KEY_WORD_HIGHLIGHT),	
				new TerminalTemplate(this, " "),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new IdentifierValueTemplate(this);
					}					
				},
				new TerminalTemplate(this, ";")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}

	@Override
	protected boolean isIdentifierProperty(String property) {
		return property.equals("name");
	}
}
