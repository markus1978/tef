package hub.sam.tef.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class ImplicitSelfPropertyCallTemplate extends ElementTemplate {

	public ImplicitSelfPropertyCallTemplate(Template template) {
		super(template, template.getModel().getMetaElement("PropertyCallExp"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new SingleValueTemplate<IModelElement>(this, "referredProperty") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {						
						return new ReferenceTemplate(this, getModel().getMetaElement("EStructuralFeature")) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new EIdentifierTemplate(this);
							}						
						};						
					}					
				}
		};
	}		

	// TODO How to set the source to "self"?!
}
