package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;

public abstract class Template<ModelType> {
	public List<Proposal> getProposals() {
		return new Vector<Proposal>();
	}
			
	public boolean isTemplateFor(Object model) {
		return true;
	}
	
	public abstract Text createText(ModelType model);
	
	public abstract ModelType createModelFromEvent(TextEvent event);
}
