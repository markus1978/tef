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

import hub.sam.tef.controllers.AbstractOffsetBasedVisitor;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.Text;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.swt.custom.StyleRange;

/**
 * This PresentationDamager/Repairer is used to realise TEF's syntax highlighting
 */
public class PresentationDamagerRepairer implements IPresentationDamager, IPresentationRepairer {

	private TEFDocument fDocument;
	private final TEFSourceViewer fSourceViewer;
	
	public PresentationDamagerRepairer(final TEFSourceViewer sourceViewer) {
		super();
		fSourceViewer = sourceViewer;
	}
	
	class FirstTextAtOffsetVisitor extends AbstractOffsetBasedVisitor {
		Text result = null;
		public FirstTextAtOffsetVisitor(int forOffset) {
			super(forOffset);
		}
		public void visitCompoundText(CompoundText visitedText, int atOffset) {
			// empty
		}
		public void visitText(Text visitedText, int atOffset) {
			if (result == null) {
				result = visitedText;				
			}
		}		
	}
		
	public void createPresentation(TextPresentation presentation, final ITypedRegion damage) {
		presentation.setDefaultStyleRange(new StyleRange(damage.getOffset(), damage.getLength(), null, null));		
		FirstTextAtOffsetVisitor visitor = new FirstTextAtOffsetVisitor(damage.getOffset());	
		fDocument.getDocument().process(visitor, damage.getOffset());
		Collection<Text> allTextsInRange = new Vector<Text>();
		Text runningText = visitor.result;		
		loop: while (runningText.getAbsolutOffset(0) < damage.getOffset() + damage.getLength()) {
			allTextsInRange.add(runningText);
			if (runningText == runningText.nextText()) {
				break loop;
			} else {
				runningText = runningText.nextText();
			}			
		}

		for (Text text: allTextsInRange) {
			TextAttribute attr = text.getElement(TextAttribute.class);
			if (attr != null) {				
				int begin = text.getAbsolutOffset(0);
				int end = begin + text.getLength();
				
				int damageBegin = damage.getOffset();
				int damageEnd = damageBegin + damage.getLength();
				if (begin < damageBegin) {
					begin = damageBegin;
				}
				if (end > damageEnd) {
					end = damageEnd;
				}				
				presentation.addStyleRange(new StyleRange(begin, end - begin,  attr.getForeground(), attr.getBackground(), attr.getStyle()));
			}
		}
	}

	public IRegion getDamageRegion(ITypedRegion partition, DocumentEvent event, boolean documentPartitioningChanged) {		
		return new Region(event.getOffset(), event.getText().length()); 
	}

	public void setDocument(IDocument document) {
		fDocument = (TEFDocument)document;
	}	
}
