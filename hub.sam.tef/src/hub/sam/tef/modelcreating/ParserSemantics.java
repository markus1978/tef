package hub.sam.tef.modelcreating;

import hub.sam.tef.rcc.Semantic;
import hub.sam.tef.rcc.Token.Range;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.impl.SyntaxImpl;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.Position;

/**
 * A specific RCC parser semantic that creates a parse tree ({@link ParseTreeNode}).
 * This class uses a TSL syntax to relate RCC parse actions to TSL syntax rules.
 */
public class ParserSemantics implements Semantic {
	
	public boolean DEBUG = false;
	
	private final Syntax fSyntax;
	/**
	 * The last parse tree node created. This is used as a "return" value for a
	 * parser run with this semantics.
	 */
	private ParseTreeNode lastResult = null;
	/**
	 * The hole text as string. This variable is only used to put a reference to the
	 * text into each parse tree node.
	 */
	private String fText = null;
	
	public ParserSemantics(Syntax syntaxDescription) {
		super();
		fSyntax = syntaxDescription;	
	}
	
	/**
	 * Called by the {@link Parser} to initialise the semantics. It is not in
	 * the constructor, because it is not given explicitly, only implicit
	 * through the parser.
	 */
	public final void setText(String text) {
		fText = text;
	}

	/**
	 * The actual semantics method. It creates a {@link ParseTreeRuleNode} for
	 * each reduction (non terminal) and created a {@link ParseTreeValueNode}
	 * for each terminal. The nodes are initialised with the according ranges.
	 */
	@SuppressWarnings("unchecked")
	public Object doSemantic(hub.sam.tef.rcc.syntax.Rule rccRule, 
			List parseResults, List<Range> resultRanges) {
		/* The reduction for the start symbol is ignored, i.e. no tree node is
		 * created, because the start symbol and an according rule is only
		 * part of the syntax, because RCC requires a single top-level symbol.
		 * This start rule is not part of the TSL syntax as initially provided
		 * by the language engineer.
		 */
		if (rccRule.getNonterminal().equals(SyntaxImpl.START_SYMBOL)) {
			if (parseResults.size() != 1) {
				throw new RuntimeException(new TslException("Unexpected start symbol rule."));
			} else {
				lastResult = (ParseTreeNode)parseResults.get(0);
				return lastResult;
			}
		}
		
		Rule rule;
		try {
			rule = fSyntax.getRuleForRccRule(rccRule);
		} catch (TslException e) {
			throw new RuntimeException(e);
		}
		
		if (rule == null) {
			if (resultRanges.size() == 0) {
				return new ParseTreeValueNode("");
			} else {
				ParseTreeValueNode result = new ParseTreeValueNode(
						fText.substring(resultRanges.get(0).start.offset, 
						resultRanges.get(resultRanges.size() - 1).end.offset));
				return result;
			}			
		} else {		
			ParseTreeRuleNode result = new ParseTreeRuleNode(rule);
			result.setText(fText);
			
			int i = 0;
			for (Object parseResultAsObject: parseResults) {
				ParseTreeNode parseResult = null;
				if (parseResultAsObject instanceof ParseTreeRuleNode) {
					parseResult = (ParseTreeRuleNode)parseResultAsObject;								
				} else {
					Object value = parseResultAsObject;
					parseResult = new ParseTreeValueNode(value);
					parseResult.setText(fText);
				}
				Range range = resultRanges.get(i);
				parseResult.setPosition(new Position(range.start.offset, 
						range.end.offset - range.start.offset));
				
				result.addChildNode(parseResult);				
				i++;
			}
			
			lastResult = result;
			return result;
		}
	}

	/**
	 * Not yet supported by RCC.
	 */
	public Object doSemanticForErrorRecovery(String recoverSymbol) {
		Assert.isTrue(false, "supposed unreachable");
		return null;
	}
	
	/**
	 * @return the lastly created parse tree node. This should be the top-level
	 *         node after a successful parser run.
	 */
	public ParseTreeNode getResult() {
		return lastResult;
	}
}
