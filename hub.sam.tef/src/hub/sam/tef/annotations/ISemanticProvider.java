package hub.sam.tef.annotations;

import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

public interface ISemanticProvider {

	public void check(ASTElementNode representation, SemanticsContext context); 
			
}
