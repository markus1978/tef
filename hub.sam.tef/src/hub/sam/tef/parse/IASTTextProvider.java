package hub.sam.tef.parse;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.Text;

public interface IASTTextProvider {
	
	public Text createView(TextBasedUpdatedAST ast, IModelElement model);
}
