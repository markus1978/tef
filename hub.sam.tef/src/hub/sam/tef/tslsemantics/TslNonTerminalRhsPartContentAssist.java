package hub.sam.tef.tslsemantics;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Syntax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TslNonTerminalRhsPartContentAssist implements IContentAssistSemantics {
	
	@Override
	public Collection<ContentAssistProposal> createProposals(
			ContentAssistContext context) {
		List<String> result = new ArrayList<String>();
		for(Rule rule: ((Syntax)context.getContents().get(0)).getRules()) {
			result.add(rule.getLhs().getName());
		}
		return ContentAssistProposal.createProposals(result, context, 
				null, ContentAssistProposal.REFERENCE_IMAGE, ContentAssistProposal.REFERENCE);
	}	

}
