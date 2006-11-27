package editortest.emf.ecoretemplates;

import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;

public class IdentifierValueTemplate extends StringTemplate {

	
	public IdentifierValueTemplate(Template template) {
		super(template);
	}

	@Override
	protected boolean verifyValue(String value) {
		return value.matches("([a-zA-Z][a-zA-Z0-9_]*)?");
	}

}
