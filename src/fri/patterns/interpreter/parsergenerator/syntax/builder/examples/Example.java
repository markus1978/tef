package fri.patterns.interpreter.parsergenerator.syntax.builder.examples;

import java.io.*;
import fri.patterns.interpreter.parsergenerator.*;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;
import fri.patterns.interpreter.parsergenerator.syntax.builder.SyntaxBuilder;
import fri.patterns.interpreter.parsergenerator.parsertables.LALRParserTables;

/**
	This example reads the SyntaxBuilder EBNF specification, builds
	a lexer and parser from it, and parses its own specification with
	these rules.
	
	@author (c) 2002, Fritz Ritzberger
*/

public class Example
{
	public static void main(String [] args)	{
		try	{
			System.out.println("Input is: "+(args.length > 0 ? args[0] : "SyntaxBuilder.syntax"));
			InputStreamReader in = args.length <= 0
					? new InputStreamReader(Example.class.getResourceAsStream("SyntaxBuilder.syntax"))
					: new InputStreamReader(new FileInputStream(args[0]));
			SyntaxBuilder builder = new SyntaxBuilder(in);
			Syntax syntax = builder.getSyntax();
			System.out.println("Resolved syntax rules are: ==============");
			System.out.println(syntax.toString());

			// now lets see if we can parse the syntax specification text with its own syntax
			in = args.length <= 0
					? new InputStreamReader(Example.class.getResourceAsStream("SyntaxBuilder.syntax"))
					: new InputStreamReader(new FileInputStream(args[0]));
			Lexer lexer = builder.getLexer();
			lexer.setInput(in);
			lexer.setDebug(true);
			Syntax parserSyntax = builder.getParserSyntax();
			ParserTables parserTables = new LALRParserTables(parserSyntax);
			Parser parser = new Parser(parserTables);
			boolean ok = parser.parse(lexer);
			if (ok == false)
				throw new Exception("Failed parsing syntax specification text!");
			else
				System.out.println("SyntaxBuilder succeeded parsing its own syntax specification text!");
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}
	
}
