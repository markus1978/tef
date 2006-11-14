package editortest.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

import editortest.controller.ProposalVisitor;
import editortest.controller.Proposal;

public class TEFCompletionProposal implements ICompletionProposal {
	
	private final Proposal fContextInformation;
	private final int fDocumentOffset;	
	//private int cursorPosition;	

	public TEFCompletionProposal(final Proposal contextInformation, final int documentOffset, int cursorPosition) {
		super();
		fContextInformation = contextInformation;
		fDocumentOffset = documentOffset;
		//this.cursorPosition = cursorPosition;
	}

	public void apply(IDocument document) {
		TEFDocument tefDocument = (TEFDocument)document;							 	
		ProposalVisitor visitor = new ProposalVisitor(fDocumentOffset, fContextInformation);
		tefDocument.getDocument().process(visitor, fDocumentOffset);
		//cursorPosition = 0;
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
		//return new Point(cursorPosition, 0);
		return null;
	}
}
