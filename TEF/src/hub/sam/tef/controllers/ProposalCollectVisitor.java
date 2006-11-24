package hub.sam.tef.controllers;

import hub.sam.tef.controllers.IProposalHandler.ProposalKind;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.Text;

import java.util.List;
import java.util.Vector;


public final class ProposalCollectVisitor extends AbstractOffsetBasedVisitor {
	
	private List<Proposal> result = new Vector<Proposal>();
	private final ProposalKind fProposalKind;

	public ProposalCollectVisitor(int forOffset, ProposalKind proposalKind) {
		super(forOffset);
		fProposalKind = proposalKind;
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		visitText(visitedText, atOffset);
	}

	public void visitText(Text visitedText, int atOffset) {
		for(IProposalHandler eventHandler: visitedText.getAllElements(IProposalHandler.class)) {
			if (eventHandler.getProposalKind() == fProposalKind) {
				result.addAll(eventHandler.getProposals(visitedText, atOffset));
			}
		}		
	}
	
	public List<Proposal> getResult() {
		return result;
	}

}
