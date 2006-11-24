package hub.sam.tef.controllers;

import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;

public class Proposal implements IContextInformation {
	
	private final String fProposedString;
	private final Object fProposedObject;
	private final int fGroup;

	public Proposal(String displayProposal, Object proposedObject, int group) {
		super();
		fProposedString = displayProposal;
		fProposedObject = proposedObject;
		fGroup = group;
	}
	

	public String getContextDisplayString() {
		return fProposedString;
	}

	public Image getImage() {
		return null;
	}

	public String getInformationDisplayString() {
		return "Huh?";
	}

	public int getGroup() {
		return fGroup;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Proposal) {
			if (fProposedObject != null) {
				return fProposedObject.equals(((Proposal)obj).fProposedObject);
			} else {
				return fProposedString.equals(((Proposal)obj).fProposedString);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fProposedObject.hashCode();
	}	
}
