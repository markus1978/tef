package editortest.editor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.Region;

import editortest.model.IModel;
import editortest.text.Text;
import editortest.text.TextEvent;
import editortest.text.visitors.HandleEventVisitor;

public abstract class TEFDocument extends Document {
		
	private final Map<Object, List<Text>> fOccurencesByModel = new HashMap<Object, List<Text>>();
	private final Map<Text, Object> fOccurencesByView = new HashMap<Text, Object>();
	private editortest.text.Document fDocument;
	private TEFEditor fEditor = null;
	private IModel fModel;
	
	public final void setContent(IModel model) {
		this.fModel = model;
		fDocument = createDocument();
	}
	
	public abstract editortest.text.Document createDocument();
	
	public final void setEditor(TEFEditor viewer) {
		this.fEditor = viewer;
	}

	public final editortest.text.Document getDocument() {
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

	@Override
	public final void set(String text) {
		super.set(text);
		System.out.println("Document setted!!!");
	}

	public final void addOccurence(Object model, Text view) {
		List<Text> occurecnesOfModel = fOccurencesByModel.get(model);
		if (occurecnesOfModel == null) {
			occurecnesOfModel = new Vector<Text>();
			fOccurencesByModel.put(model, occurecnesOfModel);
		}
		occurecnesOfModel.add(view);
		fOccurencesByView.put(view, model);
	}
	
	public final void removeOccurence(Text view) {
		Object model = fOccurencesByView.get(view);
		if (model != null) {
			List<Text> occurecnesOfModel = fOccurencesByModel.get(model);		
			occurecnesOfModel.remove(view);
			fOccurencesByView.remove(view);
		}				
	}
	
	public final Region[] getOccurence(Text acutalView) {
		Object model = fOccurencesByView.get(acutalView);
		if (model == null) {
			return new Region[0];
		} else {
			List<Text> occurences = fOccurencesByModel.get(model);
			int size = occurences.size();
			Region[] result = new Region[size];
			for (int i = 0; i < size; i++) {
				Text occurence = occurences.get(i);
				int offset = occurence.getAbsolutOffset(0);
				result[i] = new Region(offset, occurence.getLength());
			}
			return result;
		}
	}
}
