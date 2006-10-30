package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import cmof.Operation;

import editortest.model.IModel;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.ListTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofOperationTemplate extends ElementTemplate {		
	public MofOperationTemplate(IModel model) {
		super(model, model.getMetaElement("Operation"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(),
				new ReferenceTemplate(getModel(), "type", 
						getMetaElement(), 
						getModel().getMetaElement("Type")),
				new TerminalTemplate(" "),
				new IdentifierTemplate(getModel(), "name", getMetaElement()),
				new TerminalTemplate("("),				
				new ListTemplate(getModel(), "formalParameter", getMetaElement()) {
					@Override
					public Template getElementTemplate() {
						return new MofParameterTemplate(getModel());
					}					
				},
				new TerminalTemplate(");\n")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("operation... ", "<borken-ref> <unnamed>();")
		});
	}
		
}
