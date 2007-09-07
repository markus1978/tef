package hub.sam.tef.reconciliation;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

public class ReconciliationResults {
	private final IModelElement topLevelElement;
	private final ASTElementNode topLevelTreeNode;
	
	public ReconciliationResults(final IModelElement topLevelElement, final ASTElementNode topLevelTreeNode) {
		super();
		this.topLevelElement = topLevelElement;
		this.topLevelTreeNode = topLevelTreeNode;
	}

	public IModelElement getTopLevelElement() {
		return topLevelElement;
	}

	public ASTElementNode getTopLevelTreeNode() {
		return topLevelTreeNode;
	}	
}
