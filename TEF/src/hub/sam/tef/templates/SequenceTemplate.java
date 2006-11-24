package hub.sam.tef.templates;

import hub.sam.tef.controllers.AbstractRequestHandler;
import hub.sam.tef.controllers.IProposalHandler;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.ISequence;
import hub.sam.tef.views.Text;

import java.util.List;

public abstract class SequenceTemplate<ElementModelType> extends CollectionTemplate<ElementModelType> {
	
	class SeedTextEventListener extends AbstractRequestHandler<ElementModelType> 
			implements IProposalHandler {	
		private final ISequence fModel;
		private final int fPosition;
		private final Text fCollectionText;		
		
		public SeedTextEventListener(final IModelElement owner, String property, 
				final ISequence model, int position, Text collectionText) {
			super(owner, property, null);
			fModel = model;
			fPosition = position;
			fCollectionText = collectionText;
		}

		public List<Proposal> getProposals(Text context, int offset) {
			return getElementTemplate().getProposals();
		}
		
		public boolean handleProposal(Text text, int offset, Proposal proposal) {
			if (getProposals(text, offset).contains(proposal)) {
				ICommand command = getElementTemplate().getCommandForProposal(
						proposal, getOwner(), getProperty(), fPosition);
				fCollectionText.setElement(CollectionCursorPositionMarker.class, new CollectionCursorPositionMarker(fPosition));
				command.execute();			
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
	protected SeedTextEventListener createSeedTextEventListenet(IModelElement owner, String property, 
			ICollection<ElementModelType> list, int position, Text collectionText) {
		return new SeedTextEventListener(owner, property, (ISequence<ElementModelType>) list, position, collectionText);
	}	
	
}
