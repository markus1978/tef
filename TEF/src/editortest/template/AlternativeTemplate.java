package editortest.template;

import java.util.List;
import java.util.Vector;

import editortest.tefwidgets.Alternative;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

public abstract class AlternativeTemplate<AbstractType> extends Template<AbstractType> {
	
	public abstract Template<? extends AbstractType>[] createAlternativeTemplates();	
	private final Template<? extends AbstractType>[] fAlternativeTemplates;
	
	public AlternativeTemplate() {
		this.fAlternativeTemplates = createAlternativeTemplates();
	}

	@Override
	public List<Proposal> getProposals() {
		List<Proposal> result = new Vector<Proposal>();
		for(Template alternativeTemplate: fAlternativeTemplates) {
			result.addAll(alternativeTemplate.getProposals());
		}
		return result;
	}

	@Override
	public Text createText(AbstractType model) {		
		Alternative result = new Alternative();
		if (model != null) {
			for(Template alternativeTemplate: fAlternativeTemplates) {
				if (alternativeTemplate.isTemplateFor(model)) {
					result.setAlternative(alternativeTemplate.createText(model));				
				}
			}
		}
		return result;
	}	

	@Override
	public AbstractType createModelFromEvent(TextEvent event) {
		for(Template<? extends AbstractType> alternativeTemplate: fAlternativeTemplates) {
			for (Proposal proposal: alternativeTemplate.getProposals()) {
				if (proposal.getFReplaceProposal().equals(event.getText())) {
					return alternativeTemplate.createModelFromEvent(event);
				}
			}
		}
		return null;
	}	
}
