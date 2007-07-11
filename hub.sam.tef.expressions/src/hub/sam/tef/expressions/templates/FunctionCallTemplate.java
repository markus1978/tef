package hub.sam.tef.expressions.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class FunctionCallTemplate extends ElementTemplate {

	public FunctionCallTemplate(Template template) {
		super(template, template.getModel().getMetaElement("FunctionCall"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<IModelElement>(this, "function") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ReferenceTemplate(this, getModel().getMetaElement("Function")) {
						@Override
						protected ElementTemplate getElementTemplate() {
							return new ElementTemplate(this, getModel().getMetaElement("Function")) {
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
									return "Function_id";
								}								
							};
						}						
					};
				}				
			},
			new TerminalTemplate(this, "("),
			new SequenceTemplate<IModelElement>(this, "arguments", ",", false) {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ExpressionTemplate(this);
				}				
			},
			new TerminalTemplate(this, ")"),
		};
	}
	
}
