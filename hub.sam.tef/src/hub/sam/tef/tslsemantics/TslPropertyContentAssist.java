package hub.sam.tef.tslsemantics;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.contentassist.IProposalFilter;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tslsemantics.TslModelCreatingContext.IEcoreModel;
import hub.sam.tef.util.IteratorIterable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class TslPropertyContentAssist implements IContentAssistSemantics {	

	public Collection<ContentAssistProposal> createProposals(
			ContentAssistContext context) {
		TslModelCreatingContext creatingContext = (TslModelCreatingContext)
			context.getEditor().getLastModelCreatingContext();
		
		IEcoreModel ecoreModel = creatingContext.getAdapter(IEcoreModel.class);
		
		if (ecoreModel == null) {
			return Collections.emptyList();
		}

		Binding binding = (Binding)context.getCompletionObject();

		IProposalFilter filter = null;
		EClass metaClass = null;
		if (binding instanceof CompositeBinding) {
			metaClass = EcorePackage.eINSTANCE.getEStructuralFeature();
			filter = new IProposalFilter() {
				public boolean accept(Object obj) {
					if (obj instanceof EReference) {
						return ((EReference)obj).isContainment();
					} else {
						return true;
					}
				}				
			};
		} else if (binding instanceof ReferenceBinding) {
			metaClass = EcorePackage.eINSTANCE.getEStructuralFeature();
			filter = new IProposalFilter() {
				public boolean accept(Object obj) {
					return (!(obj instanceof EAttribute) && !((EReference)obj).isContainment());						
				}				
			};
		} else if (binding instanceof ElementBinding) {
			metaClass = EcorePackage.eINSTANCE.getEClass();
		} else {
			return Collections.emptyList();
		}
		
		List<String> proposals = new ArrayList<String>();
		String identifierPrefix = context.getIdentifierPrefix();
		for(Object ecoreObject: new IteratorIterable<Object>(ecoreModel.getAllContents())) {
			if (ecoreObject instanceof EObject &&
					metaClass.isSuperTypeOf(
							((EObject)ecoreObject).eClass())) {			
				String name = ((ENamedElement)ecoreObject).getName();
				if (name.startsWith(identifierPrefix)) {
					if (filter == null || filter.accept(ecoreObject)) {
						proposals.add(name);
					}
				}
			}
		}
				
		return ContentAssistProposal.createProposals(
				proposals, context, 
				null, ContentAssistProposal.REFERENCE_IMAGE, 
				ContentAssistProposal.REFERENCE);
	}	
}