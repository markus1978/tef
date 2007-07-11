package hub.sam.tef.expressions.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class FunctionTemplate extends ElementTemplate {

	public FunctionTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Function"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
		    new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new IdentifierTemplate(this);
				}		    	
		    },
			new TerminalTemplate(this, "("),
			new SequenceTemplate<IModelElement>(this, "parameters", ",", false) {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ParameterTemplate(this);
				}								
			},
			new TerminalTemplate(this, ")"),
			new TerminalTemplate(this, ":="),
			new SingleValueTemplate<IModelElement>(this, "body") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ExpressionTemplate(this);
				}				
			},			
			new TerminalTemplate(this, ";")
		};
	}

}
