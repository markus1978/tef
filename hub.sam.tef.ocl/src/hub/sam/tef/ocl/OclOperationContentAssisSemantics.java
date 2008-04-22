package hub.sam.tef.ocl;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.semantics.IContentAssistSemantics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class OclOperationContentAssisSemantics extends AbstractOclContentAssistSemantics
		implements IContentAssistSemantics {

	
	public OclOperationContentAssisSemantics(OclTextEditor editor) {
		super(editor);
	}

	public Collection<ContentAssistProposal> createProposals(
			ContentAssistContext context) {
		
		Resource resource = fEditor.getContext().eResource();
		if (resource == null) {
			return Collections.emptyList();
		}
		
		Iterator<? extends Notifier> contents = null;
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet != null) {
			contents = resourceSet.getAllContents();
		} else {
			contents = resource.getAllContents();
		}
		
		Collection<String> proposals = new ArrayList<String>();
		while (contents.hasNext()) {
			Object content = contents.next();
			if (content instanceof EOperation) {
				proposals.add(((EOperation)content).getName());
			}
		}
		
		return ContentAssistProposal.createProposals(proposals, context, null, 
				ContentAssistProposal.REFERENCE_IMAGE,
				ContentAssistProposal.REFERENCE);
	}

}
