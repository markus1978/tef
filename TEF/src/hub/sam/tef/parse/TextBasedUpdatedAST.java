package hub.sam.tef.parse;

import hub.sam.util.trees.AbstractChildTree;
import hub.sam.util.trees.ITree;

import java.io.PrintStream;
import java.util.List;
import java.util.Vector;

public class TextBasedUpdatedAST extends AbstractChildTree<TextBasedUpdatedAST, TextBasedAST> {

	private final String symbol;
	
	public TextBasedUpdatedAST(final String symbol) {
		super(null);
		this.symbol = symbol;
	}
	
	public void setReferenceToOldASTNode(TextBasedAST oldAST) {
		setElement(oldAST);
		oldAST.setReused();
	}
	
	public boolean referencesOldASTNode() {
		return getElement() != null && getElement() instanceof ITree;
	}

	@Override
	public String toString() {
		if (referencesOldASTNode()) {
			return "#(" + getElement().toString() + ")";
		} else {
			return "%(" + getSymbol() + ")";
		}
	}
	
	public void print(PrintStream out) {
		print(out, 0);
	}
	
	private void print(PrintStream out, int depth) {
		for (int i = 0; i < depth; i++) {
			out.print(" ");
		}
		out.println(toString());
		for (TextBasedUpdatedAST child: getChildNodes()) {
			child.print(out, depth +3);
		}
	}

	public void topDownInclusionOfOldAST(TextBasedAST oldAST) {
		if (referencesOldASTNode()) {
			return;
		}
		if (!oldAST.isReused() && oldAST.getSymbol().equals(getSymbol()) && 
				oldAST.getChildSymbols().equals(getChildSymbols())) {
			setReferenceToOldASTNode(oldAST);
			int i = 0;
			List<TextBasedAST> oldASTChildren = oldAST.getChildNodes();
			for (TextBasedUpdatedAST child: getChildNodes()) {
				child.topDownInclusionOfOldAST(oldASTChildren.get(i++));
			}
		} else {
			return;
		}
	}

	public String getSymbol() {
		return symbol;
	}
	
	public List<String> getChildSymbols() {
		List<String> result = new Vector<String>();
		for (TextBasedUpdatedAST child: getChildNodes()) {
			result.add(child.getSymbol());
		}
		return result;
	}	
	
}
