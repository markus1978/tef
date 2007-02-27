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
import hub.sam.tef.templates.Template;
import hub.sam.util.strings.Changes;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;


public abstract class TEFDocument extends Document {
		
	private hub.sam.tef.views.DocumentText fDocument;
	private TEFEditor fEditor = null;
	private IModel fModel;
	private Template fTopLevelTemplate;
	
	private StringBuffer content = new StringBuffer("");
	private Changes changes = new Changes();
	
	private boolean inTEFMode = true;
	
	public final void setContent(IModel model) {
		this.fModel = model;
		fDocument = createDocument();
		fDocument.update();
	}
	
	/**
	 * Creates the DocumentText for this document. Must also create and set the 
	 * toplevel template for this document.
	 */
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
	
	/**
	 * Overriding the normal eclipse replace methods. This method is used to
	 * propagate user changes to the document to this document. We say this
	 * method handles changes "from above", in contradiction to changes "from
	 * below", which are handles in {@link #doReplace(int, int, String)}.
	 * 
	 * For TEF Phase 1: The changes are put into TextEvent which are processed
	 * through the DocumentText.
	 * 
	 * For TEF Phase 2: Like Phase 1, but if the TextEvent isn't handled: User
	 * changes (key strokes, paste, etc.) are not forwarded to the DocumentText.
	 * They are stored and displayed (as a variation to the DocumentText
	 * content). They are incorporated into the DocumentText when the document
	 * is reconciled. There are two methods
	 * 
	 * a) The document is switched in text-editing mode. All TEF features are
	 * disabled, the content is edited like in a normal text editor.
	 * 
	 * b) It is remembered what areas of the text are changes (only text) and
	 * what are still TEF areas. Events targeted for TEF-areas will still be
	 * guided to the according text objects. This way changes to field with
	 * primitive data, which are normally changed by user input, are still
	 * changes as in phase one, and changes that modify the document structure
	 * are handled by a parser through reconciliation.
	 * 
	 * PROBLEM (only in b): these user change events are modified to empty
	 * changes by the TEFAutoEditStrategy before they arrive here. The reason
	 * is: Eclipse will execute the command in the displayed text (that leads to
	 * cursor movement and text flickering, but is only wrong for TEF Phase 1);
	 * it thinks the changes are already approved and uses this method only to
	 * inform the document about it.
	 * 
	 * SOLUTION (only in b): disable TEFAutoEditStrategies for Phase 2 editors,
	 * because all Text changes should be displayed by eclipse anyway (at this
	 * point phase 2 is even simpler).
	 */
	@Override
	public final void replace(int pos, int length, String text) throws BadLocationException {
		if (inTEFMode) {
			tefReplace(pos, length, text);
		} else {
			eclipseReplace(pos, length, text);
		}
	}
	
	public final void switchModes(boolean toTEF)  {
		if (toTEF != inTEFMode) {
			if (toTEF) {
				try {
					super.replace(0, content.length(), fDocument.getContent());
				} catch (BadLocationException e) {
					throw new RuntimeException(e);
				}
				content = null;		
				System.out.println("Switched to TEF");
			} else {
				content = new StringBuffer(fDocument.getContent());
				System.out.println("Switched to eclipse");
			}
			inTEFMode = toTEF;
		} 
	}
	
	private final void eclipseReplace(int pos, int length, String text) throws BadLocationException {
		content.replace(pos, pos + length, text);
		super.replace(pos, length, text);
	}
	
	private final void tefReplace(int pos, int length, String text) throws BadLocationException {
		if (length == 0 && text.length() == 0) {
			// this event wouldnt change anything
			return;
		}
		int textPos = changes.getIndexBeforeChanges(pos);
		actualReplace = pos;		
		TextEvent textAdd = new TextEvent(this, textPos, textPos+length, text); 				
		HandleEventVisitor visitor = new HandleEventVisitor(textAdd);
		getDocument().process(visitor, textAdd.getBegin());
		if (visitor.getResult()) {
			// event handled
			System.out.println("EVENT HANDLED");
			actualReplace = -1;
		} else {
			// event not handled, store this change, incorperate it into the displayed content
			System.out.println("EVENT NOT HANDLED");
			//Change change = new Change(pos, length, text);
			//changes.addChange(change);
			////content.replace(pos, pos + length, text);
			//super.replace(pos, length, text);
			actualReplace = -1;
			switchModes(false);
			eclipseReplace(pos, length, text);
		}			
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
	
	/**
	 * This is a new method, not known to the eclipse platform. It is used to handle document changes that
	 * were not directly triggered by the user. These changes come from the according DocumentText.
	 * We say this are changes "from below", in contradiction to changes "from above" {@link #replace(int, int, String)}.
	 */
	public final void doReplace(int pos, int length, String text) throws BadLocationException {
		if (!inTEFMode) {
			// not available when not in TEF mode
			throw new RuntimeException("assert");
		}
		//content.replace(pos, pos + length, text);
		////pos = changes.getIndexAfterChanges(pos);
		//StringBuffer newContent = new StringBuffer(content.toString());
		//changes.apply(newContent);
		//super.replace(0, getLength(), newContent.toString());		
		super.replace(pos, length, text);		
		if (actualReplace != -1) {
			if (pos + length < actualReplace) {
				fEditor.addCarretDrift(text.length() - length);
			}
		}	
	}
	
	protected void setTopLevelTemplate(Template template) {
		this.fTopLevelTemplate = template;
	}
	
	public Template getTopLevelTemplate() {
		return fTopLevelTemplate;
	}
	
	public boolean isInTEFMode()  {
		return inTEFMode;
	}
	
	public String getContent() {
		if (inTEFMode) {
			return fDocument.getContent();
		} else {
			return content.toString();
		}
	}
}
