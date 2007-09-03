package hub.sam.tef.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class FeatureCallExpTemplate extends ChoiceTemplate {

	public FeatureCallExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("FeatureCallExp"));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
			new NavigationCallExpTemplate(this),
			new OperationCallExpTemplate(this)
		};
	}	
}
