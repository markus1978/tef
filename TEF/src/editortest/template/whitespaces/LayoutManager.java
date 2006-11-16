package editortest.template.whitespaces;

import java.util.Collection;
import java.util.Vector;

import editortest.view.ChangeText;
import editortest.view.ITextStatusListener;
import editortest.view.Text;

public class LayoutManager {
	
	public static final int SPACE = 1;
	public static final int BREAK = 2;
	public static final int INDENT = 3;
	public static final int BEGIN_BLOCK = 4;
	public static final int END_BLOCK = 5;

	private final Collection<Text> fManagedElements = new Vector<Text>();
	
	class LayoutInformation {
		private final int fFunction;

		public LayoutInformation(final int function) {
			super();
			fFunction = function;
		}	
	}
	
	public void registerText(final Text text, int function) {	
		text.addTextStatusListener(new ITextStatusListener() {
			public void hidden() {
				textIsHidden(text);
			}
			public void shown() {
				textIsShown(text);				
			}			
		});
		if (!text.isHidden()) {
			textIsShown(text);
		}
		text.putAttribute(LayoutInformation.class, new LayoutInformation(function));
	}
	
	public void deRegisterText(Text text) {
		fManagedElements.remove(text);
		text.removeAttribute(LayoutInformation.class);
	}
	
	private void textIsShown(Text text) {
		fManagedElements.add(text);
		handleChange();
	}
	
	private void textIsHidden(Text text) {		
		deRegisterText(text);
	}
	
	private void fireChange() {
		handleChange();
	}
	
	private void handleChange() {
		StringBuffer index = new StringBuffer("");
		for (Text text: fManagedElements) {
			LayoutInformation layoutInfo = text.getAttribute(LayoutInformation.class);
			switch (layoutInfo.fFunction) {
				case BEGIN_BLOCK:
					index.append("    ");
					break;
				case END_BLOCK:
					index.replace(index.length() - 5, index.length() - 1, "");
					break;
				case SPACE:
				case BREAK:
					break;
				case INDENT:
					((ChangeText)text).setText(index.toString());
				default:
					throw new RuntimeException("assert");
			}
		}
	}
}
