package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.model.IModelElement;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;

public abstract class Template {
	public List<Proposal> getProposals() {
		return new Vector<Proposal>();
	}
			
	public boolean isTemplateFor(Object model) {
		return true;
	}
	
	public abstract Text createText(IModelElement model);
	
	public abstract IModelElement createModelFromEvent(TextEvent event);
}
