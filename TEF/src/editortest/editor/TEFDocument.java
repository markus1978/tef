package editortest.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;

import editortest.controller.HandleEventVisitor;
import editortest.controller.TextEvent;
import editortest.model.IModel;

public abstract class TEFDocument extends Document {
		
	private editortest.text.DocumentText fDocument;
	private TEFEditor fEditor = null;
	private IModel fModel;
	
	public final void setContent(IModel model) {
		this.fModel = model;
		fDocument = createDocument();
	}
	
	public abstract editortest.text.DocumentText createDocument();
	
	public final void setEditor(TEFEditor viewer) {
		this.fEditor = viewer;
	}

	public final editortest.text.DocumentText getDocument() {
		return fDocument;
	}			
	
	public final IModel getModel() {
		return fModel;
	}

	private int actualReplace = -1;	
	
	@Override
	public final void replace(int pos, int length, String text) throws BadLocationException {
		actualReplace = pos;		
		TextEvent textAdd = new TextEvent(this, pos, pos+length, text); 				
		HandleEventVisitor visitor = new HandleEventVisitor(textAdd);
		getDocument().process(visitor, textAdd.getBegin());
		
		actualReplace = -1;
	}
	
	class Replace {
		int pos; int length; String text;
		public Replace(int pos, int length, String text) {
			super();
			this.pos = pos;
			this.length = length;
			this.text = text;
		}		
	}
	
	public final void doReplace(int pos, int length, String text) throws BadLocationException {
		super.replace(pos, length, text);		
		if (actualReplace != -1) {
			int drift = text.length() - length;
			if (pos + length < actualReplace) {
				fEditor.addCarretDrift(text.length() - length);
			}
		}		
	}
}
