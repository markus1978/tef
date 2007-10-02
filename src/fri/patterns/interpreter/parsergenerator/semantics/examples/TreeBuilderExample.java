package fri.patterns.interpreter.parsergenerator.semantics.examples;

import java.io.*;
import fri.patterns.interpreter.parsergenerator.*;
import fri.patterns.interpreter.parsergenerator.lexer.*;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;
import fri.patterns.interpreter.parsergenerator.syntax.builder.*;
import fri.patterns.interpreter.parsergenerator.semantics.TreeBuilderSemantic;

/**
	TreeBuilderSemantic example that shows the instance tree of
	the EBNF file <i>syntax/builder/examples/SyntaxBuilder.syntax</i<.
*/

public class TreeBuilderExample
{
	/** Test output of SyntaxBuilder syntax tree. */
	public static void main(String [] args)	{
		try	{
			Reader input = new InputStreamReader(Parser.class.getResourceAsStream("syntax/builder/examples/SyntaxBuilder.syntax"));
			Syntax syntax = new Syntax(StandardLexerRules.lexerSyntax);
			SyntaxSeparation separation = new SyntaxSeparation(syntax);
			LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());
			Lexer lexer = builder.getLexer(input);
			Parser p = new Parser(new SyntaxBuilderParserTables());
			if (p.parse(lexer, new TreeBuilderSemantic()))	{
				TreeBuilderSemantic.Node n = (TreeBuilderSemantic.Node)p.getResult();
				System.err.println("got result: "+n);
				System.out.println(n.toString(0));
			}
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}
		
}
