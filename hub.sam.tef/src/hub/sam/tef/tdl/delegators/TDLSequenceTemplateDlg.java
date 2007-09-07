package hub.sam.tef.tdl.delegators;

import hub.sam.tef.tdl.model.TDLSequenceTemplate;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class TDLSequenceTemplateDlg extends SequenceTemplate {
	private final TDLSequenceTemplate tdlSequenceTemplate;
	private final TemplateFactory templateFactory;
	
	public TDLSequenceTemplateDlg(ElementTemplate elementTemplate, 
			TDLSequenceTemplate tdlSequenceTemplate,
			TemplateFactory templateFactory) {
		super(elementTemplate, tdlSequenceTemplate.getProperty().getName(), tdlSequenceTemplate.getSeparator(),
				tdlSequenceTemplate.isSeparateLast());	
		this.tdlSequenceTemplate = tdlSequenceTemplate;
		this.templateFactory = templateFactory;
	}

	@Override
	protected ValueTemplate<Object> createValueTemplate() {
		return (ValueTemplate<Object>)templateFactory.getTemplate(this, tdlSequenceTemplate.getValueTemplate());
	}	
}
