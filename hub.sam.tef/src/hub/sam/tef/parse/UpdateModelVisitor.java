package hub.sam.tef.parse;

import hub.sam.tef.views.Text;
import hub.sam.util.trees.ITreeVisitor;

public class UpdateModelVisitor implements ITreeVisitor<TextBasedUpdatedAST, Text> {

	public void visit(TextBasedUpdatedAST tree) {
		if (!tree.referencesOldASTNode()) {
			// createChild, setAttribute, etc with parent tree nodes mode
			// - need the template for this node and its property
			//     -- possible templates for nodes are: ValueTemplates (Element, Collection)
			// - need the model of the parent node
			// - need functionality the template to achive the createChild command
		} else {
			// check for values of primitive value attributes
		}
			
	}
	
}
