package editortest.emf.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class PrimitiveLiteralExpTemplate extends ChoiceTemplate {

	public PrimitiveLiteralExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("PrimitiveLiteralExp"));	
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new StringLiteralExpTemplate(this),
				new IntegerLiteralExpTemplate(this),
				new BooleanLiteralExpTemplate(this)
		};
	}	
}
