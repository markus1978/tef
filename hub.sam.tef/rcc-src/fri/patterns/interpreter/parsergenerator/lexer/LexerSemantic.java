package fri.patterns.interpreter.parsergenerator.lexer;

import java.util.Set;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
 * LexerSemantic receives a Rule and its a ResultTree with range.
 * It can look inside the syntax tree of a scanned token.
 * Calling resultTree.toString() will return the scanned text for that rule.
 * The responsibility of a LexerSemantic is to provide a Set of nonterminal
 * Strings contained in the used lexer syntax which it wants to process.
 * If it provides no such Set, all rules are passed to the Semantic (which
 * will be very time-consuming).
 * 
 * Created on 21.09.2005
 * @author Fritz Ritzberger
 */
public interface LexerSemantic
{
	/**
	 * This is called by LexerImpl with a lexing Rule and its scanned result tree and range.
	 * Calling <i>resultTree.toString()</i> will return the scanned text for the rule.
	 * Calling <i>resultTree.getRange()</i> will return the range of the rule within input. 
	 * No value stack is available for that semantic, so the method does not return anything. 
	 */
	public void ruleEvaluated(Rule rule, ResultTree resultTree);
	
	/**
	 * Can return the String Set of nonterminals (must occur in syntax on left side)
	 * this LexerSemantic wants to dispatch. Returning null will enable all nonterminals or rules.
	 */
	public Set getWantedNonterminals();

	/**
	 * Can return the String Set of nonterminals (must occur in syntax on left side)
	 * this LexerSemantic does not want to dispatch. This is an alternative to
	 * <i>getWantedNonterminals()</i>. Returning null will not ignore any nonterminal or rule.
	 */
	public Set getIgnoredNonterminals();

}
