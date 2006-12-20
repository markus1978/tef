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

import hub.sam.tef.controllers.ComputeSelectionVisitor;
import hub.sam.tef.views.Text;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;


public class TEFDoubleClickStrategy implements 
		ITextDoubleClickStrategy {
	
	public void doubleClicked(ITextViewer viewer) {
		int offset = viewer.getSelectedRange().x;
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((TEFDocument)viewer.getDocument()).getDocument().process(visitor, offset);
		Text selectedText = visitor.getResult(); 
		IRegion region = new Region(selectedText.getAbsolutOffset(0), selectedText.getLength());
		
		if (region != null && region.getLength() > 0) {
			viewer.setSelectedRange(region.getOffset(), region.getLength());
		}
	}
}
