package hub.sam.tef.contentassist;

import hub.sam.tef.modelcreating.Parser;
import hub.sam.tef.rcc.ParserTables;
import hub.sam.tef.rcc.lexer.LexerException;
import hub.sam.tef.rcc.parsertables.ParserBuildException;
import hub.sam.tef.rcc.syntax.SyntaxException;
import hub.sam.tef.tsl.Syntax;

public class CompletionParser extends Parser {

	public CompletionParser(Syntax syntax) {
		super(syntax);
	}

	@Override
	protected hub.sam.tef.rcc.Parser createRccParser(ParserTables parserTables) {
		return new RccCompletionParser(parserTables);
	}

	@Override
	public RccCompletionParser getRccParser() throws SyntaxException,
			ParserBuildException, LexerException {
		return (RccCompletionParser) super.getRccParser();
	}	
}
