package hub.sam.tef.parse;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.Text;

public interface IModelTextProvider {

	public Text createView(IModelElement model);
	
}
