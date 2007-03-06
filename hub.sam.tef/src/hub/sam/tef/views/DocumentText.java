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
package hub.sam.tef.views;

import hub.sam.tef.TEFModelDocument;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.jface.text.BadLocationException;


/**
 * A DocuementText functions as the toplevel text. It is also the interface to
 * the eclipse model (IDocument) and eclipse view (ISourceViewer).
 */
public class DocumentText extends CompoundText {
	
	private final TEFModelDocument fDocument;	
	private final Collection<IDocumentUpdateListener> fListener = new Vector<IDocumentUpdateListener>();
	
	private boolean toBeUpdated = false;
	private int changesBegin = 0;
	private int changesDocumentEnd = 0;
	private int changesTextEnd = 0;
	
	
	public DocumentText(TEFModelDocument document) {
		this.fDocument = document;
	}	
	
	/**
	 * Forwards any change to the document to the eclipse model (IDocument).
	 * This also automatically causes the new content to be displayed by the
	 * eclipse view.
	 */
	@Override
	public void changeContent(int begin, int end, String text) {
		if (getContent(begin, end).equals(text)) {
			return;
		}
		super.changeContent(begin, end, text);
		if (!toBeUpdated) {
			changesBegin = -1;
			changesDocumentEnd = -1;
			changesTextEnd = -1;
			toBeUpdated = true;
		}
		if (begin < changesBegin || changesBegin == -1) {
			changesBegin = begin;
		}		
		
		if (changesDocumentEnd == -1 || changesTextEnd == -1) {
			changesDocumentEnd = end;
			changesTextEnd = end;
		} else {			
			if (end > changesTextEnd) {
				changesDocumentEnd += end - changesTextEnd;			
			}			
		}
		changesTextEnd += text.length() - (end - begin);
	}
	
	public void addDocumentUpdateListener(IDocumentUpdateListener listener) {
		fListener.add(listener);
	}
	
	public void update() {
		if (toBeUpdated) {
			try {					
				for (IDocumentUpdateListener listener: fListener) {
					listener.documentAboutToBeUpdated(this);
				}
				fDocument.doReplace(changesBegin, changesDocumentEnd - changesBegin, getContent(changesBegin, changesTextEnd));
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			toBeUpdated = false;
		}
	}
}
