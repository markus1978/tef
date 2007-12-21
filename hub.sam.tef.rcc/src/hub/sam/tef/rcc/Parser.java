package hub.sam.tef.rcc;

import hub.sam.tef.rcc.syntax.Rule;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

/**
	The universal bottom-up parser algorithm. Runs with a Lexer (containing the input),
	ParserTables (containing the syntax), and a Semantic (optional).
	<pre>
	private static final String [][] syntax =	{
		{ "Start", "\"Hello\"", "\"World\"" },
		{ Token.IGNORED, "`whitespaces`" },
	};

	SyntaxSeparation separation = new SyntaxSeparation(new Syntax(syntax));
	LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());
	Lexer lexer = builder.getLexer();
	lexer.setInput("\tHello \r\n\tWorld\n");
	ParserTables parserTables = new SLRParserTables(separation.getParserSyntax());
	Parser parser = new Parser(parserTables);
	parser.parse(lexer, new PrintSemantic());
	</pre>

	TODO: implement error recovery: method recover()
	@author (c) 2000, Fritz Ritzberger
*/

public class Parser implements Serializable, Cloneable
{
	private Lexer lexer;
	private ParserTables tables;
	private transient Semantic semantic;
	protected Stack<Integer> stateStack = new Stack<Integer>();
	protected Stack valueStack = new Stack();
	protected Stack rangeStack = new Stack();
	private transient Object result;
	protected transient List inputTokens;
	protected transient List rangeList;
	protected transient Token.Range range = new Token.Range(null, null);
	private transient PrintStream out;
	private boolean passExpectedToLexer = true;
	// private boolean showConflicts;
	private final boolean DEBUG = Configuation.debug;
	
	@SuppressWarnings("unchecked")
	public Object clone() throws CloneNotSupportedException {
		Parser clone = (Parser)super.clone();
		clone.stateStack = copy(stateStack, new Stack());
		clone.valueStack = copy(valueStack, new Stack());
		clone.rangeStack = copy(rangeStack, new Stack());
		clone.rangeList = copy(rangeList, new ArrayList());
		clone.inputTokens = copy(inputTokens, new ArrayList());
		return clone;
	}
	
	@SuppressWarnings("unchecked")
	private <T extends Collection > T copy(T original, T copy) {		
		for (Object o: copy) {
			original.add(o);
		}
		return original;
	}	
	
	/**
		Create a generic bottom-up Parser with passed ParserTables (representing the current syntax to apply).
		@param tables ParserTables representing the syntax.
	*/
	public Parser(ParserTables tables)	{
		this.tables = tables;
	}
	

	/** Returns the parsing result built from Semantic call return values. Retrievable after parsing. */
	public Object getResult()	{
		return result;
	}
	
//	/** Sets if SHIFT/REDUCE or REDUCE/REDUCE conflicts wil be shown on System.err. */
//	public void setShowConflicts(boolean showConflicts)	{
//		this.showConflicts = showConflicts;
//	}
	
	/**
		Sets the lexer to be used for parsing. The Lexer contains (or will contain) the input to parse.
		The Parser calls <i>setTerminals()</i> on this call.
	*/
	public void setLexer(Lexer lexer)	{
		boolean initLexer = (this.lexer != lexer);	// look if passed lexer needs terminals
		this.lexer = lexer;
		clear();	// clear if reused
		if (initLexer)
			lexer.setTerminals(getParserTables().getTerminals());	// pass terminals to lexer
	}
	
	/** Returns the lexer that was set to this parser, to call <i>setInput()</i> to the lexer. */
	public Lexer getLexer()	{
		return lexer;
	}
	
	/** Sets the input to contained lexer, or throws IllegalStateException if no lexer was set. */
	public void setInput(Object input)
		throws IOException
	{
		if (lexer == null)
			throw new IllegalStateException("Can not set input when no lexer was defined!");
		clear();	// clear if reused
		lexer.setInput(input);
	}

	/** Sets the semantic to be applied to parsing results. */
	public void setSemantic(Semantic semantic)	{
		this.semantic = semantic;
	}

	/** Returns the semantic that was set to this parser. */
	public Semantic getSemantic()	{
		return semantic;
	}

	/** Returns current ParserTables. */
	public ParserTables getParserTables()	{
		return tables;
	}

	/** Default is true. When true, the Parser will pass a Map of expected symbols to Lexer at every token request. */
	public void setPassExpectedToLexer(boolean passExpectedToLexer)	{
		this.passExpectedToLexer = passExpectedToLexer;
	}
	


	// bottom-up state machine methods
	
	private Integer top()	{
		return (Integer) stateStack.peek();
	}
	
	protected void push(Integer state, Object result, Token.Range range)	{
		stateStack.push(state);
		semanticPush(result, range);
	}

	protected void pop(int pops)	{
		inputTokens = new ArrayList();
		rangeList = new ArrayList();
		
		if (pops != 0) {
			for (int i = 0; i < pops; i++)	{
				stateStack.pop();
				semanticPop(i, pops);
			}
		} else {			
			if (!rangeStack.isEmpty()) {
				this.range = new Token.Range(((Token.Range)rangeStack.peek()).end, ((Token.Range)rangeStack.peek()).end); 
				// needed due to this ugly way of creating a range for the next
				// push, which is not executed when semanticPop is never called.
			}
		}
	}

	private void semanticPush(Object result, Token.Range range)	{
		if (semantic != null)	{	// when a semantic is present
			valueStack.push(result);	// we need to know parse result
			rangeStack.push(range);	// and its start-end positions within input text
		}
	}

	private void semanticPop(int popIndex, int countOfPops)	{
		if (semantic != null)	{
			// the value pop
			inputTokens.add(0, valueStack.pop());
			
			// the range pop
			Token.Range currentRange = (Token.Range) rangeStack.pop();
			rangeList.add(0, currentRange);
			
			if (popIndex == 0)	// first pop of right side holds last token value
				this.range = new Token.Range(null, currentRange.end);	// helper to remember end address
				
			if (popIndex == countOfPops - 1)	// if it is the last pop, make a valid range for next push()
				this.range = new Token.Range(currentRange.start, this.range.end);
		}
	}

	/**
		Reduce a rule when input satisfied it. Pop the stack n times, n is the number of right symbols of the rule.
		Semantic gets called with all input tokens corresponding to the rule, if not null.
		A new state gets pushed, determined by the new state (after pops) and the nonterminal of the rule (left side).
	*/
	protected void reduce(Integer ruleIndex)	{
		if (DEBUG)
			dump("reduce "+ruleIndex);

		Rule rule = getParserTables().getSyntax().getRule(ruleIndex.intValue());
		pop(rule.rightSize());	// pop count of elements on right side
		
		semanticReduce(rule);
		
		String nonterminal = rule.getNonterminal();
		push(getParserTables().getGotoState(top(), nonterminal), result, range);
		
		dumpStack();
	}

	private void semanticReduce(Rule rule)	{
		if (semantic != null)	{
			result = semantic.doSemantic(rule, inputTokens, rangeList);
		}
	}
	
	/**
		Push a new state upon state stack, determined by the GOTO table with current state
		and the received token symbol. Then read a new token from Lexer, trying to evaluate a rule.
	*/
	protected Token shift(Token token)
		throws IOException
	{
		if (DEBUG)
			dump("shift from token symbol >"+token.symbol+"<");

		shiftOntoStack(token);
		
		Token newToken = getNextToken();
		if (DEBUG)
			dump("next token "+newToken.symbol+" >"+newToken.text+"<");

		return newToken;
	}
	
	protected void shiftOntoStack(Token token) {
		push(getParserTables().getGotoState(top(), token.symbol), token.text, token.range);
		dumpStack();
	}
	
	/** Delivers the next token from lexer to parser. Override to convert the Token value. */
	protected Token getNextToken()
		throws IOException
	{
		Map expected = passExpectedToLexer && top().intValue() >= 0 ? getParserTables().getExpected(top()) : null;
		Token token = lexer.getNextToken(expected);
		return token;
	}
	

	// public parsing methods
	
	/**
		Parse the tokens returned from passed lexer. This call is for checking correctness without semantics.
		@param lexer the Lexer, loaded with input to scan.
		@return true when input was syntactically correct.
	*/
	public boolean parse(Lexer lexer)
		throws IOException
	{
		setLexer(lexer);
		return parse();
	}
	
	/**
		Parse the tokens returned from passed lexer. This call is for processing input with semantics.
		At least <i>setLexer()</i> must have been called before.
		@param semantic the semantic to apply to parser results.
		@return true when input was syntactically correct.
	*/
	public boolean parse(Semantic semantic)
		throws IOException
	{
		if (lexer == null)
			throw new IllegalStateException("No lexer was defined to scan input!");
		setSemantic(semantic);
		return parse();
	}
	
	/**
		Parse the tokens returned from passed input.
		At least <i>setLexer()</i> must have been called before.
		@param input the input to parse, as File, InputStream, String, ....
		@return true when input was syntactically correct.
	*/
	public boolean parse(Object input)
		throws IOException
	{
		setInput(input);
		return parse();
	}
	
	/**
		Parse the tokens returned from passed lexer. This call is for integrating a semantic.
		@param lexer Lexer containing the input to parse
		@param semantic the semantic to apply to parser results.
		@return true when input was syntactically correct.
	*/
	public boolean parse(Lexer lexer, Semantic semantic)
		throws IOException
	{
		setLexer(lexer);
		setSemantic(semantic);
		return parse();
	}
	
	/**
		Parse the tokens returned from passed lexer. This call is for integrating a semantic.
		@param input the input to parse, as File, InputStream, String, ....
		@param semantic the semantic to apply to parser results.
		@return true when input was syntactically correct.
	*/
	public boolean parse(Object input, Semantic semantic)
		throws IOException
	{
		setInput(input);
		setSemantic(semantic);
		return parse();
	}
		
	/**
		Start parsing after setting Lexer and optionally Semantic. At least <i>setLexer()</i> must have been called before.
		<p>
		Init the parser, read first token, push state 0 and set action to SHIFT.
		Loop while action is not ERROR or ACCEPT, and token symbol is not ERROR, and top of stack is not ERROR.
		Within loop, get next action from PARSE-ACTION table using current state and token symbol.
		When action greater than zero, call reduce(), else when action is SHIFT, call shift().
		@return true when input was syntactically correct.
	*/
	public boolean parse()
		throws IOException
	{
		stateStack.push(new Integer(0));	// push first state on stack
		return resumeParse();
	}
	
	/* HUB */
	/**
	 * A split for the original parse method. Allows to resume parsing after a
	 * finished completion parsing. When resume parsing the getNextToken method
	 * should behave differently from the last parse run.
	 */
	protected boolean resumeParse() throws IOException {
		Integer action = ParserTables.SHIFT;	// some allowed initial value
		Token token = getNextToken();	// start reading input
		setActualToken(token);
		if (DEBUG) {
			dump("initial token symbol >"+token.symbol+"<, text >"+token.text+"<");
		}
		
		while (token.symbol != null &&	// lexer error
				action.equals(ParserTables.ACCEPT) == false &&	// input accepted
				action.equals(ParserTables.ERROR) == false &&	// parse-action table error
				top().equals(ParserTables.ERROR) == false)	// goto table error
		{
			action = getParserTables().getParseAction(top(), token.symbol);
			
			if (action.intValue() > 0) {
				reduce(action);
			} else if (action.equals(ParserTables.SHIFT)) {
				token = shift(token);
			}
			
			action = recover(action, token);
		}
		
		return detectError(token, top(), action);
	}
	
	protected void setActualToken(Token token) {
		
	}
	
	protected int recover(Integer action, Token token) throws IOException {
		return action;
	}
	
	/**
		Called after parse loop to determine if everything was OK.
		@return true when action is ACCEPT, token.symbol is EPSILON, and state is not ERROR.
	*/
	protected boolean detectError(Token token, Integer state, Integer action)	{
		boolean ret = true;
		
		if (token.symbol == null || action.equals(ParserTables.ERROR))	{
			if (token.symbol == null)
				ensureOut().println("ERROR: Unknown symbol: >"+token.text+"<, state "+state);
			else
				ensureOut().println("ERROR: Wrong symbol: "+(Token.isEpsilon(token) ? "EOF" : token.symbol+", text: >"+token.text+"<")+", state "+state);

			lexer.dump(out);

			Map h = getParserTables().getExpected(state);
			if (h != null)	{
				ensureOut().print("Expected was (one of): ");
				
				for (Iterator it = h.keySet().iterator(); it.hasNext(); )	{
					String s = (String) it.next();
					ensureOut().print((Token.isEpsilon(s) ? "EOF" : s)+(it.hasNext() ? ", " : ""));
				}
				ensureOut().println();
			}

			ret = false;
		} else if (state.equals(ParserTables.ERROR))	{	// ERROR lies on stack, from SHIFT
			pop(1);
			ensureOut().println("ERROR: found no possible follow state for "+top()+", text >"+token.text+"<");
			lexer.dump(out);
			ret = false;
		} else if (Token.isEpsilon(token) == false)	{
			ensureOut().println("ERROR: Input is not finished.");
			lexer.dump(out);
			ret = false;
		} else if (action.equals(ParserTables.ACCEPT) == false)	{
			ensureOut().println("ERROR: Could not achieve ACCEPT. Symbol: "+token.symbol);
			lexer.dump(out);
			ret = false;
		}

		if (ret == false)
			result = null;
		
		return ret;
	}


	private void clear()	{
		stateStack.removeAllElements();
		valueStack.removeAllElements();
		rangeStack.removeAllElements();
		range = new Token.Range(null, null);
		inputTokens = null;
		result = null;
		if (lexer != null)
			lexer.clear();
	}



	private void dumpStack()	{
		if (DEBUG)	{
			ensureOut().print("stack: ");
			for (int i = 0; i < stateStack.size(); i++)
				ensureOut().print(stateStack.elementAt(i)+" ");
			ensureOut().println();
		}
	}

	private void dump(String s)	{
		ensureOut().println(s);
	}
	
	private PrintStream ensureOut()	{
		if (out == null)
			out = System.err;
		return out;
	}
	
	/** Debug output will go to passed stream. */
	public void setPrintStream(PrintStream out)	{
		this.out = (out != null) ? out : System.err;
	}
	
	/** Set the debug mode. */
	@Deprecated
	public void setDebug(boolean debug)	{
		// deactivated, use global configuration
		//DEBUG = debug;
	}
	
}
