package hub.sam.tef.parse;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;

import java.util.Collection;
import java.util.HashSet;

import fri.patterns.interpreter.parsergenerator.Parser;
import fri.patterns.interpreter.parsergenerator.ParserTables;
import fri.patterns.interpreter.parsergenerator.parsertables.LALRParserTables;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;

public class ParserTest {
	
	private final Syntax fSyntax;

	public ParserTest(Template template) {
		super();
		fSyntax = new Syntax();
		collectAllRules(template, new HashSet<String>());
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
	
	public void test() {
		Parser parser;
		boolean ok = false;
		try {
			/*
			SyntaxSeparation separation = new SyntaxSeparation(fSyntax);	// separate lexer and parser syntax
			LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());	// build a Lexer
			Lexer lexer = builder.getLexer();
			lexer.setInput("self.test");	// give the lexer some very complex input :-)
			*/
			System.out.println(fSyntax.toString()); //... die regeln gehen jetzt total durcheinander, nochmal überdenken, properties, ref, etc. gleich am typ festmachen
			ParserTables parserTables = new LALRParserTables(fSyntax);
			/*
			parser = new Parser(parserTables);
			parser.parse();	// start parsing with a print-semantic
			ok = parser.parse();
			System.err.println("Parse return "+ok+", result: "+parser.getResult());
			*/			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("test parse was ok: " + ok);
	}

	@Override
	public String toString() {
		return fSyntax.toString();
	}
}
