package hub.sam.tef.ocl.completion;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.EmptyReductionCompletion;
import hub.sam.tef.completion.ICompletionFilter;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class OclSingleIdentifierSchemeCompletion extends EmptyReductionCompletion {
	
	private EObject context = null;

	@Override
	public Rule getRule() {
		return new Rule(new String[] { "SingleIdentifierScheme" });
	}

	public Collection<TEFCompletionProposal> createProposals(ASTElementNode completionNode, CompletionContext context) {
		// TODO completion for the variable self, restrict completions to those of self.properties
		Collection<TEFCompletionProposal> result = new Vector<TEFCompletionProposal>();
		result.addAll(EMFCompletions.createProposals("Variable", context));
		final EObject fContext = this.context;
		result.addAll(EMFCompletions.createProposals("EStructuralFeature", context, (fContext == null)? null: new ICompletionFilter() {
			public boolean accept(Object obj) {			
				return fContext.equals(((EStructuralFeature)((EMFModelElement)obj).getEMFObject()).getEContainingClass());				
			}			
		}, null));
		return result;
	}

	public void setContext(EObject context) {
		this.context = context;
	}
		
}
