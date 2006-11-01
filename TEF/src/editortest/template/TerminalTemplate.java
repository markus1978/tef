package editortest.template;

import editortest.editor.TEFDocument;
import editortest.model.IModelElement;
import editortest.text.FixText;
import editortest.text.Proposal;
import editortest.text.Text;

public class TerminalTemplate extends Template {
	
	private final String fTerminalText;

	public TerminalTemplate(Template template, final String terminalText) {
		super(template);
		fTerminalText = terminalText;
	}

	@Override
	public Text createText(IModelElement model) {
		return new FixText(fTerminalText);
	}

	@Override
	public IModelElement createModelFromProposal(Proposal proposal) {
		// TODO Auto-generated method stub
		return null;
	}		
}
