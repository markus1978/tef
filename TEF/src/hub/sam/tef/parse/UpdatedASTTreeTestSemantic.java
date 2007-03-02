package hub.sam.tef.parse;

import hub.sam.tef.views.Text;
import hub.sam.util.strings.Changes;
import hub.sam.util.trees.DepthFirstLeafFirstTreeIterator;
import hub.sam.util.trees.TreeIterator;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import fri.patterns.interpreter.parsergenerator.Semantic;
import fri.patterns.interpreter.parsergenerator.Token.Range;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
* This was a try: Also reuse nodes when some of its childs are new. But it is never really clear when
* it really can be reused and when not.
*/
public class UpdatedASTTreeTestSemantic implements Semantic {

	private final TextBasedAST fOldASTRootNode;
	private final Changes fChanges;
	private TextBasedUpdatedAST result;
	private final ParserInterface fParserInterface;
	
	public UpdatedASTTreeTestSemantic(TextBasedAST tree, Changes changes, ParserInterface parserInterface) {		
		this.fOldASTRootNode = tree;
		this.fChanges = changes;
		this.fParserInterface = parserInterface;
	}
	
	public Object doSemantic(Rule rule, List parseResults, List<Range> resultRanges) {
		if (parseResults.size() == 0) {
			throw new RuntimeException("assert");
		}
		int i = 0;
		boolean haveOldParseResults = false;
		Collection oldParseResults = new HashSet();
		TextBasedUpdatedAST result = new TextBasedUpdatedAST(rule.getNonterminal(),
				fParserInterface.getTemplateForNonTerminal(rule.getNonterminal()));
		for(Object parseResult: parseResults) {
			if (isOldParseResult(parseResult, resultRanges.get(i))) {
				haveOldParseResults = true;	
				oldParseResults.add(parseResult);
			} 
			if (parseResult instanceof TextBasedUpdatedAST) {
				// TODO remember terminals
				result.addChild((TextBasedUpdatedAST)parseResult);
			}
			i++;
		}
		
		if (haveOldParseResults) {
			// check whether old results have same parent
			TextBasedAST commonParent = null;
			i = 0;
			boolean first = true;
			loop: for (Object parseResult: parseResults) {
				if (oldParseResults.contains(parseResult)) {
					TextBasedAST currentParseResultParent = null;
					if (parseResult instanceof TextBasedUpdatedAST) {
						currentParseResultParent = ((TextBasedUpdatedAST)parseResult).getElement().getParent();
					} else {
						currentParseResultParent = findOldASTNode((String)parseResult, resultRanges.get(i));
						if (currentParseResultParent == null) {
							throw new RuntimeException("assert");
						}					
					}
					if (first) {
						first = false;
						commonParent = currentParseResultParent;
					} else {
						if (!commonParent.equals(currentParseResultParent)) {
							// different reduce then in the old parse
							commonParent = null;
							break loop;
						}
					}
				}
				i++;				
			}
			
			if (commonParent != null && commonParent.getSymbol().equals(rule.getNonterminal()) && !commonParent.isReused()) {
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
