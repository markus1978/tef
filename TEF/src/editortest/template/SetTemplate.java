package editortest.template;

import java.util.List;

import editortest.controller.IProposalHandler;
import editortest.controller.Proposal;
import editortest.model.ICollection;
import editortest.view.CompoundText;
import editortest.view.Text;

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
				fCollectionText.putAttribute(Object.class, newElement);
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
