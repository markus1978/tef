package editortest.text;

import editortest.template.text.IdentifierText;

public final class ComputeSelectionVisitor extends AbstractOffsetBasedVisitor {

	private Text result = null;
		
	public ComputeSelectionVisitor(final int forOffset) {
		super(forOffset);				
	}
	
	private void selectText(Text selectedText) {		
		result = selectedText;
	}

	public void visitText(Text visitedText, int atOffset) {
		if (visitedText instanceof IdentifierText) {
			selectText(visitedText);
		}
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		if (result == null) {
			selectText(visitedText);
		}
	}	
	
	public Text getResult() {
		return result;
	}
}
