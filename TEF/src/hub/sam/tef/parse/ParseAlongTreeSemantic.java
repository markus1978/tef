package hub.sam.tef.parse;

import hub.sam.tef.templates.Template;

import java.util.List;

import fri.patterns.interpreter.parsergenerator.Semantic;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
 * RCC semantics that comares the current parse with an existing AST.
 */
public class ParseAlongTreeSemantic implements Semantic {

	public ParseAlongTreeSemantic(final ASTTree tree) {
		super();
		nextOnTextTree = tree.getFirstLeaf().getParent(); // the first non-terminal
	}
	
	private ASTTree nextOnTextTree = null;

	public Object doSemantic(Rule rule, List parseResults, List resultRanges) {
		boolean ok = true;
		ASTTree siblings = nextOnTextTree.getFirstChild();
		for(Object parseResult: parseResults) {
			if (siblings == null) {
				ok = false;
			}
			System.out.println("parseResult: " + parseResult);
			if (parseResult instanceof String) {				
				if (Rule.isTerminal(siblings.getSymbol())) {
					if (parseResult.equals(siblings.getElement().getContent())) {
						
					} else {
						ok = false;
					}
				} else {
					ok = false;
				}
			} else if (parseResult instanceof Template) {
				if (!Rule.isTerminal(siblings.getSymbol())) {
					if (parseResult.equals(siblings.getTemplate())) {
						
					} else {
						ok = false;
					}
				} else {
					ok = false;
				}
			} else {
				throw new RuntimeException();
			}
			siblings = siblings.getNextSibling();
		}
		if (siblings != null) {
			ok = false;
		} 
		
		if (!Rule.isTerminal(nextOnTextTree.getSymbol())) {
			if (rule.getNonterminal().equals(nextOnTextTree.getSymbol())) {
				
			} else {
				ok = false;
			}
		} else {
			ok = false;
		}
		
		if (!ok) {
			throw new RuntimeException("Syntax does not fit");
		}
		
		Template result = nextOnTextTree.getTemplate();		
		ASTTree nextSibling = getNextNonTerminalSibling(nextOnTextTree);
		
		if (nextSibling == null) {
			nextOnTextTree = nextOnTextTree.getParent();
		} else {
			nextOnTextTree = nextSibling;
		}
						
		return result;
	}

	private ASTTree getNextNonTerminalSibling(ASTTree tree) {
		ASTTree nextSibling = tree.getNextSibling();
		if (nextSibling == null) {
			return null;
		} else  if (nextSibling.isLeaf()) {
			return getNextNonTerminalSibling(nextSibling);
		} else {
			return nextSibling.getFirstLeaf().getParent();
		}
	}
	
}
