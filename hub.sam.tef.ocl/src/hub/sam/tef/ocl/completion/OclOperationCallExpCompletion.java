package hub.sam.tef.ocl.completion;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.ICompletionDisplayStringProvider;
import hub.sam.tef.completion.SingleReductionCompletion;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import java.util.Collection;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

public class OclOperationCallExpCompletion extends SingleReductionCompletion {

	@Override
	public Rule getRule() {
		return new Rule( new String[] { "OperationCallExp", "OCLExpression", "'.'" });
	}

	@Override
	public String[] getRulePrefix() {
		return new String[] { "OCLExpression", "'.'" };
	}

	public Collection<TEFCompletionProposal> createProposals(ASTElementNode completionNode, CompletionContext context) {
		return EMFCompletions.createProposals("EOperation", context, null, new ICompletionDisplayStringProvider() {
			public String getDisplayString(IModelElement element) {
				EOperation operation = (EOperation)((EMFModelElement)element).getEMFObject();
				StringBuffer parameters = new StringBuffer();
				boolean first = true;
				for (Object parameterObj: operation.getEParameters()) {
					EParameter parameter = (EParameter)parameterObj;
					if (first) {
						first = false;
					} else {
						parameters.append(", ");
					}
					parameters.append(parameter.getName());
				}
				return operation.getName() + "(" + parameters.toString() + ")";
			}			
		});
	}

	
}
