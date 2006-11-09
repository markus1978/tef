package editortest.template;

import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.text.visitors.Proposal;

public interface IReferenceProposalStrategy {
	
	public List<Proposal> getProposals(IMetaModelElement type);
}
