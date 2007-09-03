package editortest.emf.ocl.templates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class VariableTemplate extends ElementTemplate {

	public VariableTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Variable"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {			
					return new IdentifierTemplate(this);
				};
			}
		};
	}
	
	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}
}
