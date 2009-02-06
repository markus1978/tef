package hub.sam.tef.modelcreating;

import hub.sam.tef.rcc.Token;
import hub.sam.tef.semantics.Error;

import org.eclipse.jface.text.Position;

public class ParserError extends Error {

	public ParserError(final int lastOffset) {
		super(new Position((lastOffset - 5 < 0) ? 0 : lastOffset - 5,
				((lastOffset - 5 < 0) ? lastOffset : 5)), "parser error");
	}

	public ParserError(final Token token) {
		super(
				new Position(
						token.range.start.offset,
						(token.range.end.offset - token.range.start.offset) > 0 ? token.range.end.offset
								- token.range.start.offset
								: 1), "Parser error at token: '" + token.text
						+ "'");
	}
}
