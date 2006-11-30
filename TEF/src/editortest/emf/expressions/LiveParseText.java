package editortest.emf.expressions;

import hub.sam.tef.controllers.ITextEventListener;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.views.ChangeText;
import hub.sam.tef.views.Text;

public class LiveParseText extends ChangeText {

	public StringBuffer content;
	
	public LiveParseText() {
		content = new StringBuffer("");
		setText("");
		
		addElement(ITextEventListener.class, new ITextEventListener() {
			public boolean handleEvent(Text text, TextEvent event) {
				content.replace(event.getBegin(), event.getEnd(), event.getText());
				setText(content.toString());
				update();
				return true;
			}
			public boolean verifyEvent(Text text, TextEvent event) {
				return true;
			}			
		});
	}
	
}
