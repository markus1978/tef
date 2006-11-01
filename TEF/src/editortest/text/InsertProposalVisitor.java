package editortest.text;

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
		for(IProposalListener listener: visitedText.getProposalHandler()) {
			listener.insertProposal(visitedText, atOffset, fProposal);
		}
	}

}
