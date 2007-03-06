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

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.controllers.ProposalVisitor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;


public class TEFCompletionProposal implements ICompletionProposal {
	
	private final Proposal fContextInformation;
	private final int fDocumentOffset;	
	//private int cursorPosition;	

	public TEFCompletionProposal(final Proposal contextInformation, final int documentOffset, int cursorPosition) {
		super();
		fContextInformation = contextInformation;
		fDocumentOffset = documentOffset;
		//this.cursorPosition = cursorPosition;
	}

	public void apply(IDocument document) {
		TEFDocument tefDocument = (TEFDocument)document;							 	
		ProposalVisitor visitor = new ProposalVisitor(fDocumentOffset, fContextInformation);
		tefDocument.getModelDocument().getDocumentText().process(visitor, fDocumentOffset);
		//cursorPosition = 0;
	}

	public String getAdditionalProposalInfo() { 
		return fContextInformation.getInformationDisplayString();
	}

	public IContextInformation getContextInformation() {
		return fContextInformation;
	}

	public String getDisplayString() {
		return fContextInformation.getContextDisplayString();
	}

	public Image getImage() {
		return fContextInformation.getImage();
	}

	public Point getSelection(IDocument document) { 
		//return new Point(cursorPosition, 0);
		return null;
	}
}
