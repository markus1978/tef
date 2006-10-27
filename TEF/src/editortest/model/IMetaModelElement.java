package editortest.model;

import java.util.List;

import editortest.template.Template;
import editortest.widgets.Proposal;

public interface IMetaModelElement {
	
	public String[] getProperties();
	
	public IMetaModelElement getType(String property);
	
	public IModelElement createElement();
	
	public void deleteElement(IModelElement element);
	
	public List<Proposal> getProposals(IModelElement element, 
			String property);
	
	public boolean isMetaModelFor(IModelElement e);
}
