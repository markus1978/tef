package fri.patterns.interpreter.parsergenerator.examples;

import java.util.List;
import java.util.Map;
import fri.patterns.interpreter.parsergenerator.Lexer;
import fri.patterns.interpreter.parsergenerator.Parser;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.builder.SerializedLexer;
import fri.patterns.interpreter.parsergenerator.builder.SerializedParser;
import fri.patterns.interpreter.parsergenerator.lexer.LexerBuilder;
import fri.patterns.interpreter.parsergenerator.lexer.LexerException;
import fri.patterns.interpreter.parsergenerator.lexer.LexerImpl;
import fri.patterns.interpreter.parsergenerator.lexer.Strategy;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;
import fri.patterns.interpreter.parsergenerator.syntax.SyntaxException;

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
