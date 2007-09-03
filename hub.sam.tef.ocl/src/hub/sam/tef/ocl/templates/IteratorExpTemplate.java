package hub.sam.tef.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class IteratorExpTemplate  extends ChoiceTemplate {

	public IteratorExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("IteratorExp"));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new IteratorExpTemplate1(this),
				new IteratorExpTemplate2(this),				
		};
	}	
}