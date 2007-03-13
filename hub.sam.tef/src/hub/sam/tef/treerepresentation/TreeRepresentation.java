package hub.sam.tef.treerepresentation;

import hub.sam.util.trees.AbstractChildTree;

import java.io.PrintStream;

public class TreeRepresentation extends AbstractChildTree<TreeRepresentation, TreeContents> {

	private TreeRepresentation oldRepresentation = null;

	public TreeRepresentation(TreeContents contents) {
		super(contents);
	}
	
	public void setReferenceToOldRepresentation(TreeRepresentation oldRepresentation) {
		if (oldRepresentation != null) {
			throw new RuntimeException("assert");
		}
		this.oldRepresentation = oldRepresentation;
	}

	public boolean referencesOldRepresentation() {
		return oldRepresentation != null;
	}
	

	@Override
	public String toString() {
		if (referencesOldRepresentation()) {
			return "#" + oldRepresentation.toString();
		} else {			
			return "%" + getElement().toString();
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
		for (TreeRepresentation child: getChildNodes()) {
			child.print(out, depth +3);
		}
	}
}
