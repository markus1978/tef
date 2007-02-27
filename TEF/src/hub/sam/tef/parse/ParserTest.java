package hub.sam.tef.parse;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.views.DocumentText;
import hub.sam.util.trees.AbstractTree;

import java.util.Collection;
import java.util.HashSet;

import fri.patterns.interpreter.parsergenerator.Lexer;
import fri.patterns.interpreter.parsergenerator.Parser;
import fri.patterns.interpreter.parsergenerator.ParserTables;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.lexer.LexerBuilder;
import fri.patterns.interpreter.parsergenerator.parsertables.LALRParserTables;
import fri.patterns.interpreter.parsergenerator.semantics.PrintSemantic;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;
import fri.patterns.interpreter.parsergenerator.syntax.builder.SyntaxSeparation;

public class ParserTest {
	
	private final Syntax fSyntax;

	public ParserTest(Template template) {
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
			ok = parser.parse(new ParseAlongTreeSemantic(ASTTree.createASTTree(text)));	// start parsing with a print-semantic
			
			System.out.println("Parse return "+ok+", result: "+parser.getResult());		
			System.out.println(AbstractTree.dumpTree(ASTTree.createASTTree(text)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return fSyntax.toString();
	}
}
