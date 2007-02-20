package editortest.emf.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class OperationCallExpTemplate extends ChoiceTemplate<IModelElement> {

	public OperationCallExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("OperationCallExp"));
	}

	@Override
	public ValueTemplate<? extends IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new OperationCallExp1Template(this),
				new OperationCallExp2Template(this)
		};
	}

}
