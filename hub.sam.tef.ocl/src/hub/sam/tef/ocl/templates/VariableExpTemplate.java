package hub.sam.tef.ocl.templates;

import org.eclipse.emf.ocl.expressions.VariableExp;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class VariableExpTemplate extends ElementTemplate {

	public VariableExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("VariableExp")); 
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { new SingleValueTemplate<IModelElement>(this,
				"referredVariable") {
			@Override
			protected ValueTemplate<IModelElement> createValueTemplate() {
				return new ReferenceTemplate(this, getModel().getMetaElement(
						"Variable")) {
					@Override
					protected ElementTemplate getElementTemplate() {
						return new VariableTemplate(this);
					}
				};
			}
		} };
	}	
}
