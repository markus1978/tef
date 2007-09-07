package hub.sam.tef.reconciliation.syntax;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.EmtpyElementTemplate;
import hub.sam.tef.templates.Template;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.runtime.Status;

import fri.patterns.interpreter.parsergenerator.Lexer;
import fri.patterns.interpreter.parsergenerator.Parser;
import fri.patterns.interpreter.parsergenerator.ParserTables;
import fri.patterns.interpreter.parsergenerator.Semantic;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.lexer.LexerBuilder;
import fri.patterns.interpreter.parsergenerator.lexer.LexerException;
import fri.patterns.interpreter.parsergenerator.lexer.LexerImpl;
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
	
	private int lastOffset = -1;

	public ParserInterface(Template template) {
		super();
		fSyntax = new Syntax();
		
		collectAllRules(template, new HashSet<String>());
		fSyntax.addRule(new Rule(new String[] { Token.IGNORED, "`whitespaces`" }));
		TEFPlugin.getDefault().getLog().log(new Status(Status.INFO,
				TEFPlugin.PLUGIN_ID, Status.OK, "Grammar for editor: \n" + fSyntax.toString(), null));			
	}
	
	/**
	 * Collects all necessary parser rules from a template.
	 */
	private void collectAllRules(Template template, Collection<String> visitedNonTerminals) {
		ISyntaxProvider syntaxProvider = template.getAdapter(ISyntaxProvider.class);
		if (syntaxProvider != null && ! visitedNonTerminals.contains(syntaxProvider.getNonTerminal())) {
			if (template instanceof ElementTemplate || template instanceof EmtpyElementTemplate) {
				visitedNonTerminals.add(syntaxProvider.getNonTerminal());
			}
			if (syntaxProvider.getRules() != null) {
				for (String[] rule: syntaxProvider.getRules()) {
					templatesForNonTerminals.put(rule[0], template);
					fSyntax.addRule(new Rule(rule));
				}
			}
			for(Template nestedTemplate: template.getNestedTemplates()) {
				collectAllRules(nestedTemplate, visitedNonTerminals);
			}
		}
	}
	
	private Parser createParser() throws SyntaxException, ParserBuildException, LexerException {
		if (fParser == null) {
			SyntaxSeparation separation = new SyntaxSeparation(fSyntax);	// separate lexer and parser syntax
			LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());	// build a Lexer
			Lexer lexer = builder.getLexer();
									
			ParserTables parserTables = new LALRParserTables(separation.getParserSyntax());			
			fParser = createParser(parserTables);			
			fParser.setLexer(lexer);				
		}
		return fParser;
 	}
	
	public Parser getParser() throws SyntaxException, ParserBuildException, LexerException {		
		createParser();
		return fParser;
	}
	
	protected Parser createParser(ParserTables parserTables) {
		return new Parser(parserTables);
	}
	
	public boolean parse(String content, Semantic semantic) {		
		boolean ok = false;
		try {						
			Parser parser = createParser();		
			parser.getLexer().setInput(content.trim());						
			ok = parser.parse(semantic);	// start parsing with a print-semantic			
			lastOffset = ((LexerImpl)parser.getLexer()).getOffset();
			return ok;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void printGrammar() {
		System.out.println(fSyntax.toString());
	}
	
	public int getLastOffset() {
		return lastOffset;
	}

	@Override
	public String toString() {
		return fSyntax.toString();
	}
	
	public Template getTemplateForNonTerminal(String symbol) {
		return templatesForNonTerminals.get(symbol);
	}
}
