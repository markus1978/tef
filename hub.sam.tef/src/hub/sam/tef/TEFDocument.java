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

import hub.sam.tef.views.DocumentText;
import hub.sam.util.strings.Change;
import hub.sam.util.strings.Changes;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;

/**
 * This class represent TEF documents as eclipse text documents
 * {@link IDocument}. In other words it wrapped a TEF text structures, starting
 * with a {@link DocumentText}, into an eclipse interface.
 * 
 * Instances of this class can run in two modi. One the TEF mode (the normal and
 * starting mode). All changes to the document caused by the eclipse editor
 * (user keystrokes mostly) are translated into TEF events. If these events can
 * be handled by TEF, nothing happens here. TEF will change the underlying
 * model, according listeners will change the TEF text structure, an according
 * updates will call {@link #doReplace(int, int, String)} in this class, which
 * forwards the changes to the eclipse editor. If an event can't be handled,
 * this document switched into the eclipse mode. In this mode the documents acts
 * like a normal eclipse document. It is now the responsibility of the installed
 * TEF reconciler to parse the current editor content at appropriate times and
 * finally change the model and therefore the TEX text structure. The TEF
 * reconciler is also responsibly to switch this document back into TEF mode. In
 * eclipse mode this document does not present the TEF text structure, but a
 * normal StringBuffer based string content.
 * 
 * This document is a document per editor. This is completly wrong. It should be separated from
 * a concrete editor instance.
 */
public class TEFDocument extends Document {	
	
	public static IDocument createDocumentForModelDocument(TEFModelDocument modelDocument) {
		return new TEFDocument(modelDocument);
	}
	
	private final TEFModelDocument fModelDocument;
	
	private StringBuffer content = null;	
	private Changes changes = null;	
	private boolean inTEFMode = true;
	
	private boolean disturbed = true;
	
	private TEFDocument(TEFModelDocument modelDocument) {
		this.fModelDocument = modelDocument;
		modelDocument.setEclipseDocument(this);
	}
	
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
		postReconcilitation();
		if (inTEFMode) {
			fModelDocument.replace(pos, length, text);
		} else {
			eclipseReplace(pos, length, text);
		}
	}
	
	/**
	 * This is a new method, not known to the eclipse platform. It is used to handle document changes that
	 * were not directly triggered by the user. These changes come from the according DocumentText.
	 * We say this are changes "from below", in contradiction to changes "from above" {@link #replace(int, int, String)}.
	 */
	public final void doReplace(int pos, int length, String text) throws BadLocationException {
		super.replace(pos, length, text);
	}
	
	public final void switchModes(boolean toTEF)  {
		if (toTEF != inTEFMode) {
			if (toTEF) {
				try {
					super.replace(0, content.length(), fModelDocument.getContent());
				} catch (BadLocationException e) {
					throw new RuntimeException(e);
				}
				content = null;		
				changes = null;
				System.out.println("Switched to TEF");
			} else {
				changes = new Changes();
				content = new StringBuffer(fModelDocument.getContent());
				System.out.println("Switched to eclipse");
			}
			inTEFMode = toTEF;
		} 
	}
	
	private synchronized final void eclipseReplace(int pos, int length, String text) throws BadLocationException {
		disturbed = true;
		content.replace(pos, pos + length, text);
		changes.addChange(new Change(pos, length, text));
		super.replace(pos, length, text);
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
	
	public boolean isInTEFMode()  {
		return inTEFMode;
	}
	
	public String getContent() {
		if (inTEFMode) {
			return fModelDocument.getContent();
		} else {
			return content.toString();
		}
	}
	
	public Changes getChanges() {
		return this.changes;
	}
	
	public TEFModelDocument getModelDocument() {
		return fModelDocument;
	}
	
	public synchronized void startReconciliation() {
		disturbed = false;
	}
	
	public synchronized boolean stopReconciliation() {
		if (!disturbed) {					
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized void postReconcilitation() {
		if (!disturbed) {
			switchModes(true);
			try {
				super.replace(0, getLength(), "");
			} catch (BadLocationException ex) {
				throw new RuntimeException(ex);
			}
			content = new StringBuffer();			
			this.fModelDocument.initializeContent();			
			disturbed = true;
		}
	}
}
