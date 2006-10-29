package editortest.template;

import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.text.Proposal;

public interface IReferenceProposalStrategy {
	
	public List<Proposal> getProposals(IMetaModelElement type);
}
