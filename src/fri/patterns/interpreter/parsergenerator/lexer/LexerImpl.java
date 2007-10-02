package fri.patterns.interpreter.parsergenerator.lexer;

import java.util.*;
import java.io.*;
import fri.patterns.interpreter.parsergenerator.Lexer;
import fri.patterns.interpreter.parsergenerator.Token;

/**
	This Lexer must be created using LexerBuilder. It knows token and ignored terminals.
	To get this Lexer working the <i>setTerminals()</i> call must be called at least once.
	When using the Lexer standalone, the client must do this, else the Parser will
	call that method.
	<p>
	This lexer can be reused, but it can not be loaded with other syntaxes after it
	has been built for one.
	
	@author (c) 2002, Fritz Ritzberger
*/

public class LexerImpl implements
	Lexer,
	StrategyFactoryMethod,
	Serializable
{
	protected Strategy strategy;
	private List ignoredSymbols;
	private Map charConsumers;
	private transient InputText input;
	private List listeners;
	private transient boolean debug;
		
	/**
		Creates a Lexer from token- and ignored symbols, and a map of character consumers (built by LexerBuilder).
		@param ignoredSymbols list of Strings containing ignored symbols to scan. These are NOT enclosed in `backquotes` like tokens.
		@param charConsumers map with key = nonterminal and value = Consumer.
	*/
	public LexerImpl(List ignoredSymbols, Map charConsumers)	{
		setConsumers(ignoredSymbols, charConsumers);
	}
	
	/** Do-nothing constructor for subclasses (currently unused). */
	protected LexerImpl()	{
	}

	/** Implements Lexer. Adds the passed token listener to listener list. */
	public void addTokenListener(Lexer.TokenListener tokenListener)	{
		if (listeners == null)
			listeners = new ArrayList(1);
		listeners.add(tokenListener);
	}
	/** Implements Lexer. Removes the passed token listener from listener list. */
	public void removeTokenListener(Lexer.TokenListener tokenListener)	{
		if (listeners != null)
			listeners.remove(tokenListener);
	}
	

	private void setConsumers(List ignoredSymbols, Map charConsumers)	{
		this.charConsumers = charConsumers;	// store for check at setTerminals()
		this.ignoredSymbols = ignoredSymbols;	// need to know which token should be ignored
				
		for (int i = 0; ignoredSymbols != null && i < ignoredSymbols.size(); i++)	{	// ignored symbols will not be passed by the parser
			String sym = (String) ignoredSymbols.get(i);
			Consumer cc = (Consumer) charConsumers.get(sym);
			ensureStrategy().addIgnoringConsumer(sym, cc);
		}
		
		// propagate this LexerImpl as StrategyFactoryMethod to ConsumerAlternatives
		for (Iterator it = charConsumers.entrySet().iterator(); it.hasNext(); )	{
			Consumer c = (Consumer) ((Map.Entry) it.next()).getValue();
			if (c instanceof ConsumerAlternatives)	{
				((ConsumerAlternatives) c).setStrategyFactoryMethod(this);
			}
		}
	}

	private Strategy ensureStrategy()	{
		if (strategy == null)
			strategy = newStrategy();
		return strategy;
	}
	
	/** Implements StrategyFactoryMethod. To be overridden to create a derived Strategy implementation. */
	public Strategy newStrategy()	{
		return new Strategy();
	}
	
	/**
		When false, the sort order (significance) of scan items without fixed start character decide what token is returned.
		When true (default), the scan item (without fixed start character) that scnas longest wins.
	*/
	public void setCompeteForLongestInput(boolean competeForLongestInput)	{
		ensureStrategy().setCompeteForLongestInput(competeForLongestInput);
	}
	

	// implementing Lexer
	
	/**
		Implements Lexer: set the input to be scanned. If text is InputStream, no Reader
		will be used (characters will not be converted).
		@param text text to scan, as String, StringBuffer, File, InputStream, Reader.
	*/
	public void setInput(Object text)
		throws IOException
	{
		input = new InputText(text);
	}

	/**
		Implements Lexer: Parser call to pass all tokens symbols (all enclosed in `backquote`) and literals ("xyz").
		@param terminals List of String containing "literals" and `lexertokens`.
	*/
	public void setTerminals(List terminals)	{
		for (int i = 0; i < terminals.size(); i++)	{
			String symbol = (String) terminals.get(i);
			
			// check if it is a terminal as this is a public call
			if (symbol.length() <= 2 || Token.isTerminal(symbol) == false)
				throw new IllegalArgumentException("Terminals must be enclosed within quotes: "+symbol);
			
			String text = symbol.substring(1, symbol.length() - 1);	// remove quotes
			
			if (ensureStrategy().hasTerminal(symbol) == false)	{	// could have been called for second time
				if (symbol.charAt(0) == Token.COMMAND_QUOTE)	{	// is a scan terminal covered by a Consumer
					Consumer cc = (Consumer) charConsumers.get(text);
					if (cc == null)
						throw new IllegalArgumentException("Lexer token is not among character consumers: "+text);
					else
						ensureStrategy().addTokenConsumer(symbol, cc);
				}
				else	{
					ensureStrategy().addTokenConsumer(symbol, new Consumer(text));
				}
			}
		}	// end for
		
		if (debug)
			System.err.println("StrategyList is:\n"+strategy);
	}


	/** Implements Lexer: Does nothing as no states are stored. This Lexer can not be loaded with new syntaxes. */
	public void clear()	{
	}



	/**
		This is an optional functionality of Lexer. It is <b>NOT</b> called by the Parser.
		It can be used for heuristic reading from an input (not knowing if there is more input
		after the token was read).
		<p />
		The passed LexerSemantic will receive every matched rule (top-down) together with
		its ResultTree. See <i>lex()</i> for details.
		
		@param lexerSemantic the LexerSemantic to be called with every evaluated Rule and its lexing ResultTree.
		@return a Token with a terminal symbol and its instance text, or a Token with null symbol for error.
	*/
	public Token getNextToken(LexerSemantic lexerSemantic)
		throws IOException
	{
		return getNextToken(lexerSemantic, null);
	}
	
	/**
		Implements Lexer: returns the next token from input, or EPSILON when no more input.
		This is called by the Parser to get the next syntax token from input.
		When returned <i>token.symbol</i> is null, no input could be recognized (ERROR).
		@param expectedTokenSymbols contains the expected String token symbols (in keys),
				can be null when no Parser drives this Lexer.
		@return a Token with a terminal symbol and its instance text, or a Token with null symbol for error.
	*/
	public Token getNextToken(Map expectedTokenSymbols)
		throws IOException
	{
		return getNextToken(null, expectedTokenSymbols);
	}
	
	private Token getNextToken(LexerSemantic lexerSemantic, Map expectedTokenSymbols)
		throws IOException
	{
		if (input == null)
			throw new IllegalStateException("Lexer has no input, call setInput(...).");

		Token.Address start = new Token.Address(input.getScanLine(), input.getScanColumn(), input.getScanOffset());
		int c = input.peek();	// read lookahead
		if (c == Input.EOF)
			return createToken(Token.EPSILON, null, new Token.Range(start, start));

		// not EOF, there must be a lexer item or error
		Strategy.Item item = getNextLexerItem(expectedTokenSymbols, c);

		if (item != null)	{	// successful scan
			if (ignoredSymbols != null && ignoredSymbols.indexOf(item.getSymbol()) >= 0)	{
				if (listeners != null && listeners.size() > 0)	// creating a token takes time, do it only when listeners are present
					fireTokenReceived(createToken(item.getTokenIdentifier(), item.getResultTree(), lexerSemantic), true);
				return getNextToken(expectedTokenSymbols);
			}
			else	{
				Token token = createToken(item.getTokenIdentifier(), item.getResultTree(), lexerSemantic);
				fireTokenReceived(token, false);
				return token;
			}
		}

		// error state, return an error Token with null symbol
		Token.Address end = new Token.Address(input.getReadLine(), input.getReadColumn(), input.getScanOffset());
		return createToken(null, input.getUnreadText(), new Token.Range(start, end));
	}
	
	// strategic scan of next item
	private Strategy.Item getNextLexerItem(Map expectedTokenSymbols, int lookahead)
		throws IOException
	{
		if (strategy == null)
			throw new IllegalStateException("Lexer has no terminals, call setTerminals(syntaxSeparation.getTokenSymbols()).");

		Strategy.Item item = strategy.consume(input, lookahead, expectedTokenSymbols);
		
		if (item != null)
			input.resolveBuffer();	// forget old contents
			
		return item;
	}
	
	// calls the token listeners with scanned token
	private void fireTokenReceived(Token token, boolean ignored)	{
		for (int i = 0; listeners != null && i < listeners.size(); i++)
			((Lexer.TokenListener) listeners.get(i)).tokenReceived(token, ignored);
	}

	/** Token factory method. Can be overridden to access the lexing ResultTree. Delegates to createToken(tokenIdentifier, text, range). */
	protected Token createToken(String tokenIdentifier, ResultTree result, LexerSemantic lexerSemantic)	{
		if (lexerSemantic != null)
			loopResultTree(result, lexerSemantic);
		return createToken(tokenIdentifier, result.toString(), result.getRange());	// toString() takes time as it builds the token text
	}
	
	/** Token factory method. Can be overridden to convert token.text to some Java object. */
	protected Token createToken(String tokenIdentifier, String text, Token.Range range)	{
		return new Token(tokenIdentifier, text, range);
	}


	/**
		This is an optional functionality of Lexer. It is <b>NOT</b> called by the Parser.
		It can be used to run a standalone Lexer with a LexerSemantic, processing a ready-scanned
		syntax tree. Other than with Parser Semantic no value stack is available for LexerSemantic,
		and all input will have been read when LexerSemantic is called with the built syntax tree.
		<p />
		The passed LexerSemantic will receive every matched rule (top-down) together with
		its results ResultTree, containing the range within input.
		ResultTree can be converted to text by calling <i>resultTree.toString()</i>.
		<p />
		This method evaluates the input using end-of-input like a parser, that means it returns
		false if the input was either syntactically incorrect or EOF was not received when all rules
		have been evaluated.
		<p />
		<b>MIND:</b> This method does not call any TokenListener, as the LexerSemantic is expected to
			dispatch results!
		
		@param lexerSemantic the LexerSemantic to be called with every evaluated Rule and its lexing ResultTree.
		@return true when lexer succeeded (input was syntactically ok), else false.
	*/
	public boolean lex(LexerSemantic lexerSemantic)
		throws IOException
	{
		int c = input.peek();
		boolean eof = (c == Input.EOF);
		boolean error = eof;
		
		if (error == false)	{
			Strategy.Item item = getNextLexerItem(null, c);
			error = (item == null || item.getTokenIdentifier() == null);

			if (error == false && lexerSemantic != null)
				loopResultTree(item.getResultTree(), lexerSemantic);

			c = input.peek();
			eof = (c == Input.EOF);
			error = (eof == false);
		}
		
		if (error)	{
			dump(System.err);
			System.err.println("Could not process character '"+(char)c+"' (int "+c+"), at line/column "+input.getScanLine()+"/"+input.getScanColumn()+", at offset "+input.getScanOffset());
		}

		return error == false;
	}

	/**
		After top-down lexing this method is called to dispatch all results. Can be overridden to change dispatch logic.
		This method calls itself recursively with all result tree children. Nonterminals starting with "_" are ignored
		by default, as this marks artificial rules.
		@param result lexer result, returns text on getText().
		@param semantic semantic that dispatches the lexer results.
		@return a Token with the range and return of the Semantic call for this Rule/ResultTree.
	*/
	protected void loopResultTree(ResultTree result, LexerSemantic lexerSemantic)	{
		Set wantedNonterminals = lexerSemantic.getWantedNonterminals();
		Set ignoredNonterminals = lexerSemantic.getIgnoredNonterminals();
		String nonterminal = result.getRule().getNonterminal();
		
		if (nonterminal.startsWith(Token.ARTIFICIAL_NONTERMINAL_START_CHARACTER) == false &&
				(wantedNonterminals == null || wantedNonterminals.contains(nonterminal)) &&
				(ignoredNonterminals == null || ignoredNonterminals.contains(nonterminal) == false))
		{
			lexerSemantic.ruleEvaluated(result.getRule(), result);
		}
		
		for (int i = 0; i < result.getChildCount(); i++)	{
			Object child = result.getChild(i);
			if (child instanceof ResultTree)
				loopResultTree((ResultTree) child, lexerSemantic);
		}
	}



	// debug methods
	
	/** Implements Lexer: Set debug on to output information about scanned tokens. */
	public void setDebug(boolean debug)	{
		this.debug = debug;
	}

	/** Returns the current line, as far as read. */
	public String getLineText()	{
		return input.getLine();
	}
	
	/** Returns the number of the current line, 1-n. */
	public int getLine()	{
		return input.getReadLine();
	}

	/** Returns the position within the current line, 0-n. */
	public int getColumn()	{
		return input.getReadColumn();
	}
	
	/** Returns the offset read so far from input. This is an absolute offset, including newlines. */
	public int getOffset()	{
		return input.getScanOffset();
	}
	

	/** Outputs current and previous line, with line numbers. Call this on ERROR. */
	public void dump(PrintStream out)	{
		int lineNr = input.getReadLine();
		String line = getLineText();
		
		if (lineNr > 1)	{
			String prevLine = input.getPreviousLine();
			out.print((lineNr - 1)+":\t");
			out.println(prevLine);
		}
		
		out.print(lineNr+":\t");
		out.println(line);

		int nrLen = Integer.toString(lineNr).length();
		for (int i = 0; i < nrLen; i++)
			out.print(" ");

		out.print("\t");

		int errPos = input.getReadColumn();

		for (int i = 0; i < errPos && i < line.length(); i++)
			if (line.charAt(i) == '\t')
				out.print("\t");
			else
				out.print(" ");

		out.println("^");
	}

}
