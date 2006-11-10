package editortest.mof.template;

import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.ValueTemplate;

public class IdentifierTemplate extends MofNamedElementTemplate {	
	
	public IdentifierTemplate(Template template) {
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
