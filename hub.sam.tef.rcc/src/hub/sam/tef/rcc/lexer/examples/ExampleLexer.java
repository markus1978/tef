package hub.sam.tef.rcc.lexer.examples;

import hub.sam.tef.rcc.Lexer;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.lexer.LexerBuilder;
import hub.sam.tef.rcc.lexer.LexerException;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.rcc.syntax.builder.SyntaxSeparation;

import java.io.InputStream;

/**
	Sample showing how to build a Lexer from StandardLexerRules building blocks.
	This Lexer scans C/Java stringdefs, chardefs, integer, float, identifiers, comments,
	and everything else as "verbatim".
	
	@author (c) 2002, Fritz Ritzberger
*/

public abstract class ExampleLexer
{
	/** Test main. */
	public static void main(String [] args)	{
		String [][] rules = {
			{ "token", "stringdef" },
			{ "token", "chardef" },
			{ "token", "identifier" },
			{ "token", "float" },
			{ "token", "integer" },
			{ "token", "verbatim" },
			{ "verbatim", "char",
						Token.BUTNOT, "space",
						Token.BUTNOT, "newline",
						Token.BUTNOT, "letter",
						Token.BUTNOT, "digit",
						Token.BUTNOT, "stringdef",
						Token.BUTNOT, "chardef",
						Token.BUTNOT, "comment" },
			{ "ignored", "comment" },
			{ "ignored", "spaces" },
			{ "ignored", "newlines" },
		};
		Syntax syntax = new Syntax(rules);

		try	{
			hub.sam.tef.rcc.generalutil.TimeStopper ts = new hub.sam.tef.rcc.generalutil.TimeStopper();

			SyntaxSeparation separation = new SyntaxSeparation(syntax);
			LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());
			Lexer lexer = builder.getLexer();
			lexer.setDebug(true);
			lexer.setTerminals(separation.getTokenSymbols());

			System.err.println("time to build lexer was: "+ts.getInterval());

			InputStream in = ExampleLexer.class.getResourceAsStream("ExampleLexer.java");	//Reader in = new FileReader(args[0]);
			lexer.setInput(in);

			System.err.println("time to build input was: "+ts.getInterval());
			
			Token t;
			do	{
				t = lexer.getNextToken(null);
				//System.err.println(ts.getInterval()+" was time to read token "+t.symbol+" -> "+t.text);
				
				if (t.symbol == null)	{
					lexer.dump(System.err);
					throw new LexerException("Uninterpretable input!");
				}
				System.out.println(t.symbol+" "+">"+t.text+"<");
			}
			while (Token.isEpsilon(t) == false);

			System.err.println("time to scan input was: "+ts.getTimeMillis());
		}
		catch (Exception e)	{
			e.printStackTrace();
		}


		// some complicated Java expressions, for test lexing this source file
		char testChar1 = 'c';
		char testChar2 = '\r';
		char testChar3 = '\000';
		char testChar4 = '\377';
		String testString1 = "\\\"\\/* comment in string */";
		String testString2 = "///*|<>@,;.:-_#'+*~´`ßäöü\"ÄÖÜ^°§%&/[][]{}";
		float testFloat = 123.456E-12f;
		double testDouble = .456d;
		int testInt1 = 0X12aB;
		int testInt2 = 07654;
		System.err.println("Zahl 07654 ist: "+testInt2);
		long testLong1 = 123456L;
	}

}
