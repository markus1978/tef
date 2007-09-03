package hub.sam.tef.ocl.templates;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class EIdentifierTemplate extends ElementTemplate {
	
	private final String fSymbol;
	
	public EIdentifierTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EModelElement"));			
		fSymbol = null;
	}
		
	@Override
	protected String getAlternativeSymbol() {
		return fSymbol;
	}
	
	public EIdentifierTemplate(Template template, String metaModelElement, String symbolName) {
		super(template, template.getModel().getMetaElement(metaModelElement));
		this.fSymbol = symbolName;
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new SingleValueTemplate(this, "name") {
					@Override
					protected ValueTemplate createValueTemplate() {
						return new IdentifierValueTemplate(this);
					}
				}
		};
	}
	
	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}
}
