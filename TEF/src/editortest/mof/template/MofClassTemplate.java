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

	public MofClassTemplate(IModel model) {
		super(model, model.getMetaElement("Class"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new MofIndentationTemplate(), 
				new TerminalTemplate("class "),		
				new IdentifierTemplate(getModel(), "name", getMetaElement()),
				new TerminalTemplate(" {\n"),				
				new CollectionTemplate(getModel(), "ownedAttribute", getMetaElement()) {
					@Override
					public Template getElementTemplate() {
						return new MofPropertyTemplate(getModel());
					}	
				},
				new CollectionTemplate(getModel(), "ownedOperation", getMetaElement()) {
					@Override
					public Template getElementTemplate() {
						return new MofOperationTemplate(getModel());
					}	
				},
				new MofIndentationTemplate(),
				new TerminalTemplate("}\n")
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
