package fri.patterns.interpreter.parsergenerator.examples;

import java.io.*;
import fri.util.TimeStopper;
import fri.patterns.interpreter.parsergenerator.builder.SerializedLexer;
import fri.patterns.interpreter.parsergenerator.lexer.*;
import fri.patterns.interpreter.parsergenerator.syntax.*;
import fri.patterns.interpreter.parsergenerator.syntax.builder.*;

/**
	Example DTD parser. Shows how to import unresolved nonterminals from another syntax (XML).
	
	@author Fritz Ritzberger, 2003
*/

public class DtdLexer
{
	public static void main(String [] args)
		throws Exception
	{
		if (args.length <= 0)	{
			System.err.println("SYNTAX: java "+DtdLexer.class.getName()+" file.dtd [file.dtd ...]");
			System.err.println("	Example DTD Parser");
			System.exit(1);
		}

		TimeStopper timer = new TimeStopper();

		SerializedLexer builder = new SerializedLexer();
		LexerImpl lexer;
		
		if ((lexer = (LexerImpl) builder.readLexer(null, "Dtd")) == null)	{	// try to get serialized lexer
			// read the DTD syntax (fragment) from EBNF file
			Syntax dtdSyntax = new SyntaxBuilder(new InputStreamReader(DtdLexer.class.getResourceAsStream("Dtd.syntax"))).getSyntax();
			// read the XML syntax from EBNF file
			Syntax xmlSyntax = new SyntaxBuilder(new InputStreamReader(DtdLexer.class.getResourceAsStream("Xml.syntax"))).getSyntax();
			
			// resolve DTD syntax from XML syntax (which contains most of DTD rules for processing embedded DTDs)
			dtdSyntax.resolveFrom(xmlSyntax);
			//System.err.println("DTD Syntax is:\n"+dtdSyntax);
			
			// put the lexer to file cache for next call
			SyntaxSeparation separation = new SyntaxSeparation(dtdSyntax);
			lexer = (LexerImpl) builder.buildAndStoreLexer(	// store the lexer for next call
					separation.getLexerSyntax(),
					"Dtd",
					separation.getTokenSymbols(),
					separation.getIgnoredSymbols());
		}

		System.err.println("time to build DTD file parser was "+timer.getInterval());

		for (int i = 0; i < args.length; i++)	{
			String parseFile = args[i];
			FileReader parseInput = new FileReader(parseFile);
			lexer.setInput(parseInput);
			
			System.err.println("======================== Parsing: "+parseFile+" ========================");
			boolean ok = lexer.lex(new XmlLexer.PrintXmlLexerSemantic());
			System.err.println("========================================================");
			
			System.err.println("Lexing took "+timer.getInterval()+" millis.");
			System.err.println("Result was: "+ok);
		}
	}

}
