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
import hub.sam.tef.controllers.ProposalCollectVisitor;
import hub.sam.tef.controllers.IProposalHandler.ProposalKind;
import hub.sam.tef.views.Text;

import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;


public class TEFCompletionProcessor implements IContentAssistProcessor {
	
	private final ProposalKind fProposalKind;
	
	public TEFCompletionProcessor(ProposalKind proposalKind) {
		super();	
		fProposalKind = proposalKind;
	}
	
	private List<Proposal> getProposal(Text src, int offset) {
		ProposalCollectVisitor visitor = new ProposalCollectVisitor(offset, fProposalKind);
		src.process(visitor, offset);
		return visitor.getResult();
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int documentOffset) {
		Text src = ((TEFDocument)viewer.getDocument()).getDocument();
		List<Proposal> proposals = getProposal(src, documentOffset);
		ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
		int i = 0;
		for (Proposal proposal: proposals) {
			result[i++] = new TEFCompletionProposal(proposal, documentOffset, 0);
		}
		return result;
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) { 
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	public String getErrorMessage() {	
		return null;
	}
	
}
