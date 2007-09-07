package hub.sam.tef.tdl.delegators;

import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.tdl.model.TDLElementTemplate;
import hub.sam.tef.tdl.model.TemplateValue;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;

import java.util.ArrayList;

public class TDLElementTemplateDlg extends ElementTemplate {

	private final TDLElementTemplate tdlElementTemplate;
	private final TemplateFactory factory;
	
	public TDLElementTemplateDlg(Template template, TDLElementTemplate tdlElementTemplate,
			TemplateFactory factory) {
		super(template, template.getModel().getMetaElement(tdlElementTemplate.getMetaElement().getName()));
		this.tdlElementTemplate = tdlElementTemplate;
		this.factory = factory;
	}

	public TDLElementTemplateDlg(IDocumentModelProvider modelProvider, TDLElementTemplate tdlElementTemplate,
			TemplateFactory factory) {
		super(modelProvider, modelProvider.getModel().getMetaElement(tdlElementTemplate.getMetaElement().getName()));
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
	protected String getAlternativeSymbol() {
		return tdlElementTemplate.getName();
	}

	@Override
	protected boolean isIdentifierProperty(String property) {
		if (tdlElementTemplate.getIdentifierProperty() != null) {			
			return tdlElementTemplate.getIdentifierProperty().getName().equals(property);
		} else {
			return super.isIdentifierProperty(property);
		}
	}

}
