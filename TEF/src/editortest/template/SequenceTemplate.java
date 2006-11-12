package editortest.template;

import java.util.List;

import editortest.controller.IProposalHandler;
import editortest.controller.Proposal;
import editortest.controller.IProposalHandler.ProposalKind;
import editortest.model.ICollection;
import editortest.model.ISequence;
import editortest.view.Text;

public abstract class SequenceTemplate<ElementModelType> extends CollectionTemplate<ElementModelType> {
	
	class SeedTextEventListener implements IProposalHandler {	
		private final ISequence fModel;
		private final int fPosition;
		
		public SeedTextEventListener(final ISequence model, int position) {
			super();
			fModel = model;
			fPosition = position;
		}

		public List<Proposal> getProposals(Text context, int offset) {
			return getElementTemplate().getProposals();
		}
		
		public boolean handleProposal(Text text, int offset, Proposal proposal) {
			if (getProposals(text, offset).contains(proposal)) {
				ElementModelType newElement = getElementTemplate().createModelFromProposal(proposal);
				fModel.insert(fPosition, newElement);
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
	
	protected SeedTextEventListener createSeedTextEventListenet(ICollection<ElementModelType> list, int position) {
		return new SeedTextEventListener((ISequence<ElementModelType>) list, position);
	}	
	
}
