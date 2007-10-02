package fri.patterns.interpreter.parsergenerator.lexer.semantics;

import java.util.*;
import java.lang.reflect.Method;
import fri.patterns.interpreter.parsergenerator.lexer.LexerSemantic;
import fri.patterns.interpreter.parsergenerator.lexer.ResultTree;
import fri.patterns.interpreter.parsergenerator.syntax.Rule;

/**
 * A LexerSemantic that provides the Set of wanted String nonterminals
 * by method reflection. Callback methods must be of the form
 * <pre>
 * 	public void EncodingDecl(ResultTree resultTree)	{
 * 		this.encodingDecl = resultTree.toString();
 * 	}
 * </pre>
 * 
 * Created on 21.09.2005
 * @author Fritz Ritzberger
 */
public abstract class LexerReflectSemantic implements LexerSemantic
{
	/**
	 * As expected, this method delegates to the method that is named like the
	 * nonterminal of the passed Rule, with <i>resultTree</i> as the only argument.
	 */
	public void ruleEvaluated(Rule rule, ResultTree resultTree)	{
		try	{
			Method m = getClass().getMethod(rule.getNonterminal(), new Class[] { ResultTree.class });
			m.setAccessible(true);
			m.invoke(this, new Object[] { resultTree });
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

	/**
	 * Provides the Set of wanted nonterminal Strings by searching for
	 * public void methods with (String, Token.Range) arguments.
	 */
	public Set getWantedNonterminals() {
		Method [] methods = getClass().getMethods();
		Set set = new HashSet(methods.length);

		for (int i = 0; i < methods.length; i++)	{
			Method m = methods[i];
			Class [] argClasses = m.getParameterTypes();

			if (m.getReturnType().equals(void.class) && argClasses.length == 1 && argClasses[0].equals(ResultTree.class))	{
				String name = m.getName();
				set.add(name);
			}
		}
		return set;
	}

	/**
	 * Returns null as getWantedNonterminals() is provided.
	 */
	public Set getIgnoredNonterminals() {
		return null;
	}

}
