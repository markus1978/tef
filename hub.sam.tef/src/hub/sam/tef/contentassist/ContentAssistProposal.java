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
package hub.sam.tef.contentassist;

import hub.sam.tef.TEFPlugin;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class ContentAssistProposal implements ICompletionProposal {
	
	public static final int PRIMITIVE = 0;
	public static final int ELEMENT = 1;
	public static final int KEYWORD = 2;
	public static final int REFERENCE = 3;
	
	public static final Image REFERENCE_IMAGE = 
		TEFPlugin.getImageDescriptor("icons/reference.gif").createImage();
	public static final Image PRIMITIVE_IMAGE = 
		TEFPlugin.getImageDescriptor("icons/primitive.gif").createImage();
	public static final Image KEWORD_IMAGE = 
		TEFPlugin.getImageDescriptor("icons/keyword.gif").createImage();
	public static final Image ELEMENT_IMAGE = 
		TEFPlugin.getImageDescriptor("icons/element.gif").createImage();
	
	public static Collection<ContentAssistProposal> createProposals(
			Iterable<String> proposals, 
			ContentAssistContext context, 
			IProposalFilter filter, 
			Image image, int relevance) {
		Collection<ContentAssistProposal> result = new Vector<ContentAssistProposal>();
		for (String proposal : proposals) {			
			if (proposal != null && proposal.startsWith(context.getIdentifierPrefix())) {
				if (filter == null || filter.accept(proposal)) {
					result.add(new ContentAssistProposal(proposal, image, 
							proposal.substring(context.getIdentifierPrefix().length(), proposal.length()),
							context.getCompletionOffset(),
							relevance));
				}
			}
		}
		return result;
	}
	
	public static Collection<ContentAssistProposal> createProposals(
			String[] proposals, 
			ContentAssistContext context, 
			IProposalFilter filter,
			Image image, int relevance) {
		Collection<ContentAssistProposal> result = new Vector<ContentAssistProposal>();
		for (String proposal : proposals) {			
			if (proposal != null && proposal.startsWith(context.getIdentifierPrefix())) {
				if (filter == null || filter.accept(proposal)) {
					result.add(new ContentAssistProposal(proposal, image, 
							proposal.substring(context.getIdentifierPrefix().length(), proposal.length()),
							context.getCompletionOffset(),
							relevance));
				}
			}
		}
		return result;
	}
	
	public static void sort(List<ICompletionProposal> proposals) {
		Collections.sort(proposals, new Comparator<ICompletionProposal>() {
			public int compare(ICompletionProposal o1,
					ICompletionProposal o2) {
				if (o1 instanceof ContentAssistProposal && o2 instanceof ContentAssistProposal) {
					int result = ((ContentAssistProposal)o2).fRelevance - 
							((ContentAssistProposal)o1).fRelevance;
					if (result == 0) {
						return ((ContentAssistProposal)o2).getDisplayString().length() - 
						((ContentAssistProposal)o1).getDisplayString().length();
					} else {
						return result;
					}
				} else {
					return 0;
				}
			}			
		});
	}

	private final IContextInformation fContextInformation;
	private final int fDocumentOffset;
	private final String fDocumentText;
	private final int fRelevance;
		
	public ContentAssistProposal(
			final String displayText, 
			String documentText, 
			int documentOffset) {
		this(displayText, null, documentText, documentOffset, PRIMITIVE);
	}
	
	public ContentAssistProposal(
			final String displayText, 
			final Image image, 
			String documentText,
			int documentOffset, int relevance) {
		this.fDocumentText = documentText;
		fContextInformation = new IContextInformation() {
			public String getContextDisplayString() {
				return displayText;
			}

			public Image getImage() {			
				return image;
			}
			public String getInformationDisplayString() {
				return displayText;
			}			
		};
		fDocumentOffset = documentOffset;
		fRelevance = relevance;
	}

	public void apply(IDocument document) {	
		try {
			document.replace(fDocumentOffset, 0, fDocumentText);
		} catch (BadLocationException ex) {
			Assert.isTrue(false);
		}
	}

	public String getAdditionalProposalInfo() { 
		return fContextInformation.getInformationDisplayString();
	}

	public IContextInformation getContextInformation() {
		return fContextInformation;
	}

	public String getDisplayString() {
		return fContextInformation.getContextDisplayString();
	}

	public Image getImage() {
		return fContextInformation.getImage();
	}

	public Point getSelection(IDocument document) { 
		return new Point(fDocumentOffset + fDocumentText.length(), 0);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((fDocumentText == null) ? 0 : fDocumentText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ContentAssistProposal other = (ContentAssistProposal) obj;
		if (fDocumentText == null) {
			if (other.fDocumentText != null)
				return false;
		} else if (!fDocumentText.equals(other.fDocumentText))
			return false;
		return true;
	}
	
	
}
