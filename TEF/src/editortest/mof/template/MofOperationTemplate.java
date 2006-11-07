package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IModelElement;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.SequenceTemplate;
import editortest.template.SingleValueTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;
import editortest.text.visitors.Proposal;

public class MofOperationTemplate extends ElementTemplate {		
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
						return new ReferenceTemplate(this, getModel().getMetaElement("Type"), null);
					}					
				},				
				new TerminalTemplate(this, " "),
				new IdentifierTemplate(this, getMetaElement(), false),
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
