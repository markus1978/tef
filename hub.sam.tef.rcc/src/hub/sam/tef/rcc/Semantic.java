package hub.sam.tef.rcc;

import hub.sam.tef.rcc.Token.Range;
import hub.sam.tef.rcc.syntax.Rule;

import java.util.List;

/**
	A semantic processes parsed input from the Parser. It receives the evaluated Rule,
	a List of Objects representing the parse results from the right side of the Rule,
	and the character positions for those Objects.
	Whenever a rule was reduced by the Parser, it calls this interface (when not null).
	
	@see hub.sam.tef.rcc.semantics.PrintSemantic
	@see hub.sam.tef.rcc.semantics.ReflectSemantic
	@see hub.sam.tef.rcc.semantics.TreeBuilderSemantic
	@author (c) 2000, Fritz Ritzberger
*/
	
public interface Semantic {
	/**
		Called by every REDUCE step. Passes the evaluated Rule and the corresponding parsing results.
		@param rule Rule that was "reduced" (recognized).
		@param parseResults all semantic call returns from underlying rules, collected according to current rule,
				that means you get a List of Objects as long as the count of symbols on the right side of the rule,
				every Object is a return of an underlying doSemantic() call. 
		@param resultRanges all line ranges for parseResults elements. Cast elements to Token.Range
				to get the start and end position of every Object in parseResult List.
		@return some result to be pushed on value stack by the Parser, or null.
	*/
	public Object doSemantic(Rule rule, List parseResults, List<Range> resultRanges);
	
	public Object doSemanticForErrorRecovery(String recoverSymbol);

}
