package fri.patterns.interpreter.parsergenerator.syntax.builder;

import java.util.*;
import java.io.IOException;
import fri.patterns.interpreter.parsergenerator.*;
import fri.patterns.interpreter.parsergenerator.lexer.*;
import fri.patterns.interpreter.parsergenerator.syntax.*;
import fri.patterns.interpreter.parsergenerator.parsertables.LALRParserTables;
import fri.patterns.interpreter.parsergenerator.parsertables.ParserBuildException;

/**
	Connects SyntaxSeparation and LexerBuilder.
	SyntaxBuilder builds a <i>Syntax</i> object from a text input which can be
	File, InputStream, Reader, String, StringBuffer. Mind that you DO NOT need
	a SyntaxBuilder to create a Syntax from a String [][] or a List of rule Lists!
	<p>
	Following symbols can be used within the syntax specification text (spaces are ignored):
	<pre>
		a ::= b? ;	// a derives to one or none b
		a ::= b* ;	// a derives to any number of b including zero
		a ::= b+ ;	// a derives to any number of b excluding zero
		a ::= (b c)* d ;	// grouping of b and c by parenthesis
		a ::= b | c |  ;	// a derives to b or c or nothing
		start ::= "BEGIN" ;	// a fixed terminal string
		letter ::= 'a' .. 'z' ;	// character set a-z
		newline ::= '\r' | '\n' | '\r' '\n' ;	// newlines of all wellknown platforms
		positive ::= digit - '0' ;	// digit but not zero
		id ::= `identifier` ;	// using the pre-built lexer rules for <i>identifier</i> (lexer ruleref)
		source ::= char - comment ;	// source is all characters, but without comments
	</pre>
	This EBNF-like language is case-sensitive and differs from EBNF only at these symbols:
	. { } &lt; &gt; [ ]. Archetype was the notation used by the w3c.
	
	@author (c) 2002, Fritz Ritzberger
*/

public class SyntaxBuilder
{
	private Syntax syntax;
	private Syntax lexerSyntax, parserSyntax;
	private Lexer lexer;
	private List tokenSymbols, ignoredSymbols;
	private List initialNonterminals;
	
	/**
		Parse a syntax specification text and process it to a <i>Syntax</i> object.
		The syntax, a Lexer, a parserSyntax and a token-symbol list will be retrieveable after construction.
		@param syntaxInput text to parse and build a syntax from, File, InputStream, Reader, String, StringBuffer.
			If InputStream is used, no Reader will be wrapped around (raw byte input).
	*/
	public SyntaxBuilder(Object syntaxInput)
		throws SyntaxException, LexerException, ParserBuildException, IOException
	{
		// build the hardcoded default BNF lexer
		
		SyntaxSeparation.DEBUG = false;	// avoid output of syntax control messages
		SyntaxSeparation separation = new SyntaxSeparation(new Syntax(StandardLexerRules.lexerSyntax));
		SyntaxSeparation.DEBUG = true;
		
		LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());
		Lexer lexer = builder.getLexer();
		lexer.setInput(syntaxInput);
		
		// build the (hardcoded) BNF parser
		
		//ParserTables parserTables = new LALRParserTables(new Syntax(SyntaxUtil.ruleArrayToList(SyntaxBuilderSemantic.syntax)));
		// COMMENT OUT FOLLOWING LINE AND COMMENT IN PREVIOUS LINE TO BUILD NEW SyntaxBuilderParserTables AFTER HAVING CHANGED SYNTAX!
		ParserTables parserTables = new SyntaxBuilderParserTables();
		
		// start the BNF parser with syntax input
		Parser parser = new Parser(parserTables);
		initialNonterminals = new ArrayList(64);
		boolean ok = parser.parse(lexer, new SyntaxBuilderSemantic(initialNonterminals));
		if (ok == false)
			throw new SyntaxException("Failed building Syntax from "+syntaxInput);
		
		List result = (List) parser.getResult();	// must be a List, according to applied semantic
		List rules = new ArrayList();	// can not predict size
		ArtificialRule.resolveArtificialRules(result, rules);
		this.syntax = new Syntax(rules);
		//System.err.println("Built result syntax:\n"+this.syntax);
	}	

	private void ensureSeparation()
		throws SyntaxException
	{
		if (tokenSymbols == null)	{
			SyntaxSeparation separation = new SyntaxSeparation(syntax);
			this.tokenSymbols = separation.getTokenSymbols();
			this.ignoredSymbols = separation.getIgnoredSymbols();
			this.parserSyntax = separation.getParserSyntax();
			this.lexerSyntax = separation.getLexerSyntax();
		}
	}


	/** Returns a Lexer for the built syntax. */
	public Lexer getLexer()
		throws LexerException, SyntaxException
	{
		if (lexer == null)	{
			ensureSeparation();
			LexerBuilder builder = new LexerBuilder(lexerSyntax, ignoredSymbols);
			this.lexer = builder.getLexer();
		}
		return this.lexer;
	}

	/** Returns only the ready-made parser syntax (to feed the parser tables). */
	public Syntax getParserSyntax()
		throws SyntaxException
	{
		ensureSeparation();
		return this.parserSyntax;
	}

//	/** Returns the list of lexer token symbols for <i>setTerminals()</i> call if the Lexer is used standalone (without Parser). */
//	public List getTokenSymbols()
//		throws SyntaxException
//	{
//		ensureSeparation();
//		return this.tokenSymbols;
//	}

	/** Returns the whole syntax (both parser and lexer syntax). */
	public Syntax getSyntax()	{
		return syntax;
	}

	/**
	 * Returns the list of initial nonterminals (before parenthesis and quantifiers get resolved).
	 * This is for internal use in SourceGenerator.
	 */
	public List getInitialNonterminals()	{
		return initialNonterminals;
	}

	/**
		Resolves all singular rules (only one symbol on right side, only one occurence).
		This must be called directly after construction to have an effect.
	*/
	public Syntax resolveSingulars()	{
		getSyntax().resolveSingulars();
		return getSyntax();
	}



	/** Creates SyntaxBuilderParserTables.java (in this directory) from the rules defined in SyntaxBuilderSemantic. */
	public static void main(String [] args)	{
		try	{
			new LALRParserTables(new Syntax(SyntaxBuilderSemantic.syntax)).toSourceFile(
					"fri.patterns.interpreter.parsergenerator.syntax.builder.SyntaxBuilderParserTables");
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}
	
}
