package hub.sam.tef.ocl;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.semantics.IContentAssistSemantics;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.parser.Environment;

public class OclVariableContentAssistSemantics extends AbstractOclContentAssistSemantics
		implements IContentAssistSemantics {
	
	public OclVariableContentAssistSemantics(OclTextEditor editor) {
		super(editor);	
	}

	public Collection<ContentAssistProposal> createProposals(
			ContentAssistContext context) {
		Collection<String> proposals = new ArrayList<String>();
		
		Environment env = fEditor.getEnvironmentFactory().createClassifierContext(fEditor.getContext());
		for (Object o: env.getVariables()) {
			proposals.add(((Variable)o).getName());
		}		
		
		return ContentAssistProposal.createProposals(
				proposals, context, null, ContentAssistProposal.REFERENCE_IMAGE, 
				ContentAssistProposal.REFERENCE);
	}

}
