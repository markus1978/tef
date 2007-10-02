package fri.patterns.interpreter.parsergenerator.examples;

import java.util.*;
import java.io.*;
import fri.util.TimeStopper;
import fri.util.io.UnicodeReader;
import fri.patterns.interpreter.parsergenerator.builder.SerializedLexer;
import fri.patterns.interpreter.parsergenerator.lexer.LexerImpl;
import fri.patterns.interpreter.parsergenerator.lexer.LexerSemantic;
import fri.patterns.interpreter.parsergenerator.lexer.ResultTree;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
	Example XML lexer. Not event-driven like SAX, but good for DOM-building.
	
	@author Fritz Ritzberger, 2003
*/

public class XmlLexer
{
	public static void main(String [] args)
		throws Exception
	{
		if (args.length <= 0)	{
			System.err.println("SYNTAX: java "+XmlLexer.class.getName()+" file.xml [file.xml ...]");
			System.err.println("	Example XML Parser");
			System.exit(1);
		}

		// Standalone lexer as top-down parser.
		TimeStopper timer = new TimeStopper();
		// Building lexer from scratch takes 840 millis. Parsing takes 60 millis for a 70 line XML file.

		// read the syntax from EBNF file
		Reader syntaxInput = new InputStreamReader(XmlLexer.class.getResourceAsStream("Xml.syntax"));
		boolean PRODUCTION = false;	// always build from scratch at development time
		LexerImpl lexer = (LexerImpl) new SerializedLexer(PRODUCTION).get(syntaxInput, "Xml");

		System.err.println("time to build XML file parser was "+timer.getInterval());

		for (int i = 0; i < args.length; i++)	{
			String parseFile = args[i];
			Reader parseInput = new UnicodeReader(new FileInputStream(parseFile));
			lexer.setInput(parseInput);
			
			System.err.println("======================== Parsing: "+parseFile+" ========================");
			boolean result = lexer.lex(new PrintXmlLexerSemantic());
			System.err.println("========================================================");
			
			System.err.println("Lexing took "+timer.getInterval()+" millis.");
			System.err.println("Result was: "+result);
		}
	}

	

	static class PrintXmlLexerSemantic implements LexerSemantic
	{
		/**
		 * Receives evaluated lexer ruels and their result.
		 */
		public void ruleEvaluated(Rule rule, ResultTree resultTree)	{
			System.out.println("Nonterminal="+rule.getNonterminal()+", range("+resultTree.getRange()+"), Input=\""+resultTree.toString()+"\"");
		}
	
		/**
		 * Returns a Set of nonterminal Strings whose rule evaluations the Lexer should
		 * report to this semantic. Could return null to receive all rules.
		 * For XML only a subset of all tokens in the EBNF is needed. There is no other
		 * way than to hardcode those nonterminal names here. When using the SourceGenerator
		 * on the XML EBNF, the Strings could be imported from generated source to be consistent.
		 */
		public Set getWantedNonterminals()	{
			Set considered = new HashSet();
			considered.add("Name");
			considered.add("Nmtoken");
			considered.add("EntityValue");
			considered.add("AttValue");
			considered.add("SystemLiteral");
			considered.add("PubidLiteral");
			considered.add("CharData");
			considered.add("Comment");
			considered.add("VersionNum");
			considered.add("PITargetContent");
			considered.add("PITarget");
			considered.add("CData");
			considered.add("doctypedecl");
			considered.add("SDDecl");
			considered.add("STag");
			considered.add("Attribute");
			considered.add("ETag");
			considered.add("EmptyElemTag");
			considered.add("elementdecl");
			considered.add("contentspec");
			considered.add("cp");
			considered.add("ChoiceList");
			considered.add("SeqListOpt");
			considered.add("Mixed");
			considered.add("AttDef");
			considered.add("StringType");
			considered.add("TokenizedType");
			considered.add("NotationType");
			considered.add("Enumeration");
			considered.add("DefaultDecl");
			considered.add("CharRef");
			considered.add("EntityRef");
			considered.add("PEReference");
			considered.add("GEDecl");
			considered.add("PEDecl");
			considered.add("EntityDef");
			considered.add("PEDef");
			considered.add("ExternalID");
			considered.add("NDataDecl");
			considered.add("EncName");
			considered.add("NotationDecl");
			return considered;
		}
		
		public Set getIgnoredNonterminals()	{
			return null;
		}

	}

}
