package editortest.text;

public interface ITextVisitor {
	public void visitText(Text visitedText, int atOffset);
	
	public void visitCompoundText(CompoundText visitedText, int atOffset);
	
	public Iterable<Text> decentInto(CompoundText text);
}
