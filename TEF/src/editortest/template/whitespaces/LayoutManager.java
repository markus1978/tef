package editortest.template.whitespaces;

import java.util.Collection;
import java.util.HashSet;

import editortest.view.ChangeText;
import editortest.view.DocumentText;
import editortest.view.IDocumentUpdateListener;
import editortest.view.ITextStatusListener;
import editortest.view.Text;

public class LayoutManager {
	
	public static final int SPACE = 1;
	public static final int BREAK = 2;
	public static final int INDENT = 3;
	public static final int BEGIN_BLOCK = 4;
	public static final int END_BLOCK = 5;

	private final Collection<Text> fManagedElements = new HashSet<Text>();
	private final DocumentText fDocument;
	
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
		text.setElement(LayoutInformation.class, new LayoutInformation(function));
	}
	
	public void deRegisterText(Text text) {
		fManagedElements.remove(text);
		text.removeElement(LayoutInformation.class);
	}
	
	private void textIsShown(Text text) {
		fManagedElements.add(text);
	}
	
	private void textIsHidden(Text text) {		
		deRegisterText(text);
	}
	
	private String getIndent(int depth) {
		StringBuffer result = new StringBuffer("");
		for (int i = 0; i < depth; i++) {
			result.append("    ");
		}
		return result.toString();
	}
	
	private boolean inChange = false;
	
	public void handleChange() {
		if (inChange) {
			return;
		} 
		inChange = true;
		int depth = 0;		
		Text runningText = fDocument.first();
		Text lastText = null;
		while(runningText != lastText) {
			lastText = runningText;
			if (fManagedElements.contains(runningText)) {
				LayoutInformation layoutInfo = runningText.getElement(LayoutInformation.class);			
				switch (layoutInfo.fFunction) {
					case BEGIN_BLOCK:
						depth++;
						break;
					case END_BLOCK:
						depth--;
						break;
					case SPACE:
					case BREAK:
						break;
					case INDENT:
						((ChangeText)runningText).setText(getIndent(depth));
						break;
					default:
						throw new RuntimeException("assert");
				}
			}
			runningText = runningText.nextText();
		}
		inChange = false;
	}

	public LayoutManager(final DocumentText document) {
		super();
		fDocument = document;
		fDocument.addDocumentUpdateListener(new IDocumentUpdateListener() {
			public void documentAboutToBeUpdated(DocumentText text) {
				handleChange();
			}			
		});
	}
}
