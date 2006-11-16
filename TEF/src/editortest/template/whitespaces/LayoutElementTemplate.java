package editortest.template.whitespaces;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import editortest.template.Template;
import editortest.view.ChangeText;
import editortest.view.FixText;
import editortest.view.Text;


public class LayoutElementTemplate extends Template {

	private final int fFunction;
	private final String fText;
	
	public LayoutElementTemplate(Template template, int function) {
		super(template);
		fFunction = function;
		fText = null;
	}	
	
	public LayoutElementTemplate(Template template, int function, String text) {
		super(template);
		fFunction = function;
		fText = text;
	}

	public Text createView() {
		Text result;
		if (fText == null) {
			result =  new ChangeText();
		} else {
			result = new FixText(fText);
		}
		getLayoutManager().registerText(result, fFunction);
		return result;
	}		
	
	private LayoutManager getLayoutManager() {
		LayoutManager result = getDocument().getAttribute(LayoutManager.class);
		if (result == null) {
			result = new LayoutManager();
			getDocument().putAttribute(LayoutManager.class, result);
		}
		return result;
	}
}
