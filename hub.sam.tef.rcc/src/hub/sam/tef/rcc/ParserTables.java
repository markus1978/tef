package hub.sam.tef.rcc;

import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.rcc.syntax.Syntax;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
	Responsibilities of (bottom-up) parser tables, that must provide:
	<ul>
		<li>all terminals, without EPSILON (for the Lexer)</li>
		<li>the syntax</li>
		<li>the follow-state from the GOTO-table</li>
		<li>the follow action from the PARSE-ACTION-table</li>
		<li>a list of expected terminals</li>
	</ul>

	@author (c) 2000, Fritz Ritzberger
*/

public interface ParserTables
{
	/** Special symbol occuring in a parser table, 0, means: syntax was correct when coming to that cell. */
	public static final Integer ACCEPT = new Integer(0);
	
	/** Special symbol occuring in a parser table, -1, means: error when coming to that cell. */
	public static final Integer ERROR = new Integer(-1);

	/** Special symbol occuring in a parser table, -2, means: read next token. */
	public static final Integer SHIFT = new Integer(-2);
	

	/**
		Returns the next state from the GOTO-table, for a given state and a received terminal or nonterminal.
		@param currentState the current parser state
		@param symbol recently received terminal or nonterminal
		@return new parser state
	*/
	public Integer getGotoState(Integer currentState, String symbol);

	/**
		Returns the action from the PARSE-ACTION-table, for a given state and received terminal.
		fuer einen gegebenen Zustand und ein Terminal.
		@param currentState the current parser state
		@param terminal recently received terminal
		@return new action to proceed, SHIFT, ACCEPT, ERROR, or anything above zero, meaning REDUCE.
	*/
	public Integer getParseAction(Integer currentState, String terminal);
	
	public Collection<String> getGotoSymbolsForState(Integer currentState);

	/**
		Returns the List of treminals, without EPSILON.
	*/
	public List getTerminals();
	
	/**
		Returns the input syntax.
	*/
	public Syntax getSyntax();

	/**
		Dumps rules, GOTO-table, PARSE-ACTION-table, FIRST and FOLLOW sets, ...
	*/
	public void dump(PrintStream out);
	
	/**
		The keySet of returned Map contains all expected terminals for the current state.
		These can be used as Lexer hints.
	*/
	public Map getExpected(Integer state);
	
	/* HUB */
	/**
	 * @return all rules for reductions that are triggered by some terminals in
	 *         this state, i.e. all reductions in a "row" of a given state of a
	 *         parse table.
	 */
	public Collection<Rule> getPossibleReductionsForState(int state);
	
	/* HUB */
	/**
	 * @return all the possible actions mapped by triggering terminal that can
	 *         be caused in the given parser state. In other words it returns a
	 *         parser table row.
	 */
	public Map<String, Integer> getParserActions(int state);

}
