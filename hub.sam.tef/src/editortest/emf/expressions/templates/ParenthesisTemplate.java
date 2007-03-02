
package editortest.emf.expressions.templates;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.views.DocumentText;

public class ParenthesisTemplate extends AbstractExpressionTemplate {

	
	public ParenthesisTemplate(DocumentText document, IMetaModelElement metaModel) {
		super(document, metaModel);	
	}

	public ParenthesisTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Parenthesis"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate(this, "(", TerminalTemplate.KEY_WORD_HIGHLIGHT),
				new SingleValueTemplate<IModelElement>(this, "subexpression") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return getExpressionTemplate();
					}					
				},
				new TerminalTemplate(this, ")", TerminalTemplate.KEY_WORD_HIGHLIGHT)
		};
	}
}
