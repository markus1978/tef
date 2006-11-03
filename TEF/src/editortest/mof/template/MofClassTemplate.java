package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.CollectionTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;
import editortest.text.Proposal;
import editortest.text.Text;

public class MofClassTemplate extends ElementTemplate {

	public MofClassTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Class"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new MofIndentationTemplate(this), 
				new TerminalTemplate(this, "class "),		
				new IdentifierTemplate(this, getMetaElement(), false),
				new TerminalTemplate(this, " {\n"),				
				new CollectionTemplate<IModelElement>(this, "ownedAttribute", "\n", true) {
					@Override
					protected ValueTemplate<IModelElement> createElementTemplate() {
						return new MofPropertyTemplate(this);
					}
				},
				new CollectionTemplate<IModelElement>(this, "ownedOperation", "\n", true) {
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
