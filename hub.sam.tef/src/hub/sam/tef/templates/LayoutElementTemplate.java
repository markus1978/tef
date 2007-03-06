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

import hub.sam.tef.views.ChangeText;
import hub.sam.tef.views.FixText;
import hub.sam.tef.views.Text;

public class LayoutElementTemplate extends TerminalTemplate {

	private final int fFunction;
	private final String fText;
	
	public LayoutElementTemplate(Template template, int function) {
		super(template, "");
		fFunction = function;
		fText = null;
	}	
	
	public LayoutElementTemplate(Template template, int function, String text) {
		super(template, text);
		fFunction = function;
		fText = text;
	}

	public Text createView() {
		Text result;
		if (fText == null) {
			result =  new ChangeText();
		} else {
			result = new FixText(fText);
		}
		getModelProvider().getLayoutManager().registerText(result, fFunction);
		return result;
	}		
	
	/*
	private LayoutManager getLayoutManager() {
		LayoutManager result = getDocument().getElement(LayoutManager.class);
		if (result == null) {
			result = new LayoutManager(getDocument());
			getDocument().setElement(LayoutManager.class, result);
		}
		return result;
	}
	*/
}
