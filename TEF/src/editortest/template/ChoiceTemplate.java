package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.controller.Proposal;
import editortest.view.Text;

public abstract class ChoiceTemplate<AbstractType> extends ValueTemplate<AbstractType> {
	
	private final ValueTemplate<? extends AbstractType>[] fAlternativeTemplates;
	
	public ChoiceTemplate(Template template) {
		super(template);
		this.fAlternativeTemplates = createAlternativeTemplates();
	}

	public abstract ValueTemplate<? extends AbstractType>[] createAlternativeTemplates();
	
	@Override
	protected void setPropertyTemplate(PropertyTemplate propertyTemplate) {		
		super.setPropertyTemplate(propertyTemplate);
		for (ValueTemplate<? extends AbstractType> valueTemplate: fAlternativeTemplates) {
			valueTemplate.setPropertyTemplate(propertyTemplate);
		}
	}

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

	@Override
	public AbstractType createModelFromProposal(Proposal proposal) {
		for(ValueTemplate<? extends AbstractType> alternativeTemplate: fAlternativeTemplates) {
			if (alternativeTemplate.getProposals().contains(proposal)) {				
				return alternativeTemplate.createModelFromProposal(proposal);
			}
		}
		return null;
	}

	@Override
	public void deleteModel(AbstractType model) {
		loop: for(ValueTemplate template: fAlternativeTemplates) {
			if (template.isTemplateFor(model)) {
				template.deleteModel(model);
				break loop;
			}
		}
	}
		
}
