package hub.sam.tef.contentassist;

import hub.sam.tef.modelcreating.Parser;
import hub.sam.tef.rcc.ParserTables;
import hub.sam.tef.rcc.lexer.LexerException;
import hub.sam.tef.rcc.parsertables.ParserBuildException;
import hub.sam.tef.rcc.syntax.SyntaxException;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;

public class ContentAssistParser extends Parser {

	public ContentAssistParser(Syntax syntax) {
		super(syntax);
	}

	@Override
	protected hub.sam.tef.rcc.Parser createRccParser(ParserTables parserTables) {	
		return new RccContentAssistParser(parserTables);
	}

	@Override
	public RccContentAssistParser getRccParser() throws SyntaxException,
			ParserBuildException, LexerException, TslException {
		return (RccContentAssistParser) super.getRccParser();
	}
}
