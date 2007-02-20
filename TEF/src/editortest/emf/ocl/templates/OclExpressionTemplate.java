package editortest.emf.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class OclExpressionTemplate extends ChoiceTemplate<IModelElement> {	
	
	public OclExpressionTemplate(Template template) {
		super(template, template.getModel().getMetaElement("OCLExpression"));
	}

	@Override
	public ValueTemplate<? extends IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new CallExpTemplate(this),
				new VariableExpTemplate(this)
		};
	}
}
