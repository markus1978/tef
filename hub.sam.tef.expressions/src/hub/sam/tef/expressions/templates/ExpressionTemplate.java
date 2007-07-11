package hub.sam.tef.expressions.templates;

import expressions.UnaryOperator;
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
				new BinaryOperatorTemplate(this, "Plus", "+"),
				new BinaryOperatorTemplate(this, "Minus", "-"),
				new BinaryOperatorTemplate(this, "Mul", "*"),
				new BinaryOperatorTemplate(this, "Div", "/"),
				new UnaryOperatorTemplate(this, "Neg", "-"),
				new NumberTemplate(this),
				new ParameterAccessTemplate(this),
				new FunctionCallTemplate(this)
		};
	}

}
