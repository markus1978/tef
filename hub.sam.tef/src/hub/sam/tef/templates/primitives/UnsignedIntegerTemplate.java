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
package hub.sam.tef.templates.primitives;

import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.Template;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class UnsignedIntegerTemplate extends PrimitiveValueLiteralTemplate<Integer>{
	
	private final Integer fDefaultValue;
	
	public UnsignedIntegerTemplate(Template template, int defaultValue) {
		super(template, template.getModelProvider().getModel().getType(Integer.class));
		fDefaultValue = defaultValue;
	}

	@Override
	public ICommand getCommandToCreateADefaultValue(IModelElement owner, String property, boolean composite) {
		return getModel().getCommandFactory().set(owner, property, fDefaultValue);
	}			
	
	@Override
	protected Object getObjectValueFromStringValue(String value) {
		return new Integer(value);
	}

	@Override
	protected String getNonTerminal() {
		return "`integer`";
	}
	
	@Override
	protected IRule getHightlightRule(IToken token) {
		return new NumberRule(token);
	}

	@Override
	protected TextAttribute getHighlightAttribute() {
		return new TextAttribute(new Color(Display.getCurrent(), new RGB(0,0,160)), 
				null, SWT.NORMAL);
	}		
}
