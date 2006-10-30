package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofPrimitiveTypeTemplate extends ElementTemplate {

	public MofPrimitiveTypeTemplate(IModel model) {
		super(model, model.getMetaElement("PrimitiveType"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new MofIndentationTemplate(), 
				new TerminalTemplate("primitive "),		
				new IdentifierTemplate(getModel(), "name", getMetaElement()),
				new TerminalTemplate(";\n")				
		};
	}

	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("primitive... ", "primitive <unnamed> {\n}\n")
		});
	}
	
	@Override
	public boolean isTemplateFor(Object model) {
		return ((MofModelElementImpl)model).getMofObject() instanceof cmof.PrimitiveType;
	}
}
