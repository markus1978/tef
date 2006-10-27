package editortest.widgets;

import java.util.Collections;

public abstract class AbstractOffsetBasedVisitor implements ITextVisitor {

	private final int forOffset;
		
	public AbstractOffsetBasedVisitor(final int forOffset) {
		super();		
		this.forOffset = forOffset;
	}

	public final Iterable<Text> decentInto(CompoundText text) {
		int absolutOffset = text.getAbsolutOffset(0);
		if (absolutOffset <= forOffset) {
			return text.getInnerTextAt(forOffset - text.getAbsolutOffset(0));
		} else {
			return Collections.emptyList();
		}
	}	
}
