package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofPrimitiveTypeTemplate extends ElementTemplate {

	public MofPrimitiveTypeTemplate(IMetaModelElement metaModel) {
		super(metaModel);
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new TerminalTemplate("    primitive "),		
				new IdentifierTemplate("name", getMetaModel()),
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
