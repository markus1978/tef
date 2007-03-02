/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
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
