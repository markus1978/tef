package editortest.emf.ecoretemplates;

import editortest.template.ElementTemplate;
import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.ValueTemplate;

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
