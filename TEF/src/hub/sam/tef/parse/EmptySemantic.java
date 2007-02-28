package hub.sam.tef.parse;

import java.util.List;

import fri.patterns.interpreter.parsergenerator.Semantic;
import fri.patterns.interpreter.parsergenerator.Token.Range;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

public class EmptySemantic implements Semantic {

	public Object doSemantic(Rule rule, List parseResults, List<Range> resultRanges) {
		return null;
	}

}
