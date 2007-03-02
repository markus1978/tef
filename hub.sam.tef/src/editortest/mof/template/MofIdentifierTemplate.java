package editortest.mof.template;

import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class MofIdentifierTemplate extends MofNamedElementTemplate {	
	
	public MofIdentifierTemplate(Template template) {
		super(template, template.getModel().getMetaElement("NamedElement"));			
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new SingleValueTemplate(this, "name") {
					@Override
					protected ValueTemplate createValueTemplate() {
						return new StringTemplate(this);
					}
				}
		};
	}

}
