package hub.sam.tef.rcc.examples;

import hub.sam.tef.rcc.Parser;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.builder.SerializedParser;
import hub.sam.tef.rcc.parsertables.SLRParserTables;
import hub.sam.tef.rcc.semantics.PrintSemantic;

/**
	"Hello World" example 2. Checks if "Hello" is followed by "World", arbitrary whitespaces.
	Shows how to use the serialization parser builder (quick loading for big syntaxes).
	
	@author Fritz Ritzberger
*/

public class HelloWorldParser2
{
	private static final String [][] syntax =	{
		{ "Start", "\"Hello\"", "\"World\"" },
		{ Token.IGNORED, "`whitespaces`" },
	};
	
	public static void main(String [] args)
		throws Exception
	{
		Parser parser = new SerializedParser().get(SLRParserTables.class, syntax, "HelloWorld2");	// generates "$HOME/.friware/parsers/HelloWorld2Parser.ser"
		parser.setInput("\tHello \r\n\tWorld\n");	// give the lexer some very complex input :-)
		parser.parse(new PrintSemantic());	// start parsing with a print-semantic
	}

}
