package hub.sam.tef.tdl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class TemplateValueTemplate extends ChoiceTemplate {
	
	public TemplateValueTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TemplateValue"));	
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new TDLTemplateInfixTemplate(this),
				new TemplateRefTemplate(this)
		};
	}

}
