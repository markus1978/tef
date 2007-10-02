package fri.patterns.interpreter.parsergenerator.parsertables;

import java.util.Hashtable;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;

/**
	Parser table generator for LR interpretation.
	<p>
	The init() method is overridden, as LR parsing does not need
	FOLLOW-sets, and it needs nullability before building syntax nodes.

	@see fri.patterns.interpreter.parsergenerator.parsertables.SLRParserTables
	@author (c) 2000, Fritz Ritzberger
*/

public class LRParserTables extends SLRParserTables
{
	/** Calls super. */
	public LRParserTables(Syntax syntax)
		throws ParserBuildException
	{
		super(syntax);
	}
	
	/** Factory method: constructing a root node for LR syntax nodes. */
	protected LRSyntaxNode createStartNode(Nullable nullable, FirstSets firstSets)	{
		return new LRSyntaxNode(nullable, firstSets);
	}

	/**
		Modifiying the SLR-generation as FIRST-sets and Nullable are needed
		before building syntax nodes, FOLLOW-sets are not needed at all.
	*/
	protected void init()
		throws ParserBuildException
	{
		Nullable nullable = new Nullable(syntax, nonterminals);
		firstSets  = new FirstSets(syntax, nullable, nonterminals);

		syntaxNodes = createStartNode(nullable, firstSets).build(syntax, syntaxNodes, new Hashtable());
		
		gotoTable = generateGoto(syntaxNodes);
		
		parseTable = generateParseAction(syntaxNodes);
	}



	/** Test main dumping parser tables. */
	public static void main(String [] args)	{
		String [][] syntax = {
			{ "S", "L", "'='", "R" },
			{ "S", "R" },
			{ "L", "'*'", "R" },
			{ "L", "'id'" },
			{ "R", "L", },
		};

		try	{
			LRParserTables p = new LRParserTables(new Syntax(syntax));
			p.dump(System.err);
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}
	
}

/*
(Rule 0)  <START> : 
(Rule 1)  S : '=' R 
(Rule 2)  S : 
(Rule 3)  L : R 
(Rule 4)  L : 
(Rule 5)  R : 

FIRST(L) = ['*', 'id']
FIRST(S) = ['*', 'id']
FIRST(R) = ['*', 'id']
FIRST(<START>) = ['*', 'id']

State 0
  (Rule 0) <START> : .S  LOOKAHEAD["EoI"]	-> State 5
  (Rule 1) S : .L '=' R  LOOKAHEAD["EoI"]	-> State 4
  (Rule 2) S : .R  LOOKAHEAD["EoI"]	-> State 3
  (Rule 3) L : .'*' R  LOOKAHEAD["EoI"]	-> State 2
  (Rule 3) L : .'*' R  LOOKAHEAD['=']	-> State 2
  (Rule 4) L : .'id'  LOOKAHEAD["EoI"]	-> State 1
  (Rule 4) L : .'id'  LOOKAHEAD['=']	-> State 1
  (Rule 5) R : .L  LOOKAHEAD["EoI"]	-> State 4

State 1
  (Rule 4) L : 'id' .	['=']
  (Rule 4) L : 'id' .	["EoI"]

State 2
  (Rule 3) L : '*' .R  LOOKAHEAD['=']	-> State 6
  (Rule 3) L : '*' .R  LOOKAHEAD["EoI"]	-> State 6
  (Rule 3) L : .'*' R  LOOKAHEAD["EoI"]	-> State 2
  (Rule 3) L : .'*' R  LOOKAHEAD['=']	-> State 2
  (Rule 4) L : .'id'  LOOKAHEAD["EoI"]	-> State 1
  (Rule 4) L : .'id'  LOOKAHEAD['=']	-> State 1
  (Rule 5) R : .L  LOOKAHEAD['=']	-> State 7
  (Rule 5) R : .L  LOOKAHEAD["EoI"]	-> State 7

State 3
  (Rule 2) S : R .	["EoI"]

State 4
  (Rule 1) S : L .'=' R  LOOKAHEAD["EoI"]	-> State 8
  (Rule 5) R : L .	["EoI"]

State 5
  (Rule 0) <START> : S .	["EoI"]

State 6
  (Rule 3) L : '*' R .	['=']
  (Rule 3) L : '*' R .	["EoI"]

State 7
  (Rule 5) R : L .	["EoI"]
  (Rule 5) R : L .	['=']

State 8
  (Rule 1) S : L '=' .R  LOOKAHEAD["EoI"]	-> State 11
  (Rule 3) L : .'*' R  LOOKAHEAD["EoI"]	-> State 10
  (Rule 4) L : .'id'  LOOKAHEAD["EoI"]	-> State 9
  (Rule 5) R : .L  LOOKAHEAD["EoI"]	-> State 12

State 9
  (Rule 4) L : 'id' .	["EoI"]

State 10
  (Rule 3) L : '*' .R  LOOKAHEAD["EoI"]	-> State 13
  (Rule 3) L : .'*' R  LOOKAHEAD["EoI"]	-> State 10
  (Rule 4) L : .'id'  LOOKAHEAD["EoI"]	-> State 9
  (Rule 5) R : .L  LOOKAHEAD["EoI"]	-> State 12

State 11
  (Rule 1) S : L '=' R .	["EoI"]

State 12
  (Rule 5) R : L .	["EoI"]

State 13
  (Rule 3) L : '*' R .	["EoI"]


GOTO TABLE
==========
      |  <START>       S       L       R     '='     '*'    'id'
________________________________________________________________
    0 |        -       5       4       3       -       2       1
    1 |        -       -       -       -       -       -       -
    2 |        -       -       7       6       -       2       1
    3 |        -       -       -       -       -       -       -
    4 |        -       -       -       -       8       -       -
    5 |        -       -       -       -       -       -       -
    6 |        -       -       -       -       -       -       -
    7 |        -       -       -       -       -       -       -
    8 |        -       -      12      11       -      10       9
    9 |        -       -       -       -       -       -       -
   10 |        -       -      12      13       -      10       9
   11 |        -       -       -       -       -       -       -
   12 |        -       -       -       -       -       -       -
   13 |        -       -       -       -       -       -       -

PARSE-ACTION TABLE
==================
      |      '='     '*'    'id'   <EOF>
________________________________________
    0 |        -      SH      SH       -
    1 |        4       -       -       4
    2 |        -      SH      SH       -
    3 |        -       -       -       2
    4 |       SH       -       -       5
    5 |        -       -       -      AC
    6 |        3       -       -       3
    7 |        5       -       -       5
    8 |        -      SH      SH       -
    9 |        -       -       -       4
   10 |        -      SH      SH       -
   11 |        -       -       -       1
   12 |        -       -       -       5
   13 |        -       -       -       3

*/