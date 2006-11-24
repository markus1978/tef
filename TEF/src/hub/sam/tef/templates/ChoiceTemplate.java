package hub.sam.tef.templates;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.Text;

import java.util.List;
import java.util.Vector;


/**
 * This is a ValueTemplate that represents different types of 
 * values.
 */
public abstract class ChoiceTemplate<AbstractType> extends ValueTemplate<AbstractType> {
	
	private final ValueTemplate<? extends AbstractType>[] fAlternativeTemplates;
	
	public ChoiceTemplate(Template template) {
		super(template);
		this.fAlternativeTemplates = createAlternativeTemplates();
	}

	/**
	 * @return A set of value templates. These are the templates for all
	 *         possible values for this template.
	 */
	public abstract ValueTemplate<? extends AbstractType>[] createAlternativeTemplates();

	@Override
	public List<Proposal> getProposals() {
		List<Proposal> result = new Vector<Proposal>();
		for(ValueTemplate<? extends AbstractType> alternativeTemplate: fAlternativeTemplates) {
			result.addAll(alternativeTemplate.getProposals());
		}
		return result;
	}
	
	@Override
	public Text createView(AbstractType model, IValueChangeListener<AbstractType> changeListener) {		
			for(ValueTemplate alternativeTemplate: fAlternativeTemplates) {
				if (alternativeTemplate.isTemplateFor(model)) {
					return alternativeTemplate.createView(model, changeListener);				
				}
			}
			return null;
	}	
	
	public ICommand getCommandForProposal(Proposal proposal, IModelElement owner, 
			String property, int index) {
		for(ValueTemplate template: fAlternativeTemplates) {
			if (template.getProposals().contains(proposal)) {
				return template.getCommandForProposal(proposal, owner, property, index);
			}
		}
		return null;		
	}
}
