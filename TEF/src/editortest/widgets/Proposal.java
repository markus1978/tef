package editortest.widgets;

public class Proposal {
	
	private final String fDisplayProposal;
	
	private final String fReplaceProposal;

	public Proposal(final String displayProposal, final String replaceProposal) {
		super();
		fDisplayProposal = displayProposal;
		fReplaceProposal = replaceProposal;
	}

	public String getFDisplayProposal() {
		return fDisplayProposal;
	}

	public String getFReplaceProposal() {
		return fReplaceProposal;
	}
	
}
