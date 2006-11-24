package hub.sam.tef.templates;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.Text;

import java.util.Collections;
import java.util.List;


/**
 * ValueTemplates describe values. They are opposite to PropertyTemplates, which
 * describe properties, the container of values. In a Template hierarchy
 * ValueTemplates and PropertyTemplates alternate along a path.
 */
public abstract class ValueTemplate<ModelType> extends Template {
	
	public ValueTemplate(Template template) {
		super(template);
	}
	
	public ValueTemplate(DocumentText document) {
		super(document);
	}
	
	/**
	 * Creates a view for the models that should be displayed as described by
	 * this template. It also installes a given changeListener. This listener is
	 * expected to be notified when a user event to the created view should lead
	 * to a change in the model.
	 * 
	 * @param model
	 *            The model, e.g. the value.
	 * @param changeListener
	 *            A change listener that has to be notified when the value is
	 *            changes by the user.
	 * @return The created view.
	 */
	public abstract Text createView(ModelType model, IValueChangeListener<ModelType> changeListener);
	
	public boolean isTemplateFor(ModelType model) {
		return true;
	}
	
	/**
	 * This method takes a view created for an old value and changes it to fit
	 * the new value. This method is used after a model change event occured.
	 * 
	 * @param view
	 *            The view representing the old model.
	 * @param value
	 *            The new model for the given view.
	 */
	public void updateView(Text view, ModelType value) {
		
	}
	
	/**
	 * Returns content assist proposals for editing the value.
	 * 
	 * @return A list of proposals.
	 */
	public List<Proposal> getProposals() {
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * When the user chooses a proposal from {@link #getProposals()} this method
	 * is used to create a real value from it.
	 * 
	 * @param proposal
	 *            The proposal.
	 * @return A model created for the proposal.
	 */
	public ModelType createModelFromProposal(Proposal proposal) {
		return null;
	}
	
	/**
	 * Deletes the given model. This can be seen as the opposite to
	 * {@link #createModelFromProposal(Proposal)}.
	 * 
	 * @param model
	 *            The value to be deleted.
	 */
	public void deleteModel(ModelType model) {
		// empty
	}
}
