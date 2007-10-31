package hub.sam.tef.ocl.completion;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.SingleReductionCompletion;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import java.util.Collection;

public class OclPropertyCallExpCompletion extends SingleReductionCompletion {

	@Override
	public Rule getRule() {
		return new Rule( new String[] { "PropertyCallExp", "OCLExpression", "'.'" });
	}

	@Override
	public String[] getRulePrefix() {
		return new String[] { "OCLExpression", "'.'" };
	}

	public Collection<TEFCompletionProposal> createProposals(ASTElementNode completionNode, CompletionContext context) {
		return EMFCompletions.createProposals("EStructuralFeature", context);
	}

	
}
