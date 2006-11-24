package editortest.template;

import hub.sam.tef.views.FixText;
import hub.sam.tef.views.Text;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;


/**
 * Terminal templates create simple fix views. Can be used for
 * terminals, like keywords, parathesis, whitespaces, etc.
 */
public class TerminalTemplate extends Template {
	
	public static final TextAttribute KEY_WORD_HIGHLIGHT = new TextAttribute(
			Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA), null, SWT.BOLD);
	public static final TextAttribute FLAG_HIGHLIGHT = new TextAttribute(
			Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN), null, SWT.BOLD);
	
	private final String fTerminalText;
	private final TextAttribute fHighlight;

	public TerminalTemplate(Template template, final String terminalText) {
		super(template);
		fTerminalText = terminalText;
		fHighlight = null;
	}

	/**
	 * @param terminalText
	 *            The string that views of this template will show.
	 * @param highlight
	 *            The TextAttribute that will be automatically applied to the
	 *            view, use it for syntax highlighting.
	 */
	public TerminalTemplate(Template template, final String terminalText, final TextAttribute highlight) {
		super(template);
		fTerminalText = terminalText;
		fHighlight = highlight;
	}

	public Text createView() {
		Text result =  new FixText(fTerminalText);
		if (fHighlight != null) {
			result.setElement(TextAttribute.class, fHighlight);
		}
		return result;
	}		
}
