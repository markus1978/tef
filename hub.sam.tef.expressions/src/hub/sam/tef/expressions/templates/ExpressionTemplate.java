package hub.sam.tef.expressions.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class ExpressionTemplate extends ChoiceTemplate {

	public ExpressionTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Expression"));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new PlusTemplate(this),
				new NumberTemplate(this),
				new ParameterAccessTemplate(this)
		};
	}

}
