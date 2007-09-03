package hub.sam.tef.ocl.templates;

import java.util.Arrays;
import java.util.Collection;

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
				new OperationCallExp1Template(this),
				new OperationCallExp2Template(this),
				new OperationCallExp3Template(this),
		};
	}

	private static final Collection<String> falseOperationNames = Arrays.asList(new String[] {
			"+", "-", "*", "/", "and", "or", "implies", "xor", "not"
	});
	
	
	@Override
	public boolean isTemplateFor(IModelElement model) {
		IModelElement operation = (IModelElement)model.getValue("referredOperation");
		if (operation != null) {
			String name = (String)operation.getValue("name");
			if (name != null && falseOperationNames.contains(name)) {
				return false;
			}
		}
		return super.isTemplateFor(model);
	}	
}
