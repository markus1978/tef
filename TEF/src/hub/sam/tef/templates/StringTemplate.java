package hub.sam.tef.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.ITextEventListener;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.views.ChangeText;
import hub.sam.tef.views.Text;

public class StringTemplate extends ValueTemplate<String>{

	public StringTemplate(Template template) {
		super(template);	
	}
	
	protected boolean verify(String model) {
		return true;
	}

	@Override
	public Text createView(String model, final IValueChangeListener<String> changeListener) {
		ChangeText result = new ChangeText();
		result.setText(model);
		result.addElement(ITextEventListener.class, new ITextEventListener() {
			public boolean handleEvent(Text text, TextEvent event) {
				if (!((ChangeText)text).isNull()) {
					StringBuffer value = new StringBuffer(text.getContent());
					value.replace(event.getBegin(), event.getEnd(), event.getText());
					changeListener.valueChanges(value.toString());
				} else {
					changeListener.valueChanges(event.getText());
				}							
				return true;
			}
			public boolean verifyEvent(Text text, TextEvent event) {
				return verify(event.getText());
			}			
		});	
		result.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));
		return result;
	}

	@Override
	public void updateView(Text view, String value) {
		((ChangeText)view).setText(value);
	}		

}
