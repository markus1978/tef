package editortest.text;

import java.util.List;

public interface IProposalListener {
	public boolean insertProposal(Text text, int offset, Proposal proposal);
	
	public List<Proposal> getProposals(Text text, int offset);
}
