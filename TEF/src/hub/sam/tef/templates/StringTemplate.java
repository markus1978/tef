/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package hub.sam.tef.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.ITextEventListener;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.views.ChangeText;
import hub.sam.tef.views.Text;

public class StringTemplate extends PrimitiveValueTemplate<String>{

	private final String fPattern;
	
	public StringTemplate(Template template) {
		super(template, template.getModel().getType(String.class));	
		fPattern = null;
	}
	
	public StringTemplate(Template template, final String pattern) {
		super(template, template.getModel().getType(String.class));
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

	@Override
	public String getNonTerminal() {
		return "`identifier`";
	}
}
