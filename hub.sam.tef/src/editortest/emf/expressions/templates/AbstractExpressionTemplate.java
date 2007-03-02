package editortest.emf.expressions.templates;

import java.util.Arrays;
import java.util.Collection;

import hub.sam.tef.liveparser.FixToken;
import hub.sam.tef.liveparser.RegexpToken;
import hub.sam.tef.liveparser.SymbolRule;
import hub.sam.tef.liveparser.SyntaxRule;
import hub.sam.tef.liveparser.TokenRule;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.views.DocumentText;

public abstract class AbstractExpressionTemplate extends ElementTemplate {

	
	public AbstractExpressionTemplate(DocumentText document, IMetaModelElement metaModel) {
		super(document, metaModel);	
	}

	public AbstractExpressionTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);
	}

	protected ValueTemplate<IModelElement> getExpressionTemplate() {
		//return new LiveParseTemplate(this);
		return new ExpressionTemplate(this);
	};
	
}
