package hub.sam.tef.rcc.examples;

import hub.sam.tef.rcc.Lexer;
import hub.sam.tef.rcc.Parser;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.builder.SerializedLexer;
import hub.sam.tef.rcc.builder.SerializedParser;
import hub.sam.tef.rcc.lexer.LexerBuilder;
import hub.sam.tef.rcc.lexer.LexerException;
import hub.sam.tef.rcc.lexer.LexerImpl;
import hub.sam.tef.rcc.lexer.Strategy;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.rcc.syntax.SyntaxException;

import java.util.List;
import java.util.Map;

/**
 * This sample shows how to set another Lexer implementation
 * into the Parser-builder.
 * 
 * @author Fritz Ritzberger
 */
public class HowToOverrideLexerImpl {
	public static void main(String args[])
		throws Exception
	{
		// a Lexer derivate class that prints a message
		class OverrideLexer extends LexerImpl
		{
			public OverrideLexer(List ignoredSymbols, Map charConsumers)	{
				super(ignoredSymbols, charConsumers);
			}
			/** Could provide another lexing Strategy. */
			public Strategy newStrategy()	{
				return super.newStrategy();
			}
		};

		// override the Parser builder to install the new Lexer implementation
		SerializedParser builder = new SerializedParser()	{
			protected SerializedLexer newSerializedLexer()	// override SerializedLexer factory method
				throws Exception
			{
				return new SerializedLexer()	{
					protected LexerBuilder newLexerBuilder(Syntax syntax, List ignoredSymbols)	// override LexerBuilder factory method
						throws LexerException, SyntaxException
					{
						return new LexerBuilder(syntax, ignoredSymbols)	{
							public Lexer getLexer()	{	// override Lexer factory method
								return new OverrideLexer(ignoredSymbols, charConsumers);
							}
						};
					}
				};
			}
		};
		
		String [][] syntaxInput = {
			{ "Start", "\"Hello\"", "\"World\"" },
			{ Token.IGNORED, "`whitespaces`" },
		};
		
		Parser parser = builder.get(syntaxInput);
		boolean ok = parser.parse("Hello World");
		System.err.println("Parsing was "+ok);
	}

}
