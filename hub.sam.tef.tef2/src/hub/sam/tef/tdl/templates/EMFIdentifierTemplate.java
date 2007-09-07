package hub.sam.tef.tdl.templates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class EMFIdentifierTemplate extends ElementTemplate {

	public EMFIdentifierTemplate(Template template) {
		super(template, template.getModel().getMetaElement("ENamedElement"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new IdentifierTemplate(this);
				}			
			}
		};
	}


	@Override
	protected String getAlternativeSymbol() {
		return "ENamedElement_identifier";
	}	
}
