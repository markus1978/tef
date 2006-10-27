package editortest.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.widgets.Proposal;

public class MofPropertyTemplate extends ElementTemplate {

	public MofPropertyTemplate(IMetaModelElement metaModel) {
		super(metaModel);
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate("        "),
				new ReferenceTemplate("type", getMetaModel()),
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
