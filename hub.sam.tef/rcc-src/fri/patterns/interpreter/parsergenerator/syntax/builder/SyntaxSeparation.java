package fri.patterns.interpreter.parsergenerator.syntax.builder;

import java.util.*;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.syntax.*;
import fri.patterns.interpreter.parsergenerator.lexer.StandardLexerRules;

/**
	Separates lexer from parser rules. Provides token and ignored symbols
	after construction, which can be used for LexerBuilder construction.
	<p>
	Example:
	<pre>
		SyntaxSeparation separation = new SyntaxSeparation(new Syntax(myRules));
		LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());
		Lexer lexer = builder.getLexer();
		// when using the lexer standalone, you must put the token terminal symbols into it now:
		lexer.setTerminals(separation.getTokenSymbols());
		// when using a Parser the Parser will do this:
	</pre>
	
	@see fri.patterns.interpreter.parsergenerator.lexer.LexerBuilder
	@author (c) 2002, Fritz Ritzberger
*/

public class SyntaxSeparation
{
	private List tokenSymbols;
	private List ignoredSymbols;
	private Syntax parserSyntax;
	private Syntax lexerSyntax;
	public static boolean DEBUG = true;

	/** Splits a syntax into two syntaxes containing parser and lexer rules, tokens and ignored get collected. */
	public SyntaxSeparation(Syntax syntax)
		throws SyntaxException
	{
		separate(syntax, new IntArray(syntax.size()));
	}

	/** Returns the lexer syntax that remains after removing all parser rules and token/ignored directives. */
	public Syntax getLexerSyntax()	{
		return lexerSyntax;
	}

	/** Returns the parser syntax that remains after removing all lexer rules. All lexer tokens are marked with `backquotes`. */
	public Syntax getParserSyntax()	{
		return parserSyntax;
	}

	/**
		Returns the top level token symbols for the lexer. These symbols ARE enclosed within `backquotes`.
		This can be used at <i>setTerminals</i> call for a standalone Lexer.
	*/
	public List getTokenSymbols()	{
		return tokenSymbols;
	}

	/**
		Returns the top level ignored token symbols for the lexer. These symbols are NOT enclosed within `backquotes`.
		This will be used by the LexerBuilder for feeding the LexerImpl with ignored symbols.
	*/
	public List getIgnoredSymbols()	{
		return ignoredSymbols;
	}


	private void separate(Syntax syntax, IntArray deleteIndexes)
		throws SyntaxException
	{
		Hashtable tokenSymbols = new Hashtable();
		Hashtable ignoredSymbols = new Hashtable();
		List commandsDefinedAsTOKEN = new ArrayList();

		// take away all rules defined by "token" and "ignored"
		for (int i = 0; i < syntax.size(); i++)	{
			Rule rule = syntax.getRule(i);
			String nonterm = rule.getNonterminal();
			
			boolean token = nonterm.equals(Token.TOKEN);
			boolean ignored = token == false && nonterm.equals(Token.IGNORED);
			
			if (token || ignored)	{	// special token definition rule
				if (rule.rightSize() != 1)	// token/ignored must not contain more than one item on right side (alternatives being resoved)
					throw new SyntaxException("\"token\" and \"ignored\" are predefined lexer keywords and must contain exactly one nonterminal symbol after resolve: "+rule);

				deleteIndexes.add(i);

				String sym = rule.getRightSymbol(0);	// the token identifier
				if (sym.charAt(0) == Token.COMMAND_QUOTE)	{
					sym = sym.substring(1, sym.length() - 1);	// take off quotes
					if (token)
						commandsDefinedAsTOKEN.add(sym);
				}

				if (token)
					tokenSymbols.put(sym, sym);
				else
					ignoredSymbols.put(sym, sym);
			}
		}
		deleteIndexes.removeIndexesFrom(syntax);

		// check if tokens are defined as ignored or vice versa
		for (Iterator it = tokenSymbols.keySet().iterator(); it.hasNext(); )	{
			Object o = it.next();
			if (ignoredSymbols.get(o) != null)
				throw new SyntaxException("Can not define token as ignored: "+o);
		}
		for (Iterator it = ignoredSymbols.keySet().iterator(); it.hasNext(); )	{
			Object o = it.next();
			if (tokenSymbols.get(o) != null)
				throw new SyntaxException("Can not define ignored as token: "+o);
		}
		
		boolean tokensWereDeclared = tokenSymbols.size() > 0;
		List commandTokens = new ArrayList();
		
		// collect all `lexertokens`.
		for (int i = 0; i < syntax.size(); i++)	{
			Rule rule = syntax.getRule(i);

			for (int j = 0; j < rule.rightSize(); j++)	{	// loop right side of rule
				String sym = rule.getRightSymbol(j);
				
				if (sym.charAt(0) == Token.COMMAND_QUOTE)	{
					sym = sym.substring(1, sym.length() - 1);	// remove command quotes
					tokenSymbols.put(sym, sym);
					commandTokens.add(sym);
					rule.setRightSymbol(sym, j);	// remove the quotes for being able to recognize the symbol later
				}
				else
				// get out all rules containing ".." and "-" when no "token" was defined explicitely, as these must be scanner rules
				if (tokensWereDeclared == false && (sym.equals(Token.BUTNOT) || sym.equals(Token.UPTO)))	{
					String s = rule.getNonterminal();	// take this rule to lexer rules
					tokenSymbols.put(s, s);
				}
			}
		}

		// Get out all scanner rules from parser syntax, recursively
		this.lexerSyntax = new Syntax(tokenSymbols.size() + ignoredSymbols.size());
		Hashtable [] varr = new Hashtable [] { tokenSymbols, ignoredSymbols };
		
		for (int j = 0; j < varr.length; j++)	{	// loop token and ignored lists
			Hashtable symbols = varr[j];
			
			for (Enumeration e = symbols.keys(); e.hasMoreElements(); )	{
				String nonterm = (String)e.nextElement();
				
				getRulesUnderSymbol(nonterm, syntax, lexerSyntax, deleteIndexes);
				
				if (deleteIndexes.isEmpty() && lexerSyntax.hasRule(nonterm) == false)	{	// if there were no rules for symbol
					String [][] predefinedRules = StandardLexerRules.rulesForIdentifier(nonterm);	// look for predefined rule
					if (predefinedRules == null || predefinedRules.length <= 0)
						throw new SyntaxException("Found nonterminal that has no rule and is no predefined lexer nonterminal: >"+nonterm+"<");
					
					lexerSyntax.appendRules(SyntaxUtil.ruleArrayToList(predefinedRules));
				}
				
				deleteIndexes.removeIndexesFrom(syntax);
			}
		}
		
		// add ignoredSymbols to member variable lists
		this.ignoredSymbols = new ArrayList(ignoredSymbols.size());
		for (Enumeration e = ignoredSymbols.keys(); e.hasMoreElements(); )
			this.ignoredSymbols.add(e.nextElement());

		this.parserSyntax = provideParserSyntax(syntax, lexerSyntax, tokensWereDeclared, tokenSymbols, commandTokens, commandsDefinedAsTOKEN);

		//System.err.println("Parser syntax:\n"+syntax);
		//System.err.println("Lexer syntax:\n"+lexerSyntax);
		//System.err.println("token symbols: "+tokenSymbols);
		//System.err.println("ignored symbols: "+ignoredSymbols);
	}


	private Syntax provideParserSyntax(Syntax parserSyntax, Syntax lexerSyntax, boolean tokensWereDeclared, Map tokenSymbols, List commandTokens, List commandsDefinedAsTOKEN)
		throws SyntaxException
	{
		boolean lexerOnlyHandling = false;
		
		// when this was a mixed grammar: mark all tokens and ignored symbols as lexer `terminals` in parserSyntax
		if (parserSyntax.size() > 0)	{
			if (DEBUG) System.err.println("INFO: Mixed parser and lexer specification, "+lexerSyntax.size()+" lexer rules, "+parserSyntax.size()+" parser rules.");
			this.tokenSymbols = new ArrayList(tokenSymbols.size());	// keep only toplevel token symbols

			for (int i = 0; i < parserSyntax.size(); i++)	{
				Rule rule = parserSyntax.getRule(i);
				
				for (int j = 0; j < rule.rightSize(); j++)	{
					String sym = rule.getRightSymbol(j);
					
					if (tokenSymbols.get(sym) != null)	{	// this is a lexer token, mask it with `backquotes`
						String parserSymbol = Token.COMMAND_QUOTE + sym + Token.COMMAND_QUOTE;
						if (sym.charAt(0) != Token.COMMAND_QUOTE)	// mark symbol with backquotes as lexer token
							rule.setRightSymbol(parserSymbol, j);
							
						if (this.tokenSymbols.indexOf(parserSymbol) < 0)
							this.tokenSymbols.add(parserSymbol);
							// add top level token as `symbol` (with backquotes), as Parser will pass terminals like that,
							// and the Lexer should also be usable without Parser.
					}
					else
					if (sym.equals(Token.UPTO) || sym.equals(Token.BUTNOT))	{
						throw new SyntaxException("Found lexer rule in parser syntax: "+rule+". Please define \"token\" and \"ignored\" better!"); 
					}
					else
					if (Token.isTerminal(sym) == false)	{	// check if there is a nonterminal without rule on right side and try to find it among lexer rules
						boolean found = parserSyntax.hasRule(sym);
						if (found == false)	{	// try to find it in lexer rules and make it a token when found, else throw error
							if (lexerSyntax.hasRule(sym))	{
								String parserSymbol = Token.COMMAND_QUOTE + sym + Token.COMMAND_QUOTE;
								rule.setRightSymbol(parserSymbol, j);
								if (this.tokenSymbols.indexOf(parserSymbol) < 0)
									this.tokenSymbols.add(parserSymbol);
							}
							else	{
								throw new SyntaxException("Parser nonterminal without rule: "+sym);
							}
						}
					}
				}
			}
		}
		else	// no declared tokens and no parser syntax remained
		if (tokensWereDeclared == false)	{	// find top level lexer rules and put them into token list marked with `backquotes`
			if (DEBUG) System.err.println("INFO: No tokens were defined, lexer specification without parser rules, "+lexerSyntax.size()+" lexer rules.");
			List startRules = lexerSyntax.findStartRules();
			
			if (startRules.size() > 0)	{
				this.tokenSymbols = new ArrayList(startRules.size());	// allocate new list only if there were start rules
				
				for (int i = 0; i < startRules.size(); i++)	{
					String symbol = Token.COMMAND_QUOTE + ((Rule) startRules.get(i)).getNonterminal() + Token.COMMAND_QUOTE;
					if (this.tokenSymbols.indexOf(symbol) < 0)	// add unique
						this.tokenSymbols.add(symbol);
				}
			}
			else	{
				lexerOnlyHandling = true;
			}
		}
		else	{
			if (DEBUG) System.err.println("INFO: tokens were defined, lexer specification without parser rules, "+lexerSyntax.size()+" lexer rules.");
			lexerOnlyHandling = true;
		}
		
		if (lexerOnlyHandling)	{	// no parser syntax remained, and tokens were defined or no start rules were found
			for (int i = 0; i < commandTokens.size(); i++)	{	// no parser syntax, remove collected `lexercommands` when they were not defined in TOKEN definition
				String sym = (String) commandTokens.get(i);
				if (commandsDefinedAsTOKEN.indexOf(sym) < 0)
					tokenSymbols.remove(sym);
			}

			// add tokenSymbols to member variable lists
			this.tokenSymbols = new ArrayList(tokenSymbols.size());
			for (Iterator it = tokenSymbols.keySet().iterator(); it.hasNext(); )
				this.tokenSymbols.add(Token.COMMAND_QUOTE + it.next().toString() + Token.COMMAND_QUOTE);
				// must enclose all explicit token symbols in `backquotes`
		}
		
		return parserSyntax;
	}


	/*
		Appends all rules in passed syntax deriving passed symbol and all their
		sub-rules, recursively, to passed result-syntax. Fills the deleteIndex
		with every appended rule index, but does not delete the rule from source syntax.
		@param symbol nonterminal to search
		@param syntax source syntax that will be searched
		@param resultSyntax target syntax to append the found rules to
		@param deleteIndexes receives indexes of all appended rules for later deletion
	*/
	private void getRulesUnderSymbol(String symbol, Syntax syntax, Syntax resultSyntax, IntArray deleteIndexes)	{
		for (int i = 0; i < syntax.size(); i++)	{
			Rule rule = syntax.getRule(i);
			String nonterm = rule.getNonterminal();
			
			// check if rule derives symbol and was not already appended (recursive rules!)
			if (deleteIndexes.contains(i) == false && nonterm.equals(symbol))	{
				resultSyntax.addRule(rule);
				deleteIndexes.add(i);
				
				// check for further nonterminals on right side
				for (int j = 0; j < rule.rightSize(); j++)	{
					String sym = rule.getRightSymbol(j);
					if (Token.isTerminal(sym) == false && sym.equals(Token.BUTNOT) == false && sym.equals(Token.UPTO) == false)
						getRulesUnderSymbol(sym, syntax, resultSyntax, deleteIndexes);
				}
			}
		}
	}



	// Array implementation used to store indexes for fast and safe deletion of rules from syntaxes
	public static class IntArray
	{
		private int [] array;
		private int pos;
		
		public IntArray(int size)	{
			array = new int [size];
		}
		
		public void add(int i)	{
			if (pos >= array.length)	{
				int [] newArray = new int [array.length * 2];
				System.arraycopy(array, 0, newArray, 0, array.length);
				array = newArray;
			}
			array[pos] = i;
			pos++;
		}
		
		public boolean isEmpty()	{
			return pos == 0;
		}
		
		public boolean contains(int j)	{
			for (int i = 0; i < pos; i++)
				if (array[i] == j)
					return true;
			return false;
		}
		
		public void removeIndexesFrom(Syntax syntax)	{
			Arrays.sort(array, 0, pos);	// to delete from list indexes must be sorted
			for (int i = pos - 1; i >= 0; i--)
				syntax.removeRule(array[i]);	// remove rule
			pos = 0;	// reset position
		}
		
	}	// end class IntArray

}
