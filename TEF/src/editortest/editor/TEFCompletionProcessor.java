package editortest.editor;

import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import editortest.text.Proposal;
import editortest.text.ProposalCollectVisitor;
import editortest.text.Text;

public class TEFCompletionProcessor implements IContentAssistProcessor {
		
	public TEFCompletionProcessor() {
		super();	
	}
	
	private List<Proposal> getProposal(Text src, int offset) {
		ProposalCollectVisitor visitor = new ProposalCollectVisitor(offset);
		src.process(visitor, offset);
		return visitor.getResult();
	}

	private String[] getDisplayProposals(Text src, int offset) {
		List<String> result = new Vector<String>();
		for(Proposal proposal: getProposal(src, offset)) {
			result.add(proposal.getFDisplayProposal());
		}
		return (String[])result.toArray(new String[]{});
	}
	
	private String[] getReplaceProposals(Text src, int offset) {
		List<String> result = new Vector<String>();
		for(Proposal proposal: getProposal(src, offset)) {
			result.add(proposal.getFReplaceProposal());
		}
		return (String[])result.toArray(new String[]{});
	}

	public ICompletionProposal[] computeCompletionProposals(
			final ITextViewer viewer, final int documentOffset) {
		// we return just the list of proposals
		Text src = ((TEFDocument)viewer.getDocument()).getDocument();
		String[] proposalDisplays = getDisplayProposals(src, documentOffset);
		String[] proposalReplacements = getReplaceProposals(src, documentOffset);
		int length = proposalDisplays.length;
		ICompletionProposal[] result = new ICompletionProposal[length];
		for (int i = 0; i < length; i++) {
			String toDisplay = proposalDisplays[i];
			IContextInformation info = new ContextInformation(toDisplay,
					toDisplay);
			result[i] = new CompletionProposal(proposalReplacements[i],
					documentOffset, 0, proposalReplacements[i].length(), null,
					proposalDisplays[i], info, "Test2");
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
