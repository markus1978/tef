package hub.sam.tef.tdl.delegators;

import hub.sam.tef.tdl.model.TDLSingleValueTemplate;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class TDLSingleValueTemplateDlg extends SingleValueTemplate<Object> {

	private final TDLSingleValueTemplate tdlSingleValueTemplate;
	private final TemplateFactory templateFactory;
	
	public TDLSingleValueTemplateDlg(ElementTemplate elementTemplate, 
			TDLSingleValueTemplate tdlSingleValueTemplate,
			TemplateFactory templateFactory) {
		super(elementTemplate, tdlSingleValueTemplate.getProperty().getName());	
		this.tdlSingleValueTemplate = tdlSingleValueTemplate;
		this.templateFactory = templateFactory;
	}

	@Override
	protected ValueTemplate<Object> createValueTemplate() {
		return (ValueTemplate<Object>)templateFactory.getTemplate(this, tdlSingleValueTemplate.getValueTemplate());
	}	
	
}
