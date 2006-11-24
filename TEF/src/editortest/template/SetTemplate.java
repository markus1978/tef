package editortest.template;

import hub.sam.tef.views.Text;

import java.util.List;

import editortest.controller.IProposalHandler;
import editortest.controller.Proposal;
import editortest.model.ICollection;

public abstract class SetTemplate<ElementModelType> extends CollectionTemplate<ElementModelType> {
		
	class SeedTextEventListener implements IProposalHandler {	
		private final ICollection fModel;
		private final Text fCollectionText;
		
		public SeedTextEventListener(final ICollection model, Text collectionText) {
			super();
			fModel = model;
			fCollectionText = collectionText;
		}

		public List<Proposal> getProposals(Text context, int offset) {
			return getElementTemplate().getProposals();
		}
		
		public boolean handleProposal(Text text, int offset, Proposal proposal) {
			if (getProposals(text, offset).contains(proposal)) {
				ElementModelType newElement = getElementTemplate().createModelFromProposal(proposal);
				fCollectionText.setElement(CollectionTextElement.class, new CollectionTextElement(newElement));
				fModel.add(newElement);				
				return true;
			} else {
				return false;
			}
		}	
		
		public ProposalKind getProposalKind() {
			return ProposalKind.insert;
		}		
	}
	
	public SetTemplate(ElementTemplate elementTemplate, String property, String separator, boolean separateLast) {
		super(elementTemplate, property, separator, separateLast);
	}

	@Override
	protected IProposalHandler createSeedTextEventListenet(ICollection<ElementModelType> list, int position, Text collectionText) {
		return new SeedTextEventListener(list, collectionText);
	}
}
