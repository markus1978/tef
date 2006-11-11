package editortest.template;

import java.util.List;

import editortest.controller.Proposal;
import editortest.model.IMetaModelElement;

public interface IReferenceProposalStrategy {
	
	public List<Proposal> getProposals(IMetaModelElement type);
}
