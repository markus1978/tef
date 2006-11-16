package editortest.template;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import editortest.view.FixText;
import editortest.view.Text;

public class TerminalTemplate extends Template {
	
	private final String fTerminalText;

	public TerminalTemplate(Template template, final String terminalText) {
		super(template);
		fTerminalText = terminalText;
	}

	public Text createView() {
		Text result =  new FixText(fTerminalText);
		result.putAttribute(TextAttribute.class, new TextAttribute(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), 
				null, SWT.BOLD));
		return result;
	}		
}
