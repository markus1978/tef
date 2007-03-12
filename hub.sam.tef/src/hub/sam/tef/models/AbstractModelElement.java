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
package hub.sam.tef.models;

import hub.sam.tef.models.extensions.ModelElementExtension;
import hub.sam.tef.views.ITextStatusListener;
import hub.sam.tef.views.Text;
import hub.sam.util.container.MultiMap;

public abstract class AbstractModelElement extends ModelElementExtension {
	
	private static final MultiMap<Object, Text> fOccurences = new MultiMap<Object, Text>();		
	
	public AbstractModelElement(Object id) {
		super(id);
	}

	public final void registerOccurence(final Text text) {
		text.addTextStatusListener(new ITextStatusListener() {
			public void hidden() {				
				fOccurences.get(AbstractModelElement.this).remove(text);				
			}

			public void shown() {
				fOccurences.get(AbstractModelElement.this).add(text);				
			}

			public void disposed() {
				hidden();
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
