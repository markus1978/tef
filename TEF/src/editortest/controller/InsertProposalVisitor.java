package editortest.controller;

import editortest.text.CompoundText;
import editortest.text.Text;

public class InsertProposalVisitor extends AbstractOffsetBasedVisitor {	
	
	private final Proposal fProposal;
	
	public InsertProposalVisitor(int forOffset, Proposal proposal) {
		super(forOffset);
		this.fProposal = proposal;
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		visitText(visitedText, atOffset);
	}

	public void visitText(Text visitedText, int atOffset) {
		for(IProposalListener listener: visitedText.getHandler(IProposalListener.class)) {
			listener.insertProposal(visitedText, atOffset, fProposal);
		}
	}

}
