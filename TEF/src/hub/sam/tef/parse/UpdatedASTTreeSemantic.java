package hub.sam.tef.parse;

import fri.patterns.interpreter.parsergenerator.Semantic;
import fri.patterns.interpreter.parsergenerator.Token.Range;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import hub.sam.tef.views.Text;
import hub.sam.util.strings.Changes;
import hub.sam.util.trees.DepthFirstLeafFirstTreeIterator;
import hub.sam.util.trees.TreeIterator;

import java.util.List;

/**
 * This semantics builds a new AST {@link TextBasedUpdatedAST}. Thereby it puts references to the nodes
 * of an old existing AST into the new AST. When a node of the new AST was created in the
 * same way then in the old AST, it gets an reference to the according old AST node. A node
 * is created in the same way then the old AST, when (1) all it children either represent old input (terminals)
 * or nodes that already reference a node in the old AST (non-terminals). And (2) the according old
 * nodes reduced to the same symbol then the new node.
 */
public class UpdatedASTTreeSemantic implements Semantic {

	private final TextBasedAST fOldASTRootNode;
	private final Changes fChanges;
	private TextBasedUpdatedAST result;
	private final ParserInterface fParserInterface;
	
	public UpdatedASTTreeSemantic(TextBasedAST tree, Changes changes, ParserInterface parserInterface) {		
		this.fOldASTRootNode = tree;
		this.fChanges = changes;
		this.fParserInterface = parserInterface;
	}
	
	public Object doSemantic(Rule rule, List parseResults, List<Range> resultRanges) {
		if (parseResults.size() == 0) {
			throw new RuntimeException("assert");
		}
		int i = 0;
		boolean allOldParseResults = true;
		TextBasedUpdatedAST result = new TextBasedUpdatedAST(rule.getNonterminal(), 
				fParserInterface.getTemplateForNonTerminal(rule.getNonterminal()));
		for(Object parseResult: parseResults) {
			if (!isOldParseResult(parseResult, resultRanges.get(i))) {
				allOldParseResults = false;				
			} 
			if (parseResult instanceof TextBasedUpdatedAST) {				
				result.addChild((TextBasedUpdatedAST)parseResult);
			} else {
				// TODO remember terminals
			}
			i++;
		}
		
		if (allOldParseResults) {
			// check whether old results have same parent
			TextBasedAST commonParent = null;
			i = 0;
			loop: for (Object parseResult: parseResults) {
				TextBasedAST currentParseResultParent = null;
				if (parseResult instanceof TextBasedUpdatedAST) {
					currentParseResultParent = ((TextBasedUpdatedAST)parseResult).getElement().getParent();
				} else {
					currentParseResultParent = findOldASTNode((String)parseResult, resultRanges.get(i));
					if (currentParseResultParent == null) {
						new RuntimeException("assert");
					}					
				}
				if (i == 0) {
					commonParent = currentParseResultParent;
				} else {
					if (!commonParent.equals(currentParseResultParent)) {
						// different reduce then in the old parse
						commonParent = null;
						break loop;
					}
				}
				i++;				
			}
			
			if (commonParent != null && commonParent.getSymbol().equals(rule.getNonterminal())) {
				// the old parent can be preserved
				result.setReferenceToOldASTNode(commonParent);
			}	else {
				System.out.println("hoop");
			}
		}
		
		this.result = result;
		return result;
	}

	private boolean isOldParseResult(Object parseResult, Range range) {
		if (parseResult instanceof String) {
			return isOldInput(range.start.offset, range.end.offset);
		} else if (parseResult instanceof TextBasedUpdatedAST) {
			return ((TextBasedUpdatedAST)parseResult).referencesOldASTNode();
		} else {
			throw new RuntimeException("assert");
		}
	}

	// TODO performance
	private TextBasedAST findOldASTNode(String input, Range range) {
		TreeIterator<TextBasedAST, Text> iterator = new DepthFirstLeafFirstTreeIterator<TextBasedAST, Text>(fOldASTRootNode);
		while (iterator.hasNext()) {
			TextBasedAST next = iterator.next();
			if (next.isLeaf()) {
				Text text = next.getElement();
				int absolutOffset = text.getAbsolutOffset(0);
				int relativeStart = fChanges.getIndexBeforeChanges(range.start.offset) - absolutOffset;
				int relativeEnd = fChanges.getIndexBeforeChanges(range.end.offset) - absolutOffset;
				if (relativeStart >= 0 && relativeEnd >= 0 && relativeEnd <= text.getLength()) {
					if (text.getContent(relativeStart, relativeEnd).equals(input)) {
						if (Rule.isTerminal(next.getSymbol())) {
							return next.getParent();
						} else {
							return next;
						}
					} else {
						return null;
					}
				} 
			}
		}
		return null;
	}
	
	private boolean isOldInput(int start, int end) {
		int startIndexInOldContent = fChanges.getIndexBeforeChanges(start);
		int endIndexInOldContent = fChanges.getIndexBeforeChanges(end);
		return startIndexInOldContent != -1 && endIndexInOldContent != -1;
	}
	
	public TextBasedUpdatedAST getCurrentResult() {
		return result;
	}
}
