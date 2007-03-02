package editortest.mof.template;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SetTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.List;

import editortest.mof.template.MofPropertyTemplate.MyReferenceProposalStrategy;

public class MofLiteralTemplate extends MofNamedElementTemplate {
	
	public MofLiteralTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EnumerationLiteral"));
	}
	

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},				
				new TerminalTemplate(this, ";")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("literal... ", null, 0)
		});
	}

}
