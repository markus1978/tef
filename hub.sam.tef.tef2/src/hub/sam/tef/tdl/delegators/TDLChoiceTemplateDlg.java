package hub.sam.tef.tdl.delegators;

import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.tdl.model.TDLChoiceTemplate;
import hub.sam.tef.tdl.model.TemplateValue;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

import java.util.ArrayList;

public class TDLChoiceTemplateDlg extends ChoiceTemplate {
	
	private final TDLChoiceTemplate choiceTemplate;
	private final TemplateFactory factory;

	public TDLChoiceTemplateDlg(Template template, TDLChoiceTemplate choiceTemplate,
			TemplateFactory factory) {
		super(template, template.getModel().getMetaElement(choiceTemplate.getMetaElement().getName()));
		this.choiceTemplate = choiceTemplate;
		this.factory = factory;
	}

	public TDLChoiceTemplateDlg(IDocumentModelProvider modelProvider, TDLChoiceTemplate choiceTemplate,
			TemplateFactory factory) {
		super(modelProvider, modelProvider.getModel().getMetaElement(choiceTemplate.getMetaElement().getName()));
		this.choiceTemplate = choiceTemplate;
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		ArrayList<Template> result = new ArrayList<Template>();
		for (Object o: choiceTemplate.getAlternatives()) {
			result.add(factory.getTemplate(this, (TemplateValue)o));
		}
		return result.toArray(new ValueTemplate[] {});
	}

	@Override
	public String getAlternativeSymbol() {
		return choiceTemplate.getName();
	}
	
}
