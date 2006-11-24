package editortest.controller;

import hub.sam.tef.views.Text;

import java.util.List;


public interface IProposalHandler {
	
	public enum ProposalKind { insert, change };
	
	/**
	 * Handles a proposal, proposed by this handler and selected by the user.
	 * @param text The text that should handle the proposal.
	 * @param offset The offset that the proposal was activated on.
	 * @param proposal The proposal.
	 * @return Wheather the proposal was handled or not.
	 */
	public boolean handleProposal(Text text, int offset, Proposal proposal);
	
	public List<Proposal> getProposals(Text text, int offset);
	
	public ProposalKind getProposalKind();
}
