package hub.sam.tef.templates;

import hub.sam.tef.controllers.IProposalHandler;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.ISequence;
import hub.sam.tef.views.Text;

import java.util.List;

import editortest.emf.model.EMFMetaModelElement;
import editortest.emf.model.EMFModelElement;

public abstract class SequenceTemplate<ElementModelType> extends CollectionTemplate<ElementModelType> {
	
	class SeedTextEventListener implements IProposalHandler {	
		private final ISequence fModel;
		private final int fPosition;
		private final Text fCollectionText;
		
		public SeedTextEventListener(final ISequence model, int position, Text collectionText) {
			super();
			fModel = model;
			fPosition = position;
			fCollectionText = collectionText;
		}

		public List<Proposal> getProposals(Text context, int offset) {
			return getElementTemplate().getProposals();
		}
		
		public boolean handleProposal(Text text, int offset, Proposal proposal) {
			if (getProposals(text, offset).contains(proposal)) {
				ElementModelType newElement = getElementTemplate().createModelFromProposal(proposal);
				fCollectionText.setElement(CollectionTextElement.class, new CollectionTextElement(newElement));
				fModel.insert(fPosition, newElement);
				/*
				if (newElement instanceof EMFModelElement) {
					if (((EMFMetaModelElement)((EMFModelElement)newElement).getMetaElement()).getEMFObject().getName().equals("EClass")) {
						((IModelElement)newElement).setValue("ePackage", 
								new EMFModelElement(((EMFModelElement)newElement).getEMFObject().eContainer()));
					}
				}
				*/				
				return true;
			} else {
				return false;
			}
		}

		public ProposalKind getProposalKind() {
			return ProposalKind.insert;
		}		
	}
	
	public SequenceTemplate(ElementTemplate elementTemplate, String property, String separator, boolean separateLast) {
		super(elementTemplate, property, separator, separateLast);
	}
	
	@Override
	protected SeedTextEventListener createSeedTextEventListenet(ICollection<ElementModelType> list, int position, Text collectionText) {
		return new SeedTextEventListener((ISequence<ElementModelType>) list, position, collectionText);
	}	
	
}
