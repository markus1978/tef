package hub.sam.tef.semantics;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Default content assist. It considers all elements that have a plausible
 * meta-type (the type of the reference). It calculates local ids based on a
 * given identification scheme.
 */
public class DefaultReferenceContentAssistSemantics implements
		IContentAssistSemantics {

	private final EClass metaType;
	private final IIdentificationScheme fIdScheme;
	
	public DefaultReferenceContentAssistSemantics(EClass metaType,
			IIdentificationScheme scheme) {
		super();
		this.metaType = metaType;
		fIdScheme = scheme;
	}
	
	public DefaultReferenceContentAssistSemantics(EClass metaType) {
		this(metaType, DefaultIdentificationScheme.INSTANCE);
	}

	@SuppressWarnings("unchecked")
	public Collection<ContentAssistProposal> createProposals(
			ContentAssistContext context) {
		List<String> result = new ArrayList<String>();
		Resource currentModel = context.getEditor().getCurrentModel();
		if (currentModel == null) {
			return Collections.emptyList();
		}
		Iterator content = null;
		if (currentModel.getResourceSet() != null) {
			content = currentModel.getResourceSet().getAllContents();
		} else {
			content = currentModel.getAllContents();
		}

		if (content == null) {
			return Collections.emptyList();
		}
		while (content.hasNext()) {
			Object nextObj = content.next();
			if (nextObj instanceof EObject) {
				EObject next = (EObject) nextObj;
				if (metaType.isSuperTypeOf(next.eClass())) {
					String id = fIdScheme.getLocalIdentity(next, 
							context.getCompletionObject());
					if (id != null) {
						result.add(id);
					}
				}
			}
		}
		return ContentAssistProposal.createProposals(result, context, null,
				ContentAssistProposal.REFERENCE_IMAGE,
				ContentAssistProposal.REFERENCE);
	}
}
