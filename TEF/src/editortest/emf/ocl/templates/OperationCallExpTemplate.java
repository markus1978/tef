package editortest.emf.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class OperationCallExpTemplate extends ChoiceTemplate {

	public OperationCallExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("OperationCallExp"));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				//new OperationCallExp1Template(this),
				new OperationCallExp2Template(this)
		};
	}

}
