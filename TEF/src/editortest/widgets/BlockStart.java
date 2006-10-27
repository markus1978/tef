package editortest.widgets;

public class BlockStart extends FixText {

	private int indent;
	
	public BlockStart(int indent) {
		super("");		
		this.indent = indent;
	}
	
	protected int getIndent() {
		return indent;
	}
}
