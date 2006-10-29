package editortest.template;

import java.util.Arrays;
import java.util.List;

import editortest.text.FixText;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;

public class TerminalTemplate extends Template {
	
	private final String fTerminalText;

	public TerminalTemplate(final String terminalText) {
		super();
		fTerminalText = terminalText;
	}

	@Override
	public Text createText(Object model) {
		return new FixText(fTerminalText);
	}

	@Override
	public Object createModelFromEvent(TextEvent event) {
		// TODO Auto-generated method stub
		return null;
	}			
}
