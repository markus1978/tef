package hub.sam.tef.reconciliation.syntax;

import hub.sam.tef.rcc.Semantic;
import hub.sam.tef.rcc.Token.Range;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.TextASTElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;

import java.util.List;

/**
 * This semantics builds a new AST {@link TextBasedUpdatedAST}. Thereby it puts references to the nodes
 * of an old existing AST into the new AST. When a node of the new AST was created in the
 * same way then in the old AST, it gets an reference to the according old AST node. A node
 * is created in the same way then the old AST, when (1) all it children either represent old input (terminals)
 * or nodes that already reference a node in the old AST (non-terminals). And (2) the according old
 * nodes reduced to the same symbol then the new node.
 */
public class UpdateTreeSemantic implements Semantic {

	private ASTElementNode result;
	private final ParserInterface fParserInterface;
	
	private final String stringContent;	
	
	public UpdateTreeSemantic(ParserInterface parserInterface, String content) {		
		this.fParserInterface = parserInterface;
		this.stringContent = content;
	}
	
	/**
	 * Is necessary because RCC has a bug and does not provide reasonable ranges
	 * for empty parse results.
	 */
	private boolean isValidParseResult(Object parseResult, Range range) {
		if (range.start.offset != range.end.offset) {
			if (!(parseResult instanceof ASTNode) || ((ASTNode)parseResult).getLength() > 0) {
				return true;
			}
		}
		return false;
	}
	
	public Object doSemantic(Rule rule, List parseResults, List<Range> resultRanges) {		
		Template template = fParserInterface.getTemplateForNonTerminal(rule.getNonterminal()); 
		if (template == null) {
			throw new RuntimeException("assert");
		}
		ASTElementNode result = new ASTElementNode(new TextASTElement(rule, template));
				
		int i = 0;		
		for(Object parseResult: parseResults) {		
			if (i > 0) {
				Object currentParseResult = parseResults.get(i);
				int start = resultRanges.get(i-1).end.offset;
				int end = 0;
				if (currentParseResult instanceof ASTNode) {
					end = resultRanges.get(i).end.offset - ((ASTNode)currentParseResult).getLength();	
				} else {
					end = resultRanges.get(i).end.offset - ((String)currentParseResult).length();
				}
				
				
				if (start != end) {
					String whiteSpace = stringContent.substring(start, end);
					//if (!whiteSpace.trim().equals("")) {
					//	throw new RuntimeException("assert");
					//}
					result.addNodeObject(whiteSpace);
				}
				
			}		
			
			if (template instanceof ElementTemplate) {
				String property = ((ElementTemplate)template).getAdapter(IElementSyntaxProvider.class).
						getPropertyForRuleAndPosition(rule, i);
				if (property != null) {
					result.addNodeObject(property, parseResult);
				} else {
					// its a terminal
					result.addNodeObject(parseResult);
				}
			} else {			
				result.addNodeObject(parseResult);
			}				
			i++;
		}	
		
		this.result = result;
		return result;		
	}
	

	public Object doSemanticForErrorRecovery(String recoverSymbol) {
		Template template = fParserInterface.getTemplateForNonTerminal(recoverSymbol);
		return new ASTElementNode(new TextASTElement(null, template));
	}
	
	public ASTElementNode getCurrentResult() {
		return result;
	}
}
