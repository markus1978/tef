package hub.sam.tef.models;

import hub.sam.tef.views.ITextStatusListener;
import hub.sam.tef.views.Text;
import hub.sam.util.MultiMap;

public abstract class AbstractModelElement implements IModelElement {
	
	private static final MultiMap<Object, Text> fOccurences = new MultiMap<Object, Text>();	
	
	public final void registerOccurence(final Text text) {
		text.addTextStatusListener(new ITextStatusListener() {
			public void hidden() {				
				fOccurences.get(AbstractModelElement.this).remove(text);				
			}

			public void shown() {
				fOccurences.get(AbstractModelElement.this).add(text);				
			}			
			
		});
		text.setElement(AbstractModelElement.class, this);
		if (!text.isHidden()) {					
			fOccurences.get(this).add(text);
		}
	}

	public final Text[] getRegisteredOccureces() {
		return (Text[])fOccurences.get(this).toArray(new Text[] {});
	}
}
