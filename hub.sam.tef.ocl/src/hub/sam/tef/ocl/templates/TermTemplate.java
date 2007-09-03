package hub.sam.tef.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class TermTemplate extends ChoiceTemplate {

	public TermTemplate(Template template) {
		super(template, template.getModel().getMetaElement("OCLExpression"));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new MulTemplate(this),
				new FactorTemplate(this)
		};
	}

	@Override
	public String getAlternativeSymbol() {
		return "Term";
	}
}
