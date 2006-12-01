package editortest.emf.expressions.templates;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

public abstract class OperatorTemplate extends AbstractExpressionTemplate {

	public OperatorTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);
	}
	
	protected abstract String getOperatorString();

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new SingleValueTemplate<IModelElement>(this, "operand1") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return getExpressionTemplate();
					}					
				},
				new TerminalTemplate(this, getOperatorString(), TerminalTemplate.KEY_WORD_HIGHLIGHT),
				new SingleValueTemplate<IModelElement>(this, "operand2") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return getExpressionTemplate();
					}					
				}
		};
	}
	
}
