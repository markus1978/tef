package hub.sam.tef.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.ITextEventListener;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.views.ChangeText;
import hub.sam.tef.views.Text;

public class IntegerTemplate extends ValueTemplate<Integer>{
	
	private final Integer fDefaultValue;
	
	public IntegerTemplate(Template template, int defaultValue) {
		super(template);
		fDefaultValue = defaultValue;
	}
	

	@Override
	public Text createView(Integer model, final IValueChangeListener<Integer> changeListener) {
		ChangeText result = new ChangeText();
		if (model == null) {
			model = fDefaultValue;
		}
		result.setText(model.toString());
		result.addElement(ITextEventListener.class, new ITextEventListener() {
			public boolean handleEvent(Text text, TextEvent event) {
				if (!((ChangeText)text).isNull()) {
					StringBuffer value = new StringBuffer(text.getContent());
					value.replace(event.getBegin(), event.getEnd(), event.getText());					
					changeListener.valueChanges(new Integer(value.toString()));
				} else {
					changeListener.valueChanges(new Integer(event.getText()));
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
		return value.matches("[0-9]+");
	}

	@Override
	public void updateView(Text view, Integer value) {
		((ChangeText)view).setText(value.toString());
	}		

}
