package editortest.controller;

import java.util.List;
import java.util.Vector;

import editortest.controller.IProposalHandler.ProposalKind;
import editortest.view.CompoundText;
import editortest.view.Text;

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
