package hub.sam.tef.controllers;

import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.Text;

public class ProposalVisitor extends AbstractOffsetBasedVisitor {	
	
	private final Proposal fProposal;	
	
	public ProposalVisitor(int forOffset, Proposal proposal) {
		super(forOffset);
		this.fProposal = proposal;
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		visitText(visitedText, atOffset);
	}

	public void visitText(Text visitedText, int atOffset) {
		for(IProposalHandler listener: visitedText.getAllElements(IProposalHandler.class)) {
			listener.handleProposal(visitedText, atOffset, fProposal);				
		}
	}

}
