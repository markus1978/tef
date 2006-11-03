package editortest.template;

import editortest.text.FixText;
import editortest.text.Text;

public class TerminalTemplate extends Template {
	
	private final String fTerminalText;

	public TerminalTemplate(Template template, final String terminalText) {
		super(template);
		fTerminalText = terminalText;
	}

	public Text createView() {
		return new FixText(fTerminalText);
	}		
}
