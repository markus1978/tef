package editortest.template;

import java.util.Collections;
import java.util.List;

import editortest.text.Text;
import editortest.text.controller.Proposal;

public abstract class ValueTemplate<ModelType> extends Template {
	
	private PropertyTemplate fPropertyTemplate = null;
	
	public ValueTemplate(Template template) {
		super(template);
	}
	
	public abstract Text createView(ModelType model, IValueChangeListener<ModelType> changeListener);
	
	public boolean isTemplateFor(ModelType model) {
		return true;
	}
	
	public void updateView(Text view, ModelType value) {
		
	}
	
	public List<Proposal> getProposals() {
		return Collections.EMPTY_LIST;
	}
	
	public ModelType createModelFromProposal(Proposal proposal) {
		return null;
	}
	
	public void deleteModel(ModelType model) {
		// empty
	}
	
	protected void setPropertyTemplate(PropertyTemplate propertyTemplate) {
		fPropertyTemplate = propertyTemplate;
	}
	
	protected final PropertyTemplate getPropertyTemplate() {
		return fPropertyTemplate;
	}	
}
