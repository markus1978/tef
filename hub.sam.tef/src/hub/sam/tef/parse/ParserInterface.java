package hub.sam.tef.parse;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.views.DocumentText;
import hub.sam.util.trees.AbstractTree;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import fri.patterns.interpreter.parsergenerator.Lexer;
import fri.patterns.interpreter.parsergenerator.Parser;
import fri.patterns.interpreter.parsergenerator.ParserTables;
import fri.patterns.interpreter.parsergenerator.Semantic;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.lexer.LexerBuilder;
import fri.patterns.interpreter.parsergenerator.lexer.LexerException;
import fri.patterns.interpreter.parsergenerator.parsertables.LALRParserTables;
import fri.patterns.interpreter.parsergenerator.parsertables.ParserBuildException;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;
import fri.patterns.interpreter.parsergenerator.syntax.SyntaxException;
import fri.patterns.interpreter.parsergenerator.syntax.builder.SyntaxSeparation;

public class ParserInterface {
	
	private final Syntax fSyntax;
	private final Map<String, Template> templatesForNonTerminals = new HashMap<String, Template>();
	private Parser fParser = null;

	public ParserInterface(Template template) {
		super();
		fSyntax = new Syntax();
		
		collectAllRules(template, new HashSet<String>());
		fSyntax.addRule(new Rule(new String[] { Token.IGNORED, "`whitespaces`" }));
	}
	
	/**
	 * Collects all neccessary parser rules from a template.
	 */
	private void collectAllRules(Template template, Collection<String> visitedNonTerminals) {
		if (! visitedNonTerminals.contains(template.getNonTerminal())) {
			if (template.getRules() != null) {
				for (String[] rule: template.getRules()) {
					templatesForNonTerminals.put(rule[0], template);
					fSyntax.addRule(new Rule(rule));
				}
			}
			if (template instanceof ElementTemplate) {
				visitedNonTerminals.add(template.getNonTerminal());
			}
			for(Template nestedTemplate: template.getNestedTemplates()) {
				collectAllRules(nestedTemplate, visitedNonTerminals);
			}
		}
	}
	
	private Parser getParser() throws SyntaxException, ParserBuildException, LexerException {
		if (fParser == null) {
			SyntaxSeparation separation = new SyntaxSeparation(fSyntax);	// separate lexer and parser syntax
			LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());	// build a Lexer
			Lexer lexer = builder.getLexer();
									
			ParserTables parserTables = new LALRParserTables(separation.getParserSyntax());			
			fParser = new Parser(parserTables);			
			fParser.setLexer(lexer);	
		}
		return fParser;
 	}
	
	public boolean parse(String content, Semantic semantic) {		
		boolean ok = false;
		try {						
			Parser parser = getParser();
			parser.getLexer().setInput(content.trim());						
			ok = parser.parse(semantic);	// start parsing with a print-semantic			
			return ok;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void printGrammar(DocumentText text) {
		System.out.println(fSyntax.toString());
	}
	
	public void test(DocumentText text) {
		Parser parser;
		boolean ok = false;
		try {			
			System.out.println(fSyntax.toString());
			
			SyntaxSeparation separation = new SyntaxSeparation(fSyntax);	// separate lexer and parser syntax
			LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());	// build a Lexer
			Lexer lexer = builder.getLexer();
									
			ParserTables parserTables = new LALRParserTables(separation.getParserSyntax());			
			parser = new Parser(parserTables);			
			parser.setLexer(lexer);
			parser.getLexer().setInput(text.getContent());						
			ok = parser.parse(new ParseAlongTreeSemantic(TextBasedAST.createASTTree(text)));	// start parsing with a print-semantic
			
			System.out.println("Parse return "+ok+", result: "+parser.getResult());		
			System.out.println(AbstractTree.dumpTree(TextBasedAST.createASTTree(text)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return fSyntax.toString();
	}
	
	public Template getTemplateForNonTerminal(String symbol) {
		return templatesForNonTerminals.get(symbol);
	}
}
