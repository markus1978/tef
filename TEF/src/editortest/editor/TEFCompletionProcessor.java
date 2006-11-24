package editortest.editor;

import hub.sam.tef.views.Text;

import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import editortest.controller.Proposal;
import editortest.controller.ProposalCollectVisitor;
import editortest.controller.IProposalHandler.ProposalKind;

public class TEFCompletionProcessor implements IContentAssistProcessor {
	
	private final ProposalKind fProposalKind;
	
	public TEFCompletionProcessor(ProposalKind proposalKind) {
		super();	
		fProposalKind = proposalKind;
	}
	
	private List<Proposal> getProposal(Text src, int offset) {
		ProposalCollectVisitor visitor = new ProposalCollectVisitor(offset, fProposalKind);
		src.process(visitor, offset);
		return visitor.getResult();
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int documentOffset) {
		Text src = ((TEFDocument)viewer.getDocument()).getDocument();
		List<Proposal> proposals = getProposal(src, documentOffset);
		ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
		int i = 0;
		for (Proposal proposal: proposals) {
			result[i++] = new TEFCompletionProposal(proposal, documentOffset, 0);
		}
		return result;
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) { 
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	public String getErrorMessage() {	
		return null;
	}
	
}
