package hub.sam.tef.templates;

import fri.patterns.interpreter.parsergenerator.syntax.Rule;
import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTElement;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.ModelASTElement;
import hub.sam.tef.reconciliation.treerepresentation.ModelSequenceASTNode;
import hub.sam.tef.reconciliation.treerepresentation.TextASTElement;

import java.awt.image.RescaleOp;
import java.util.List;
import java.util.Vector;

public class SequenceTemplateSemantics implements ISyntaxProvider, IASTProvider, ISemanticProvider {

	private final SequenceTemplate fTemplate;
		
	protected SequenceTemplateSemantics(final SequenceTemplate template) {
		super();
		fTemplate = template;
	}

	public String getNonTerminal() {
		return fTemplate.getValueTemplate().getAdapter(ISyntaxProvider.class).getNonTerminal() + "_sequence";
	}
	
	private String getNonOptNonTerminal() {
		return getNonTerminal() + "_no";
	}

	public String[][] getRules() {
		ISyntaxProvider valueSyntaxProvider = fTemplate.getValueTemplate().getAdapter(ISyntaxProvider.class);
		List<String[]> rules = new Vector<String[]>();
		if (fTemplate.fSeparator != null) {
			if (fTemplate.fSeparateLast) {
				rules.add(new String[] { getNonOptNonTerminal() , 
						valueSyntaxProvider.getNonTerminal(), "'" +fTemplate.fSeparator + "'" });
			    rules.add(new String[] { getNonOptNonTerminal(), getNonOptNonTerminal(), 
			    		valueSyntaxProvider.getNonTerminal(), "'" +fTemplate.fSeparator + "'" }); 				
			} else {
				rules.add(new String[] { getNonOptNonTerminal(), valueSyntaxProvider.getNonTerminal() });
				rules.add(new String[] { getNonOptNonTerminal(), getNonOptNonTerminal(), 
						"'" + fTemplate.fSeparator + "'", valueSyntaxProvider.getNonTerminal() }); 
			}
		} else {			
			rules.add(new String[] { getNonOptNonTerminal(), valueSyntaxProvider.getNonTerminal() });
			rules.add(new String[] { getNonOptNonTerminal(), 
					getNonOptNonTerminal(),  valueSyntaxProvider.getNonTerminal() }); 					
		}
		rules.add(new String[] { getNonTerminal() });
		rules.add(new String[] { getNonTerminal(), getNonOptNonTerminal() });
		return rules.toArray(new String[][] {});
	}	
	
	
	private static final String valueKey = "VALUE_KEY";
	private static final String tailKey = "TAIL_KEY";
	private static final String sequenceKey = "SEQUENCE_KEY";
	
	public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout) {
		ASTElementNode treeRepresentation = new ASTElementNode(
				new ModelASTElement(fTemplate, (IModelElement)model));
		
		ICollection elements = (ICollection)((IModelElement)model).getValue(property);
		int i = 0;		
		boolean first = true;
		ASTElementNode result = treeRepresentation;
		ASTElementNode parentNode = treeRepresentation;
		for (Object element: elements) {			
			ASTElementNode sequence = new ASTElementNode(
					new ModelASTElement(fTemplate, (IModelElement)model));
			if (first) {
				parentNode.addNodeObject(sequenceKey, sequence);
				first = false;
			} else {
				parentNode.addNodeObject(tailKey, sequence);
			}
			
			sequence.addNodeObject(valueKey, fTemplate.getValueTemplate().getAdapter(IASTProvider.class).
					createTreeRepresentation(owner, null, (IModelElement)element, isComposite, layout));
						
			if (fTemplate.fSeparator != null && i+1 < elements.size()) {
				sequence.addNodeObject(fTemplate.fSeparator);
			}	
			if (i+1 < elements.size()) {
				sequence.addNodeObject(fTemplate.getSeparatorWhitespace().getSpace(layout));
			}
			i++;						
			parentNode = sequence;
		}
		if (fTemplate.fSeparateLast && fTemplate.fSeparator != null && elements.size() > 0) {			
			ASTElementNode sequence = 
					new ASTElementNode(new ModelASTElement(fTemplate, (IModelElement)model));										
			sequence.addNodeObject(fTemplate.fSeparator);			
			parentNode.addNodeObject(tailKey, sequence);
			parentNode = sequence;
		}
		if (fTemplate.fSeparateLast && elements.size() > 0) {			
			parentNode.addNodeObject(fTemplate.getSeparatorWhitespace().getSpace(layout));
		}
		return result;		
	}		
	
	public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {			
		tree = skipOptionalRule((ASTElementNode)tree, owner);
		if (tree == null) { // empty sequence
			return null;
		}
		ASTElementNode nextTree = getTailNode((ASTElementNode)tree);
		if (nextTree != null) {
			nextTree.setElement(new ModelASTElement(fTemplate, owner));
			createCompositeModel(owner, property, nextTree, isComposite);
		}
		fTemplate.getValueTemplate().getAdapter(IASTProvider.class).
		createCompositeModel(owner, property, getValueNode((ASTElementNode)tree), true);
		return null;
	}
	
	

	public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {
		tree = skipOptionalRule((ASTElementNode)tree, owner);
		if (tree == null) { // empty sequence
			return null;
		}
		ASTElementNode nextTree = getTailNode((ASTElementNode)tree);
		if (nextTree != null) {		
			createReferenceModel(owner, property, nextTree, isComposite, context);
		}
		fTemplate.getValueTemplate().getAdapter(IASTProvider.class).
				createReferenceModel(owner, property, getValueNode((ASTElementNode)tree), true, context);
		return null;
	}

	private ASTElementNode getTailNode(ASTElementNode ast) {
		for (ASTElementNode child: ast.getChildNodes()) {
			if (child.getElement().getSymbol().equals(ast.getElement().getSymbol())) {
				return child;
			}
		}
		return null;
	}

	private ASTElementNode getValueNode(ASTElementNode ast) {
		for (ASTElementNode child: ast.getChildNodes()) {
			if (!child.getElement().getSymbol().equals(ast.getElement().getSymbol())) {
				return child;
			}
		}
		// primitive value TODO
		throw new RuntimeException("assert");
	}
	
	private List<ASTElementNode> collectAllValueNodes(ASTElementNode head, List<ASTElementNode> nodes) {		
		ASTElementNode tail = getTailNode(head);
		if (tail != null) {
			collectAllValueNodes(tail, nodes);
		}
		nodes.add(getValueNode(head));
		return nodes;
	}

	private ASTElementNode skipOptionalRule(ASTElementNode tree, IModelElement owner) {
		IASTElement element = tree.getElement();
		if (element instanceof TextASTElement) {
			if (((TextASTElement)element).getSymbol().endsWith("_sequence")) {
				tree.setElement(new ModelSequenceASTNode(fTemplate, owner));
				return (ASTElementNode)tree.getFirstChild();
			} else {
				return tree;
			}
		} else {
			if (element instanceof ModelSequenceASTNode) {
				return (ASTElementNode)tree.getFirstChild();
			} else {
				return tree;
			}
		}		
	}
	
	public void check(ASTElementNode representation, SemanticsContext context) {	
		representation = skipOptionalRule(representation, null);
		if (representation == null) { // empty sequence
			return;
		}
		List<ASTElementNode> allValueNodes = collectAllValueNodes((ASTElementNode)representation, new Vector<ASTElementNode>());				
		for (ASTElementNode valueNode: allValueNodes) {
			fTemplate.getValueTemplate().getAdapter(ISemanticProvider.class).check(valueNode, context);
		}
	}	
}
