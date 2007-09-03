package hub.sam.tef.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class LoopExpTemplate extends ChoiceTemplate{

	public LoopExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("LoopExp"));	
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
			new IteratorExpTemplate(this)
		};
	}	
}
