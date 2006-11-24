package editortest.mof.template;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.List;


public class MofOperationTemplate extends MofNamedElementTemplate {		
	public MofOperationTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Operation"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this),
				new SingleValueTemplate<IModelElement>(this, "type") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new ReferenceTemplate(this, getModel().getMetaElement("Type"), null) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new MofIdentifierTemplate(this);
							}							
						};
					}					
				},				
				new TerminalTemplate(this, " "),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},
				new TerminalTemplate(this, "("),				
				new SequenceTemplate<IModelElement>(this, "formalParameter",  ", ", false) {
					@Override
					public ValueTemplate<IModelElement> createElementTemplate() {
						return new MofParameterTemplate(this);
					}					
				},
				new TerminalTemplate(this, ");")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("operation... ", null, 0)
		});
	}
}
