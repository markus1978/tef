package hub.sam.tef.tdl.delegators;

import hub.sam.tef.tdl.model.TDLEmptyElementTemplate;
import hub.sam.tef.tdl.model.TemplateValue;
import hub.sam.tef.templates.EmtpyElementTemplate;
import hub.sam.tef.templates.Template;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;

public class TDLEmptyElementTemplateDlg extends EmtpyElementTemplate {

	private final TDLEmptyElementTemplate tdlElementTemplate;
	private final TemplateFactory factory;
	
	public TDLEmptyElementTemplateDlg(Template template, TDLEmptyElementTemplate tdlElementTemplate, 
			EClass metaElement, TemplateFactory factory) {
		super(template, template.getModel().getMetaElement(metaElement.getName()));
		this.tdlElementTemplate = tdlElementTemplate;
		this.factory = factory;
	}

	@Override
	public Template[] createTemplates() {
		ArrayList<Template> result = new ArrayList<Template>();
		for (Object o: tdlElementTemplate.getTemplates()) {
			result.add(factory.getTemplate(this, (TemplateValue)o));
		}
		return result.toArray(new Template[] {});
	}

	@Override
	public String getAlternativeSymbol() {
		return tdlElementTemplate.getName();
	}	
}
