package hub.sam.tef.ocl.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.EmtpyElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class FactorTemplate extends ChoiceTemplate {

	public FactorTemplate(Template template) {
		super(template, template.getModel().getMetaElement("OCLExpression"));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new NotTemplate(this),
				new LetExpTemplate(this),
				new OclExpressionTemplate(this),
				new EmtpyElementTemplate(this, this.getModel().getMetaElement("OCLExpression")) {
					@Override
					public Template[] createTemplates() {
						return new Template[] {
								new TerminalTemplate(this, "("),
								ExpTemplate.getExpTemplate(this),
								new TerminalTemplate(this, ")"),
						};
					}									
				}				
		};
	}
	
	@Override
	public String getAlternativeSymbol() {
		return "Factor";
	}
}
