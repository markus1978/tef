package editortest.text.visitors;

import java.util.List;

import editortest.text.Text;

public interface IProposalListener {
	public boolean insertProposal(Text text, int offset, Proposal proposal);
	
	public List<Proposal> getProposals(Text text, int offset);
}
