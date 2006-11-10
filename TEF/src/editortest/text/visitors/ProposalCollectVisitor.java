package editortest.text.visitors;

import java.util.List;
import java.util.Vector;

import editortest.text.CompoundText;
import editortest.text.Text;

public final class ProposalCollectVisitor extends AbstractOffsetBasedVisitor {
	
	private List<Proposal> result = new Vector<Proposal>();

	public ProposalCollectVisitor(int forOffset) {
		super(forOffset);
	}

	public void visitCompoundText(CompoundText visitedText, int atOffset) {
		visitText(visitedText, atOffset);
	}

	public void visitText(Text visitedText, int atOffset) {
		for(IProposalListener eventHandler: visitedText.getHandler(IProposalListener.class)) {
			result.addAll(eventHandler.getProposals(visitedText, atOffset));
		}		
	}
	
	public List<Proposal> getResult() {
		return result;
	}

}
