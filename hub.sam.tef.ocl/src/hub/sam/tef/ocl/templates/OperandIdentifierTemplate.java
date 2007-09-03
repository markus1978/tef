package hub.sam.tef.ocl.templates;

import hub.sam.tef.templates.EnumerationTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class OperandIdentifierTemplate extends EIdentifierTemplate {

	private final String fSymbol;
	private final String[] fOperands;
	
	public OperandIdentifierTemplate(Template template, String symbol, String[] operands) {
		super(template, "EOperation", symbol + "_id");
		this.fSymbol = symbol;
		this.fOperands = operands;
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new SingleValueTemplate(this, "name") {
					@Override
					protected ValueTemplate createValueTemplate() {
						return new EnumerationTemplate(this, fSymbol, fOperands);
					}
				}
		};
	}
	
	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}
}
