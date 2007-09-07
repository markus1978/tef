package hub.sam.tef.completion;

import java.util.Collection;

import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;


public interface ICompletionComputer {
	
	/**
	 * Reads the top of the parse stack an checks whether this computer is applicable. If so it can perform
	 * abritrary reductions on the stack to create a suitable node on top. This node is later used to create
	 * the possible completions.
	 * 
	 * @param parser The parser with the stack to modify.
	 * @return True when the completion is applicable, false else.
	 */
	public boolean reduceParseStack(CompletionParser parser);
	
	/**
	 * Creates all completion proposals for a parse tree node. This node was created by this completion
	 * computer's {@link #reduceParseStack(CompletionParser)}.
	 * @param context TODO
	 */
	public Collection<TEFCompletionProposal> createProposals(ASTElementNode completionNode, CompletionContext context);
}
