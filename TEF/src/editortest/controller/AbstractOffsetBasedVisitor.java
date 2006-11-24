package editortest.controller;

import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.ITextVisitor;
import hub.sam.tef.views.Text;

import java.util.Collections;


/**
 * This abstract visitor visits only the texts that lay at a given position in the
 * document.
 */
public abstract class AbstractOffsetBasedVisitor implements ITextVisitor {

	private final int forOffset;
		
	/** 
	 * @param forOffset A position in the document. This visitor decents only into
	 * children that represent a part of the document at this offset.
	 */
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
