package editortest.widgets;

import java.util.List;
import java.util.Vector;

public final class ProposalCollectVisitor extends AbstractOffsetBasedVisitor {
	
	private List<Proposal> result = new Vector<Proposal>();

	public ProposalCollectVisitor(int forOffset) {
		super(forOffset);
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		visitText(visitedText, atOffset);
	}

	public void visitText(Text visitedText, int atOffset) {
		for(TextEventListener eventHandler: visitedText.getEventHandler()) {
			result.addAll(eventHandler.getProposals(atOffset, visitedText));
		}		
	}
	
	public List<Proposal> getResult() {
		return result;
	}

}
