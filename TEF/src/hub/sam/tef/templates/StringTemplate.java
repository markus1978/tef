package hub.sam.tef.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.ITextEventListener;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.views.ChangeText;
import hub.sam.tef.views.Text;

public class StringTemplate extends ValueTemplate<String>{

	private final String fPattern;
	
	public StringTemplate(Template template) {
		super(template);	
		fPattern = null;
	}
	
	public StringTemplate(Template template, final String pattern) {
		super(template);
		fPattern = pattern;
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
				if (((ChangeText)text).isNull()) {
					return verifyValue(event.getText());
				} else {
					StringBuffer value = new StringBuffer(text.getContent());				
					value.replace(event.getBegin(), event.getEnd(), event.getText());
					return verifyValue(value.toString());
				}
			}			
		});	
		result.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));
		return result;
	}
	
	protected boolean verifyValue(String value) {
		if (fPattern == null) {
			return true;
		} else {
			return value.matches(fPattern);
		}
	}

	@Override
	public void updateView(Text view, String value) {
		((ChangeText)view).setText(value);
	}		

}
