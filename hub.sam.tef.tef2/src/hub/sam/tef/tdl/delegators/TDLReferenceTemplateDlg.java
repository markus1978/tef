package hub.sam.tef.tdl.delegators;

import hub.sam.tef.tdl.model.TDLReferenceTemplate;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.Template;

public class TDLReferenceTemplateDlg extends ReferenceTemplate {

	private final TDLReferenceTemplate tdlReferenceTemplate;
	private final TemplateFactory factory;
	
	public TDLReferenceTemplateDlg(Template template, TDLReferenceTemplate tdlReferenceTemplate,
			TemplateFactory factory) {
		super(template, template.getModel().getMetaElement(tdlReferenceTemplate.getMetaElement().getName()));
		this.tdlReferenceTemplate = tdlReferenceTemplate;
		this.factory = factory;
	}

	@Override
	protected ElementTemplate getElementTemplate() {
		return (ElementTemplate)factory.getTemplate(this, tdlReferenceTemplate.getElementTemplate());
	}
	
}
