package hub.sam.tef.expressions.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class ParameterAccessTemplate extends ElementTemplate {

	public ParameterAccessTemplate(Template template) {
		super(template, template.getModel().getMetaElement("ParameterAccess"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<IModelElement>(this, "parameter") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ReferenceTemplate(this, getModel().getMetaElement("Parameter")) {
						@Override
						protected ElementTemplate getElementTemplate() {
							return new ParameterTemplate(this);
						}						
					};
				}				
			},			
		};
	}
	
}
