package hub.sam.tef.contentassist;

import hub.sam.tef.tsl.Rule;

public abstract class EmptyReductionCompletion implements ICompletionComputer {

	public abstract Rule getRule();
	
	public boolean reduceParseStack(RccCompletionParser parser) {
		parser.reduce(getRule().getRCCRule(), 0);
		return true;
	}

}
