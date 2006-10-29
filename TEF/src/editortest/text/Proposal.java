package editortest.text;

public class Proposal {
	
	private final String fDisplayProposal;	
	private final String fReplaceProposal;
	private final int fGroup;

	public Proposal(final String displayProposal, final String replaceProposal, int group) {
		super();
		fDisplayProposal = displayProposal;
		fReplaceProposal = replaceProposal;
		fGroup = group;
	}
	
	public Proposal(final String displayProposal, final String replaceProposal) {
		this(displayProposal, replaceProposal, 0);
	}

	public String getFDisplayProposal() {
		return fDisplayProposal;
	}

	public String getFReplaceProposal() {
		return fReplaceProposal;
	}
	
	public int getGroup() {
		return fGroup;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Proposal) {
			return fReplaceProposal.equals(((Proposal)obj).fReplaceProposal);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fReplaceProposal.hashCode();
	}	
}
