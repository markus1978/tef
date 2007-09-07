package hub.sam.tef.tdl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class TDLTemplateInfixTemplate extends ChoiceTemplate {

	
	public TDLTemplateInfixTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLTemplate"));	
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
			new TDLElementTemplateInfixTemplate(this),			
			new TDLReferenceTemplateTemplate(this),
			new TDLIdentifierTemplateTemplate(this),
			new TDLIntegerTemplateTemplate(this),
			new TDLUnsignedIntegerTemplateTemplate(this),
			new TDLStringLiteralTemplateTemplate(this),
			new TDLBooleanLiteralTemplateTemplate(this)
		};
	}

	@Override
	public String getAlternativeSymbol() {
		return "TDLTemplate_infix";
	}
	
}
