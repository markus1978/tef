package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.widgets.Proposal;
import editortest.widgets.Text;
import editortest.widgets.TextEvent;

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
