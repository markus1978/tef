package hub.sam.tef.ocl;

import java.util.Collection;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.semantics.IContentAssistSemantics;

public class OclCollectionFunctionsContentAssistSemantics implements 
		IContentAssistSemantics {
	
	public Collection<ContentAssistProposal> createProposals(
			ContentAssistContext context) {
		String[] proposals = { "size", "collect", "select"};
		return ContentAssistProposal.createProposals(proposals, context, 
				null,
				ContentAssistProposal.REFERENCE_IMAGE, 
				ContentAssistProposal.REFERENCE);
	}
	
}
