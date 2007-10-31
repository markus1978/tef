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
package hub.sam.tef.completion;

import hub.sam.tef.models.IModel;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class TEFCompletionProposal implements ICompletionProposal {
	
	public static Collection<TEFCompletionProposal> createProposals(Iterable<String> proposals, 
			CompletionContext context, ICompletionFilter filter) {
		Collection<TEFCompletionProposal> result = new Vector<TEFCompletionProposal>();
		IModel model = context.getDocumentModelProvider().getModel();
		for (String proposal : proposals) {			
			if (proposal != null && proposal.startsWith(context.getIdentifierPrefix())) {
				if (filter == null || filter.accept(proposal)) {
					result.add(new TEFCompletionProposal(proposal, proposal.substring(
							context.getIdentifierPrefix().length(), proposal.length()),
							context.getCompletionOffset()));
				}
			}
		}
		return result;
	}

	private final IContextInformation fContextInformation;
	private final int fDocumentOffset;
	private final String fDocumentText;
		
	public TEFCompletionProposal(final String displayText, String documentText, int documentOffset) {
		super();
		this.fDocumentText = documentText;
		fContextInformation = new IContextInformation() {
			public String getContextDisplayString() {
				return displayText;
			}

			public Image getImage() {			
				return null;
			}
			public String getInformationDisplayString() {
				return displayText;
			}			
		};
		fDocumentOffset = documentOffset;
	}

	public void apply(IDocument document) {	
		try {
			document.replace(fDocumentOffset, 0, fDocumentText);
		} catch (BadLocationException ex) {
			throw new RuntimeException(ex);
		}
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
		return new Point(fDocumentOffset + fDocumentText.length(), 0);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((fDocumentText == null) ? 0 : fDocumentText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TEFCompletionProposal other = (TEFCompletionProposal) obj;
		if (fDocumentText == null) {
			if (other.fDocumentText != null)
				return false;
		} else if (!fDocumentText.equals(other.fDocumentText))
			return false;
		return true;
	}
	
	
}
