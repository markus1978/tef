package editortest.model;

import hub.sam.util.MultiMap;

import editortest.text.ITextStatusListener;
import editortest.text.Text;

public abstract class AbstractModelElement implements IModelElement {

	public static final String OCCURENCE_MODEL = "occurecne-model";
	
	private static final MultiMap<Object, Text> fOccurences = new MultiMap<Object, Text>();
	
	public void registerOccurence(final Text text) {
		text.addTextStatusListener(new ITextStatusListener() {
			public void hidden() {				
				fOccurences.get(AbstractModelElement.this).remove(text);				
			}

			public void shown() {
				fOccurences.get(AbstractModelElement.this).add(text);				
			}			
			
		});
		text.putAttachment(OCCURENCE_MODEL, this);
		if (!text.isHidden()) {					
			fOccurences.get(this).add(text);
		}
	}

	public Text[] getRegisteredOccureces() {
		return (Text[])fOccurences.get(this).toArray(new Text[] {});
	}
	
}
