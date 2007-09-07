package hub.sam.tef.tdl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class TDLTemplateTemplate extends ChoiceTemplate {

	
	public TDLTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLTemplate"));	
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
			new TDLElementTemplateTemplate(this),
			new TDLEmptyElementTemplateTemplate(this),
			new TDLChoiceTemplateTemplate(this),
			new TDLSingleValueTemplateTemplate(this),
			new TDLSequenceTemplateTemplate(this),
			new TDLTerminalTemplateTemplate(this)
		};
	}

}
