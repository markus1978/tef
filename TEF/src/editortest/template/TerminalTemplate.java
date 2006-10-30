package editortest.template;

import editortest.model.IModelElement;
import editortest.text.FixText;
import editortest.text.Text;
import editortest.text.TextEvent;

public class TerminalTemplate extends Template {
	
	private final String fTerminalText;

	public TerminalTemplate(final String terminalText) {
		super();
		fTerminalText = terminalText;
	}

	@Override
	public Text createText(IModelElement model) {
		return new FixText(fTerminalText);
	}

	@Override
	public IModelElement createModelFromEvent(TextEvent event) {
		// TODO Auto-generated method stub
		return null;
	}			
}
