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
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.IDocumentUpdateListener;
import hub.sam.tef.views.ITextStatusListener;
import hub.sam.tef.views.Text;

import java.util.Collection;
import java.util.HashSet;


public class LayoutManager {
	
	public static final int SPACE = 1;
	public static final int BREAK = 2;
	public static final int INDENT = 3;
	public static final int BEGIN_BLOCK = 4;
	public static final int END_BLOCK = 5;

	private final Collection<Text> fManagedElements = new HashSet<Text>();
	private final DocumentText fDocument;
	
	class LayoutInformation {
		private final int fFunction;

		public LayoutInformation(final int function) {
			super();
			fFunction = function;
		}	
	}
	
	public void registerText(final Text text, int function) {	
		text.addTextStatusListener(new ITextStatusListener() {
			public void hidden() {
				textIsHidden(text);
			}
			public void shown() {
				textIsShown(text);				
			}			
		});
		if (!text.isHidden()) {
			textIsShown(text);
		}
		text.setElement(LayoutInformation.class, new LayoutInformation(function));
	}
	
	public void deRegisterText(Text text) {
		fManagedElements.remove(text);
		text.removeElement(LayoutInformation.class);
	}
	
	private void textIsShown(Text text) {
		fManagedElements.add(text);
	}
	
	private void textIsHidden(Text text) {		
		deRegisterText(text);
	}
	
	private String getIndent(int depth) {
		StringBuffer result = new StringBuffer("");
		for (int i = 0; i < depth; i++) {
			result.append("    ");
		}
		return result.toString();
	}
	
	private boolean inChange = false;
	
	public void handleChange() {
		if (inChange) {
			return;
		} 
		inChange = true;
		int depth = 0;		
		Text runningText = fDocument.first();
		Text lastText = null;
		while(runningText != lastText) {
			lastText = runningText;
			if (fManagedElements.contains(runningText)) {
				LayoutInformation layoutInfo = runningText.getElement(LayoutInformation.class);			
				switch (layoutInfo.fFunction) {
					case BEGIN_BLOCK:
						depth++;
						break;
					case END_BLOCK:
						depth--;
						break;
					case SPACE:
					case BREAK:
						break;
					case INDENT:
						((ChangeText)runningText).setText(getIndent(depth));
						break;
					default:
						throw new RuntimeException("assert");
				}
			}
			runningText = runningText.nextText();
		}
		inChange = false;
	}

	public LayoutManager(final DocumentText document) {
		super();
		fDocument = document;
		fDocument.addDocumentUpdateListener(new IDocumentUpdateListener() {
			public void documentAboutToBeUpdated(DocumentText text) {
				handleChange();
			}			
		});
	}
}
