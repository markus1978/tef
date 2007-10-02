package fri.patterns.interpreter.parsergenerator.util;

import java.io.File;
import java.util.*;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.syntax.*;
import fri.patterns.interpreter.parsergenerator.syntax.builder.*;

/**
	SyntaxChecker checks a EBNF syntax (file) for following things:
	<ul>
		<li>unresolved nonterminals (nonterminals without rule)</li>
		<li>singular rules (nonterminal can be substituted by its singular right symbol)</li>
		<li>isolated rules (redundant, can be removed)</li>
		<li>None or more than one toplevel rule</li>
	</ul>
	<pre>
	SYNTAX: java fri.patterns.interpreter.parsergenerator.util.SyntaxChecker file.syntax [file.syntax ...]
	</pre>

	@author (c) 2000, Fritz Ritzberger
*/

public class SyntaxChecker
{
	private boolean diagnosis = true;
	
	public SyntaxChecker(Object syntaxFile)
		throws Exception
	{
		this(new SyntaxBuilder(syntaxFile).getSyntax());
	}

	public SyntaxChecker(Syntax syntax)	{
		if (syntax.size() <= 0)	{
			System.out.println("ERROR: Found no rules in syntax!");
			diagnosis = false;
			return;
		}
		
		System.out.println("Number of rules (after resolving parenthesis, alternations and wildcards): "+syntax.size());
		
		// Find start rule(s)
		List topLevelRules = syntax.findStartRules();
		if (topLevelRules.size() > 1)	{
			System.out.println("WARNING: More than one toplevel rules:");
			for (int i = 0; i < topLevelRules.size(); i++)
				System.out.println("	"+topLevelRules.get(i));
		}
		else
		if (topLevelRules.size() < 1)	{
			System.out.println("WARNING: Found no toplevel rule, first rule (default START rule) is: "+syntax.getRule(0));
		}
		else	{
			System.out.println("Start rule is \""+topLevelRules.get(0)+"\"");
		}
		
		// check for unresolved nonterminals
		Set unresolved = syntax.getUnresolvedNonterminals();
		if (unresolved.size() > 0)	{
			System.out.println("Found "+unresolved.size()+" unresolved nonterminals:");
			diagnosis = false;
			for (Iterator it = unresolved.iterator(); it.hasNext(); )
				System.out.println("	"+it.next());
		}
		else	{
			System.out.println("Found no unresolved nonterminals.");
		}
		
		// check for isolated rules
		for (int i = syntax.size() - 1; i >= 0; i--)	{
			Rule rule = syntax.getRule(i);
			
			boolean found = topLevelRules.contains(rule) ||
					rule.getNonterminal().equals(Token.TOKEN) ||
					rule.getNonterminal().equals(Token.IGNORED);

			for (int j = 0; found == false && j < syntax.size(); j++)	{
				if (j != i)	{
					Rule rule2 = syntax.getRule(j);
					for (int k = 0; found == false && k < rule2.rightSize(); k++)
						if (rule2.getRightSymbol(k).equals(rule.getNonterminal()))
							found = true;
				}
			}
			
			if (found == false)
				System.out.println("WARNING: Found isolated (unused, redundant) rule: "+rule);
		}

		// check for singular rules
		int singulars = 0;
		for (int i = syntax.size() - 1; i >= 0; i--)	{
			Rule rule = syntax.getRule(i);
			boolean singular = (rule.rightSize() == 1 && topLevelRules.contains(rule) == false);	// has only one symbol on right side

			// check if defined only once on any left side
			for (int j = 0; singular && j < syntax.size(); j++)
				if (j != i && syntax.getRule(j).getNonterminal().equals(rule.getNonterminal()))
					singular = false;	// nonterm has been found once more on left side
			
			if (singular)	{
				System.out.println("INFO: Found singular rule (nonterminal could be substituted by its right symbol): "+rule);
				singulars++;
			}
		}
		System.out.println("Found "+singulars+" singular rules.");
	}


	/** Returns false when the checked syntax is not able to be used as lexer or parser configuration. */
	public boolean getDiagnosis()	{
		return diagnosis;
	}


	public static void main(String [] args)	{
		if (args.length <= 0)	{
			System.err.println("SYNTAX: java "+SyntaxChecker.class.getName()+" file.syntax [file.syntax ...]");
			System.err.println("	Prints out a diagnosis of passed syntax file(s).");
			System.exit(2);
		}
		
		boolean ok = true;
		for (int i = 0; i < args.length; i++)	{
			try	{
				SyntaxChecker checker = new SyntaxChecker(new File(args[i]));
				ok = ok && checker.getDiagnosis();
			}
			catch (Exception e)	{
				ok = false;
				e.printStackTrace();
			}
		}
		
		System.exit(ok ? 0 : 1);
	}

}
