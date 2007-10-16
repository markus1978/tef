package hub.sam.tef.rcc.examples;

import hub.sam.tef.rcc.Lexer;
import hub.sam.tef.rcc.Parser;
import hub.sam.tef.rcc.ParserTables;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.lexer.LexerBuilder;
import hub.sam.tef.rcc.parsertables.LALRParserTables;
import hub.sam.tef.rcc.semantics.PrintSemantic;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.rcc.syntax.builder.SyntaxSeparation;

/**
	"Hello World" example. Checks if "Hello" is followed by "World", arbitrary whitespaces.
	This example shows how to build parser and lexer from scratch.
	
	@author Fritz Ritzberger
*/

public class HelloWorldParser
{
	private static final String [][] syntax =	{
		{ "Start", "\"Hello\"", "\"World\"" },
		{ Token.IGNORED, "`whitespaces`" },
	};
	
	public static void main(String [] args)
		throws Exception
	{
		SyntaxSeparation separation = new SyntaxSeparation(new Syntax(syntax));	// separate lexer and parser syntax
		LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());	// build a Lexer
		Lexer lexer = builder.getLexer();
		lexer.setInput("\tHello \r\n\tWorld\n");	// give the lexer some very complex input :-)
		ParserTables parserTables = new LALRParserTables(separation.getParserSyntax());
		Parser parser = new Parser(parserTables);
		parser.parse(lexer, new PrintSemantic());	// start parsing with a print-semantic
	}

}
