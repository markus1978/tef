package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.controller.Proposal;
import editortest.model.IModelElement;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.SetTemplate;
import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;

public class MofEnumerationTemplate extends MofNamedElementTemplate {
	
	public MofEnumerationTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Enumeration"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new MofIndentationTemplate(this), 
				new TerminalTemplate(this, "enum ", TerminalTemplate.KEY_WORD_HIGHLIGHT),		
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},
				new TerminalTemplate(this, " {\n"),				
				new SetTemplate<IModelElement>(this, "ownedLiteral", "\n", true) {
					@Override
					protected ValueTemplate<IModelElement> createElementTemplate() {
						return new MofLiteralTemplate(this);
					}
				},
				new MofIndentationTemplate(this),
				new TerminalTemplate(this, "}")
		};
	}

	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("enumeration... ", null, 0)
		});
	}
	
	@Override
	public boolean isTemplateFor(IModelElement model) {
		return ((MofModelElementImpl)model).getMofObject() instanceof cmof.Enumeration;
	}
}
