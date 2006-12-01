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

	private static final String OBRACE = "obrace";
	private static final String CBRACE = "cbrace";
	private static final String EXPR = "expr";
	private static final String PLUS = "plus";
	private static final String TIMES = "times";
	private static final String ID = "id";

	public static final Collection<SyntaxRule> fRules = Arrays.asList(new SyntaxRule[] {
			new SymbolRule(EXPR, new Object[] {OBRACE, EXPR, CBRACE}),
			new SymbolRule(EXPR, new Object[] {EXPR, PLUS, EXPR}),
			new SymbolRule(EXPR, new Object[] {EXPR, TIMES, EXPR}),
			new SymbolRule(EXPR, new Object[] {ID}),
			
			new TokenRule(ID, new RegexpToken("[a-zA-Z0-9_]+")),
			new TokenRule(OBRACE, new FixToken("(")),
			new TokenRule(CBRACE, new FixToken(")")),
			new TokenRule(PLUS, new FixToken("+")),
			new TokenRule(TIMES, new FixToken("*")),
	});
	
	public static final Object fStartSymbol = EXPR; 
	
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
