package hub.sam.tef.templates;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IMetaModelElement;

import java.util.List;


public interface IReferenceProposalStrategy {
	
	public List<Proposal> getProposals(IMetaModelElement type);
}
