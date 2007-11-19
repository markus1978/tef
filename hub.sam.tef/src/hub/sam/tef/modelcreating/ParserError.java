package hub.sam.tef.modelcreating;

import hub.sam.tef.semantics.Error;

import org.eclipse.jface.text.Position;

public class ParserError extends Error {

	public ParserError(int lastOffset) {
		super(new Position((lastOffset - 5 <  0) ? 0 : lastOffset - 5, 
				((lastOffset - 5 <  0) ? lastOffset : 5)), "parser error");
	}

}
