package editortest.emf.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class CallExpTemplate extends ChoiceTemplate {

	public CallExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("CallExp"));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new LoopExpTemplate(this),
				new FeatureCallExpTemplate(this)
		};
	}

}
