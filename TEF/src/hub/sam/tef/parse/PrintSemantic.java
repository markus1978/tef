package hub.sam.tef.parse;

import java.util.List;

import fri.patterns.interpreter.parsergenerator.Token.Range;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

public class PrintSemantic implements fri.patterns.interpreter.parsergenerator.Semantic {

	public Object doSemantic(Rule rule, List parseResults, List<Range> resultRanges) {
		System.out.println("parser parsed " + rule);
		return null;
	}
	

}
