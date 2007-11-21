package hub.sam.tef.semantics;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.contentassist.RccContentAssistParser;

import java.util.Collection;

public interface IContentAssistSemantics {

	/**
	 * Creates all completion proposals for a parse tree node. This node was
	 * created by this completion computer's
	 * {@link #reduceParseStack(RccContentAssistParser)}.
	 * 
	 * @param completionNode
	 *            is always null (TODO)
	 * @param context
	 *            the context for this content assist.
	 */
	public Collection<ContentAssistProposal> createProposals(ContentAssistContext context);
}
