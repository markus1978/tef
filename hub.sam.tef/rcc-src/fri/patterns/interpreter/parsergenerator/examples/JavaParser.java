package fri.patterns.interpreter.parsergenerator.examples;

import java.io.*;
import fri.util.TimeStopper;
import fri.patterns.interpreter.parsergenerator.*;
import fri.patterns.interpreter.parsergenerator.builder.*;
import fri.patterns.interpreter.parsergenerator.semantics.PrintSemantic;
//import fri.patterns.interpreter.parsergenerator.syntax.builder.*;
//import fri.patterns.interpreter.parsergenerator.parsertables.*;

/**
	Example Java parser.
	
	@author Fritz Ritzberger, 2000
*/

public class JavaParser
{
	public static void main(String [] args)
		throws Exception
	{
		if (args.length <= 0)	{
			System.err.println("SYNTAX: java "+JavaParser.class.getName()+" file.java [file.java ...]");
			System.err.println("	Example Java Parser");
		}
		else	{
			TimeStopper timer = new TimeStopper();

			// read the syntax from EBNF file
			Reader syntaxInput = new InputStreamReader(JavaParser.class.getResourceAsStream("Java.syntax"));
			
			/* building from scratch, takes 4200 millis
			SyntaxBuilder builder = new SyntaxBuilder(syntaxInput);
			Lexer lexer = builder.getLexer();
			lexer.setDebug(true);
			ParserTables tables = new LALRParserTables(builder.getParserSyntax());
			Parser parser = new Parser(tables);
			parser.setLexer(lexer);
			*/
			
			/* building with precompiled tables, takes 1600 millis
			SyntaxBuilder builder = new SyntaxBuilder(syntaxInput);
			Lexer lexer = builder.getLexer();
			ParserTables tables = new CompiledTables().get(builder.getParserSyntax(), "Java");
			Parser parser = new Parser(tables);
			parser.setLexer(lexer);
			*/
			
			/* building serialized parser, takes 740 millis */
			Parser parser = new SerializedParser().get(null, syntaxInput, "Java");
			System.err.println("time to build Java file parser was "+timer.getInterval());

			//parser.getParserTables().dumpSyntaxNodes(System.out);
			//parser.getParserTables().dump(System.err);
			
			// we want to receive Java comments and spaces/newlines
			parser.getLexer().addTokenListener(new Lexer.TokenListener()	{
				public void tokenReceived(Token token, boolean ignored) {
					if (ignored)	{
						System.err.println("------------- Ignored Token Received -------------------");
						System.err.println(token.text);
						System.err.println("--------------------------------------------------------");
					}
				}
			});

			for (int i = 0; i < args.length; i++)	{
				String fileToParse = args[i];
				FileReader parseInput = new FileReader(fileToParse);
				System.err.println("========================================================");
				System.err.println("Parsing: "+fileToParse);

				parser.setInput(parseInput);	// set file input to lexer
				boolean ok = parser.parse(new PrintSemantic());	// parse input

				System.err.println("========================================================");
				System.err.println("Parsing result from "+fileToParse+" is: "+ok+", parsing took "+timer.getInterval()+" millis");
			}
		}
	}
	
}
