package editortest.template;

import java.util.List;

import editortest.controller.IProposalHandler;
import editortest.controller.Proposal;
import editortest.emf.model.EMFMetaModelElement;
import editortest.emf.model.EMFModelElement;
import editortest.model.ICollection;
import editortest.model.IModelElement;
import editortest.model.ISequence;
import editortest.view.Text;

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
