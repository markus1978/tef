package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofPropertyTemplate extends ElementTemplate {

	public MofPropertyTemplate(IMetaModelElement metaModel) {
		super(metaModel);
	}

	@Override
	public Template<IModelElement>[] createTemplates() {
		return new Template[] {
				new TerminalTemplate("        "),
				new ReferenceTemplate("type", getMetaModel(), getMetaModel().getType("Type")),
				new TerminalTemplate(" "),
				new IdentifierTemplate("name", getMetaModel()),
				new TerminalTemplate(";\n")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("property... ", "<borken-ref> <unnamed> {\n}\n")
		});
	}
}
