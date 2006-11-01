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
import editortest.text.Proposal;

public class MofClassTemplate extends ElementTemplate {

	public MofClassTemplate(Template template, IModel model) {
		super(template, model, model.getMetaElement("Class"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new MofIndentationTemplate(this), 
				new TerminalTemplate(this, "class "),		
				new IdentifierTemplate(this, getModel(), "name", getMetaElement()),
				new TerminalTemplate(this, " {\n"),				
				new CollectionTemplate(this, getModel(), "ownedAttribute", getMetaElement()) {
					@Override
					public Template getElementTemplate() {
						return new MofPropertyTemplate(this, getModel());
					}	
				},
				new CollectionTemplate(this, getModel(), "ownedOperation", getMetaElement()) {
					@Override
					public Template getElementTemplate() {
						return new MofOperationTemplate(this, getModel());
					}	
				},
				new MofIndentationTemplate(this),
				new TerminalTemplate(this, "}\n")
		};
	}

	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("class... ", null, 0)
		});
	}
	
	@Override
	public boolean isTemplateFor(Object model) {
		return ((MofModelElementImpl)model).getMofObject() instanceof cmof.UmlClass;
	}
}
