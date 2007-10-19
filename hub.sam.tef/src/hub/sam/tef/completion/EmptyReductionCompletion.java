package hub.sam.tef.completion;

import hub.sam.tef.rcc.syntax.Rule;

public abstract class EmptyReductionCompletion implements ICompletionComputer {

	public abstract Rule getRule();
	
	public boolean reduceParseStack(CompletionParser parser) {
		parser.reduce(getRule(), 0);
		return true;
	}

}
