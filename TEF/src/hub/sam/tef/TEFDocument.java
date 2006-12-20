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
package hub.sam.tef;

import hub.sam.tef.controllers.HandleEventVisitor;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.models.IModel;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;


public abstract class TEFDocument extends Document {
		
	private hub.sam.tef.views.DocumentText fDocument;
	private TEFEditor fEditor = null;
	private IModel fModel;
	
	public final void setContent(IModel model) {
		this.fModel = model;
		fDocument = createDocument();
		fDocument.update();
	}
	
	public abstract hub.sam.tef.views.DocumentText createDocument();
	
	public final void setEditor(TEFEditor editor, TEFSourceViewer viewer) {
		this.fEditor = editor;
		fDocument.setViewer(viewer);
	}
		
	public TEFEditor getEditor() {
		return fEditor;
	}

	public final hub.sam.tef.views.DocumentText getDocument() {
		return fDocument;
	}			
	
	public final IModel getModel() {
		return fModel;
	}

	private int actualReplace = -1;	
	
	@Override
	public final void replace(int pos, int length, String text) throws BadLocationException {
		actualReplace = pos;		
		TextEvent textAdd = new TextEvent(this, pos, pos+length, text); 				
		HandleEventVisitor visitor = new HandleEventVisitor(textAdd);
		getDocument().process(visitor, textAdd.getBegin());
		
		actualReplace = -1;
	}
	
	class Replace {
		int pos; int length; String text;
		public Replace(int pos, int length, String text) {
			super();
			this.pos = pos;
			this.length = length;
			this.text = text;
		}		
	}
	
	public final void doReplace(int pos, int length, String text) throws BadLocationException {
		super.replace(pos, length, text);		
		if (actualReplace != -1) {
			if (pos + length < actualReplace) {
				fEditor.addCarretDrift(text.length() - length);
			}
		}	
	}
}
