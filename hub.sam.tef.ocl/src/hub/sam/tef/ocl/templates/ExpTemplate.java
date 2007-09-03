package editortest.emf.ocl.templates;

import java.util.HashMap;
import java.util.Map;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class ExpTemplate extends ChoiceTemplate {
	
	private static final Map<Template, ExpTemplate> instances = new HashMap<Template, ExpTemplate>();
	public static final ExpTemplate getExpTemplate(Template template) {
		ExpTemplate result = instances.get(template);	
		if (result == null) {
			result = new ExpTemplate(template);
			instances.put(template, result);
		}
		return result;
	}
	
	private ExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("OCLExpression"));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new PlusTemplate(this),
				new TermTemplate(this)
		};
	}

	@Override
	public String getAlternativeSymbol() {
		return "Exp";
	}
	
	
}
