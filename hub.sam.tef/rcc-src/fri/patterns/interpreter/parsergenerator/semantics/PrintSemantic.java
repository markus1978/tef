package fri.patterns.interpreter.parsergenerator.semantics;

import java.util.*;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.Semantic;
import fri.patterns.interpreter.parsergenerator.Token.Range;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
	Simple test semantic that outputs the rule nonterminal on left side
	and its parsed values.
	
	@author (c) 2000, Fritz Ritzberger
*/

public class PrintSemantic implements Semantic
{
	public Object doSemantic(Rule rule, List inputTokens, List<Range> ranges)	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < inputTokens.size(); i++)
			sb.append((i > 0 ? " " : "")+inputTokens.get(i).toString());

		String range = "";
		if (ranges.size() > 0)	{
			Token.Range startRange = (Token.Range) ranges.get(0);
			Token.Range endRange = (Token.Range) ranges.get(ranges.size() - 1);
			range = startRange.start+"-"+endRange.end;
		}
		
		String s = sb.toString();
		System.err.println("Nonterminal="+rule.getNonterminal()+", range("+range+"), Input=\""+s+"\"");
		return s;
	}
	

	public Object doSemanticForErrorRecovery(String recoverSymbol) {
		return "ERROR";
	}
}
