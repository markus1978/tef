package editortest.mof.template;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.SetTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.List;

import editortest.mof.model.MofModelElementImpl;

public class MofClassTemplate extends MofNamedElementTemplate {

	public MofClassTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Class"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new MofIndentationTemplate(this), 
				new TerminalTemplate(this, "class ", TerminalTemplate.KEY_WORD_HIGHLIGHT),		
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},
				new TerminalTemplate(this, " {\n"),				
				new SetTemplate<IModelElement>(this, "ownedAttribute", "\n", true) {
					@Override
					protected ValueTemplate<IModelElement> createElementTemplate() {
						return new MofPropertyTemplate(this);
					}
				},
				new SetTemplate<IModelElement>(this, "ownedOperation", "\n", true) {
					@Override
					protected ValueTemplate createElementTemplate() {
						return new MofOperationTemplate(this);
					}				
				},
				new MofIndentationTemplate(this),
				new TerminalTemplate(this, "}")
		};
	}

	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("class... ", null, 0)
		});
	}
	
	@Override
	public boolean isTemplateFor(IModelElement model) {
		return ((MofModelElementImpl)model).getMofObject() instanceof cmof.UmlClass;
	}
}
