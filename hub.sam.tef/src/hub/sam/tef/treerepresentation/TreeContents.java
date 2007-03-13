package hub.sam.tef.treerepresentation;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.parse.ISyntaxProvider;
import hub.sam.tef.templates.Template;

public abstract class TreeContents {

	public final String getSymbol() {
		Template template = getTemplate();
		return (template == null) ? null : template.getAdapter(ISyntaxProvider.class).getNonTerminal();
	}
	
	public abstract Template getTemplate();
	
	public abstract IModelElement getModel();
	
	public abstract String getContent();
}
