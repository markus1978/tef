package hub.sam.tef.tslsemantics;

import hub.sam.tef.contentassist.CompletionContext;
import hub.sam.tef.contentassist.CompletionProposal;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.DefaultContentAssistSemantics;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Syntax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TslNonTerminalRhsPartContentAssist extends DefaultContentAssistSemantics {
	
	public TslNonTerminalRhsPartContentAssist(PropertyBinding binding) {
		super(binding);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<CompletionProposal> createProposals(
			ParseTreeNode completionNode, CompletionContext context) {
		List<String> result = new ArrayList<String>();
		for(Rule rule: ((Syntax)context.getContents().get(0)).getRules()) {
			result.add(rule.getLhs().getName());
		}
		return CompletionProposal.createProposals(result, context, null);		
	}

}
