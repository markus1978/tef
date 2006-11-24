package editortest.emf.ecoretemplates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class EIdentifierTemplate extends ElementTemplate {
	
	public EIdentifierTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EModelElement"));			
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
	
	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}
}
