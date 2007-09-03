package editortest.emf.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class NavigationCallExpTemplate extends ChoiceTemplate {

	public NavigationCallExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("NavigationCallExp"));	
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new PropertyCallExpTemplate(this) 
		};
	}

}
