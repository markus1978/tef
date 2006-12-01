package editortest.emf.expressions.templates;

import editortest.emf.expressions.LiveParseText;
import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.IValueChangeListener;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.views.Text;

public class ExpressionTemplate extends ChoiceTemplate<IModelElement> {

	public ExpressionTemplate(Template template) {
		super(template);
	}

	@Override
	public ValueTemplate<? extends IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new IdentifierTemplate(this),
				new PlusTemplate(this),
				new TimesTemplate(this),
				new ParenthesisTemplate(this)
		};
	}

	@Override
	public Text createView(IModelElement model, IValueChangeListener<IModelElement> changeListener) {
		if (model != null) {
			return super.createView(model, changeListener);
		} else {
			Text result = new LiveParseText();
			result.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));
			return result;
		}
	}	
	
}
