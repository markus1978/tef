package hub.sam.tef.ocl.completion;

import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.SingleReductionCompletion;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import java.util.Collection;
import java.util.Vector;

public class OclCollectionOperationCompletion extends SingleReductionCompletion {

	@Override
	public Rule getRule() {
		return new Rule( new String[] { "OperationCallExp", "OCLExpression", "'->'" });
	}

	@Override
	public String[] getRulePrefix() {
		return new String[] { "OCLExpression", "'->'" };
	}

	public Collection<TEFCompletionProposal> createProposals(ASTElementNode completionNode, CompletionContext context) {
		Collection<TEFCompletionProposal> result = new Vector<TEFCompletionProposal>();
		for (String operation: new String[] {"forAll", "exists", "select", "collect", "asSequence", "empty", "notEmpty", "first", "any"}) {
			operation = operation + "()";
			if (operation.startsWith(context.getIdentifierPrefix())) {
				TEFCompletionProposal proposal = new TEFCompletionProposal(operation, 
						operation.substring(context.getIdentifierPrefix().length(), operation.length()), context.getCompletionOffset());
				result.add(proposal);
			}
		}
		return result;
	}

}
