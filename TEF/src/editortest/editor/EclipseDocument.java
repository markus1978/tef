package editortest.editor;

import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IDocumentRewriteSessionListener;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;

import editortest.mof.model.MofModel;
import editortest.mof.template.TestMofDocument;
import editortest.text.HandleEventVisitor;
import editortest.text.TextEvent;

public class EclipseDocument extends Document {
		
	private editortest.text.Document fDocument;
	private TEFEditor fEditor = null;
	private MofModel fModel;
	
	

	public void setContent(MofModel model) {
		fModel = model;
		fDocument = new TestMofDocument(this);
	}
	
	public void setEditor(TEFEditor viewer) {
		this.fEditor = viewer;
	}

	public editortest.text.Document getDocument() {
		return fDocument;
	}			
	
	public MofModel getModel() {
		return fModel;
	}

	private int actualReplace = -1;	
	
	@Override
	public void replace(int pos, int length, String text) throws BadLocationException {
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
	
	public void doReplace(int pos, int length, String text) throws BadLocationException {
		super.replace(pos, length, text);
		if (actualReplace != -1) {
			int drift = text.length() - length;
			if (pos + length < actualReplace) {
				fEditor.addCarretDrift(text.length() - length);
			}
		}
	}

	@Override
	public void set(String text) {
		super.set(text);
		System.out.println("Document setted!!!");
	}
}
