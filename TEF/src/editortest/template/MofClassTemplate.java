package editortest.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.widgets.Proposal;
import editortest.widgets.TextEvent;

public class MofClassTemplate extends ElementTemplate {

	public MofClassTemplate(IMetaModelElement metaModel) {
		super(metaModel);
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new TerminalTemplate("    class "),		
				new IdentifierTemplate("name", getMetaModel()),
				new TerminalTemplate(" {\n"),
				new ListTemplate("ownedAttribute", getMetaModel()) {
					@Override
					public Template getElementTemplate() {
						return new MofPropertyTemplate(getMetaModel().getType("Property"));
					}	
				},
				new TerminalTemplate("    }\n")
		};
	}

	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("class... ", "class <unnamed> {\n}\n")
		});
	}
	
}
