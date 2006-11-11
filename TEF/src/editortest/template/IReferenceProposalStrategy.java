package editortest.template;

import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.text.controller.Proposal;

public interface IReferenceProposalStrategy {
	
	public List<Proposal> getProposals(IMetaModelElement type);
}
