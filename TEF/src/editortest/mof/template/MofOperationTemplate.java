package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import cmof.Operation;

import editortest.model.IModel;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.CollectionTemplate;
import editortest.template.SequenceTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofOperationTemplate extends ElementTemplate {		
	public MofOperationTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Operation"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this),
				new ReferenceTemplate(this, "type", getModel().getMetaElement("Type")),				
				new TerminalTemplate(this, " "),
				new IdentifierTemplate(this, getMetaElement(), false),
				new TerminalTemplate(this, "("),				
				new SequenceTemplate(this, "formalParameter",  ", ", false) {
					@Override
					public Template createElementTemplate() {
						return new MofParameterTemplate(this);
					}					
				},
				new TerminalTemplate(this, ");\n")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("operation... ", null, 0)
		});
	}
		
}
