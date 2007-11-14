package hub.sam.tef.contentassist;

import hub.sam.tef.modelcreating.ParseTreeNode;

import java.util.Collection;

public interface ICompletionComputer {
	
	/**
	 * Reads the top of the parse stack an checks whether this computer is
	 * applicable. If so it can perform arbitrary reductions on the stack to
	 * create a suitable node on top. This node is later used to create the
	 * possible completions.
	 * 
	 * @param parser
	 *            The parser with the stack to modify.
	 * @return True when the completion is applicable, false else.
	 */
	public boolean reduceParseStack(RccCompletionParser parser);
	
	/**
	 * Creates all completion proposals for a parse tree node. This node was
	 * created by this completion computer's
	 * {@link #reduceParseStack(RccCompletionParser)}.
	 * 
	 * @param context
	 *            TODO
	 */
	public Collection<CompletionProposal> createProposals(ParseTreeNode completionNode, CompletionContext context);
}
