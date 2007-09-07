package hub.sam.tef.completion;

import fri.patterns.interpreter.parsergenerator.syntax.Rule;

public abstract class EmptyReductionCompletion implements ICompletionComputer {

	public abstract Rule getRule();
	
	public boolean reduceParseStack(CompletionParser parser) {
		parser.reduce(getRule(), 0);
		return true;
	}

}
