package editortest.controller;

import java.util.List;

import editortest.view.Text;

public interface IProposalHandler {
	
	public enum ProposalKind { insert, change };
	
	public boolean handleProposal(Text text, int offset, Proposal proposal);
	
	public List<Proposal> getProposals(Text text, int offset);
	
	public ProposalKind getProposalKind();
}
