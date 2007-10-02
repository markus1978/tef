package fri.patterns.interpreter.parsergenerator.parsertables;

import fri.patterns.interpreter.parsergenerator.syntax.Syntax;

/**
	Parser table generator for LALR interpretation.

	@see fri.patterns.interpreter.parsergenerator.parsertables.LRParserTables
	@author (c) 2000, Fritz Ritzberger
*/

public class LALRParserTables extends LRParserTables
{
	/** Calls super. */
	public LALRParserTables(Syntax syntax)
		throws ParserBuildException
	{
		super(syntax);
	}
	
	/** Factory method: constructing a root node for LALR syntax nodes. */
	protected LRSyntaxNode createStartNode(Nullable nullable, FirstSets firstSets)	{
		return new LALRSyntaxNode(nullable, firstSets);
	}


	/** Test main dumping parser tables. */
	public static void main(String [] args)	{
		/*
		String [][] syntax = {
			{ "EXPR", "TERM" },
			{ "EXPR", "EXPR", "'+'", "TERM" },
			{ "EXPR", "EXPR", "'-'", "TERM" },
			{ "TERM", "FAKT", },
			{ "TERM", "TERM", "'*'", "FAKT" },
			{ "TERM", "TERM", "'/'", "FAKT" },
			{ "FAKT", "\"[0-9]+\"", },
			{ "FAKT", "'('", "EXPR", "')'" },
		};
		*/
		String [][] syntax = {
			{ "S", "L", "'='", "R" },
			{ "S", "R" },
			{ "L", "'*'", "R" },
			{ "L", "'id'" },
			{ "R", "L", },
		};

		try	{
			LALRParserTables p = new LALRParserTables(new Syntax(syntax));
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
  (Rule 3) L : .'*' R  LOOKAHEAD['=', "EoI"]	-> State 2
  (Rule 4) L : .'id'  LOOKAHEAD['=', "EoI"]	-> State 1
  (Rule 5) R : .L  LOOKAHEAD["EoI"]	-> State 4

State 1
  (Rule 4) L : 'id' .	['=', "EoI"]

State 2
  (Rule 3) L : '*' .R  LOOKAHEAD['=', "EoI"]	-> State 6
  (Rule 3) L : .'*' R  LOOKAHEAD['=', "EoI"]	-> State 2
  (Rule 4) L : .'id'  LOOKAHEAD['=', "EoI"]	-> State 1
  (Rule 5) R : .L  LOOKAHEAD['=', "EoI"]	-> State 7

State 3
  (Rule 2) S : R .	["EoI"]

State 4
  (Rule 1) S : L .'=' R  LOOKAHEAD["EoI"]	-> State 8
  (Rule 5) R : L .	["EoI"]

State 5
  (Rule 0) <START> : S .	["EoI"]

State 6
  (Rule 3) L : '*' R .	['=', "EoI"]

State 7
  (Rule 5) R : L .	['=', "EoI"]

State 8
  (Rule 1) S : L '=' .R  LOOKAHEAD["EoI"]	-> State 9
  (Rule 3) L : .'*' R  LOOKAHEAD["EoI"]	-> State 2
  (Rule 4) L : .'id'  LOOKAHEAD["EoI"]	-> State 1
  (Rule 5) R : .L  LOOKAHEAD["EoI"]	-> State 7

State 9
  (Rule 1) S : L '=' R .	["EoI"]


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
    8 |        -       -       7       9       -       2       1
    9 |        -       -       -       -       -       -       -

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
    9 |        -       -       -       1

*/



/*
(Rule 0)  <START> : EXPR 
(Rule 1)  EXPR : TERM 
(Rule 2)  EXPR : EXPR '+' TERM 
(Rule 3)  EXPR : EXPR '-' TERM 
(Rule 4)  TERM : FAKT 
(Rule 5)  TERM : TERM '*' FAKT 
(Rule 6)  TERM : TERM '/' FAKT 
(Rule 7)  FAKT : "[0-9]+" 
(Rule 8)  FAKT : '(' EXPR ')' 

FIRST(EXPR) = ["[0-9]+", '(']
FIRST(FAKT) = ["[0-9]+", '(']
FIRST(<START>) = ["[0-9]+", '(']
FIRST(TERM) = ["[0-9]+", '(']

State 0
  (Rule 0) <START> : .EXPR  LOOKAHEAD["EoI"]	-> State 2
  (Rule 1) EXPR : .TERM  LOOKAHEAD['+', '-', "EoI"]	-> State 1
  (Rule 2) EXPR : .EXPR '+' TERM  LOOKAHEAD['+', '-', "EoI"]	-> State 2
  (Rule 3) EXPR : .EXPR '-' TERM  LOOKAHEAD['+', '-', "EoI"]	-> State 2
  (Rule 4) TERM : .FAKT  LOOKAHEAD['+', '-', '/', '*', "EoI"]	-> State 4
  (Rule 5) TERM : .TERM '*' FAKT  LOOKAHEAD['+', '-', '/', '*', "EoI"]	-> State 1
  (Rule 6) TERM : .TERM '/' FAKT  LOOKAHEAD['+', '-', '/', '*', "EoI"]	-> State 1
  (Rule 7) FAKT : ."[0-9]+"  LOOKAHEAD['+', '-', '/', '*', "EoI"]	-> State 5
  (Rule 8) FAKT : .'(' EXPR ')'  LOOKAHEAD['+', '-', '/', '*', "EoI"]	-> State 3

State 1
  (Rule 1) EXPR : TERM .	['+', '-', ')', "EoI"]
  (Rule 5) TERM : TERM .'*' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 7
  (Rule 6) TERM : TERM .'/' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 6

State 2
  (Rule 0) <START> : EXPR .	["EoI"]
  (Rule 2) EXPR : EXPR .'+' TERM  LOOKAHEAD['+', '-', "EoI"]	-> State 9
  (Rule 3) EXPR : EXPR .'-' TERM  LOOKAHEAD['+', '-', "EoI"]	-> State 8

State 3
  (Rule 1) EXPR : .TERM  LOOKAHEAD['+', '-', ')']	-> State 1
  (Rule 2) EXPR : .EXPR '+' TERM  LOOKAHEAD['+', '-', ')']	-> State 10
  (Rule 3) EXPR : .EXPR '-' TERM  LOOKAHEAD['+', '-', ')']	-> State 10
  (Rule 4) TERM : .FAKT  LOOKAHEAD['+', '-', ')', '/', '*']	-> State 4
  (Rule 5) TERM : .TERM '*' FAKT  LOOKAHEAD['+', '-', ')', '/', '*']	-> State 1
  (Rule 6) TERM : .TERM '/' FAKT  LOOKAHEAD['+', '-', ')', '/', '*']	-> State 1
  (Rule 7) FAKT : ."[0-9]+"  LOOKAHEAD['+', '-', ')', '/', '*']	-> State 5
  (Rule 8) FAKT : '(' .EXPR ')'  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 10
  (Rule 8) FAKT : .'(' EXPR ')'  LOOKAHEAD['+', '-', ')', '/', '*']	-> State 3

State 4
  (Rule 4) TERM : FAKT .	['+', '-', ')', '/', '*', "EoI"]

State 5
  (Rule 7) FAKT : "[0-9]+" .	['+', '-', ')', '/', '*', "EoI"]

State 6
  (Rule 6) TERM : TERM '/' .FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 11
  (Rule 7) FAKT : ."[0-9]+"  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 5
  (Rule 8) FAKT : .'(' EXPR ')'  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 3

State 7
  (Rule 5) TERM : TERM '*' .FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 12
  (Rule 7) FAKT : ."[0-9]+"  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 5
  (Rule 8) FAKT : .'(' EXPR ')'  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 3

State 8
  (Rule 3) EXPR : EXPR '-' .TERM  LOOKAHEAD['+', '-', ')', "EoI"]	-> State 13
  (Rule 4) TERM : .FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 4
  (Rule 5) TERM : .TERM '*' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 13
  (Rule 6) TERM : .TERM '/' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 13
  (Rule 7) FAKT : ."[0-9]+"  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 5
  (Rule 8) FAKT : .'(' EXPR ')'  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 3

State 9
  (Rule 2) EXPR : EXPR '+' .TERM  LOOKAHEAD['+', '-', ')', "EoI"]	-> State 14
  (Rule 4) TERM : .FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 4
  (Rule 5) TERM : .TERM '*' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 14
  (Rule 6) TERM : .TERM '/' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 14
  (Rule 7) FAKT : ."[0-9]+"  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 5
  (Rule 8) FAKT : .'(' EXPR ')'  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 3

State 10
  (Rule 2) EXPR : EXPR .'+' TERM  LOOKAHEAD['+', '-', ')']	-> State 9
  (Rule 3) EXPR : EXPR .'-' TERM  LOOKAHEAD['+', '-', ')']	-> State 8
  (Rule 8) FAKT : '(' EXPR .')'  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 15

State 11
  (Rule 6) TERM : TERM '/' FAKT .	['+', '-', ')', '/', '*', "EoI"]

State 12
  (Rule 5) TERM : TERM '*' FAKT .	['+', '-', ')', '/', '*', "EoI"]

State 13
  (Rule 3) EXPR : EXPR '-' TERM .	['+', '-', ')', "EoI"]
  (Rule 5) TERM : TERM .'*' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 7
  (Rule 6) TERM : TERM .'/' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 6

State 14
  (Rule 2) EXPR : EXPR '+' TERM .	['+', '-', ')', "EoI"]
  (Rule 5) TERM : TERM .'*' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 7
  (Rule 6) TERM : TERM .'/' FAKT  LOOKAHEAD['+', '-', ')', '/', '*', "EoI"]	-> State 6

State 15
  (Rule 8) FAKT : '(' EXPR ')' .	['+', '-', ')', '/', '*', "EoI"]


GOTO TABLE
==========
      |  <START>    EXPR    TERM    FAKT     '+'     '-'     '*'     '/' "[0-9]+     '('     ')'
________________________________________________________________________________________________
    0 |        -       2       1       4       -       -       -       -       5       3       -
    1 |        -       -       -       -       -       -       7       6       -       -       -
    2 |        -       -       -       -       9       8       -       -       -       -       -
    3 |        -      10       1       4       -       -       -       -       5       3       -
    4 |        -       -       -       -       -       -       -       -       -       -       -
    5 |        -       -       -       -       -       -       -       -       -       -       -
    6 |        -       -       -      11       -       -       -       -       5       3       -
    7 |        -       -       -      12       -       -       -       -       5       3       -
    8 |        -       -      13       4       -       -       -       -       5       3       -
    9 |        -       -      14       4       -       -       -       -       5       3       -
   10 |        -       -       -       -       9       8       -       -       -       -      15
   11 |        -       -       -       -       -       -       -       -       -       -       -
   12 |        -       -       -       -       -       -       -       -       -       -       -
   13 |        -       -       -       -       -       -       7       6       -       -       -
   14 |        -       -       -       -       -       -       7       6       -       -       -
   15 |        -       -       -       -       -       -       -       -       -       -       -

PARSE-ACTION TABLE
==================
      |      '+'     '-'     '*'     '/' "[0-9]+     '('     ')'   <EOF>
________________________________________________________________________
    0 |        -       -       -       -      SH      SH       -       -
    1 |        1       1      SH      SH       -       -       1       1
    2 |       SH      SH       -       -       -       -       -      AC
    3 |        -       -       -       -      SH      SH       -       -
    4 |        4       4       4       4       -       -       4       4
    5 |        7       7       7       7       -       -       7       7
    6 |        -       -       -       -      SH      SH       -       -
    7 |        -       -       -       -      SH      SH       -       -
    8 |        -       -       -       -      SH      SH       -       -
    9 |        -       -       -       -      SH      SH       -       -
   10 |       SH      SH       -       -       -       -      SH       -
   11 |        6       6       6       6       -       -       6       6
   12 |        5       5       5       5       -       -       5       5
   13 |        3       3      SH      SH       -       -       3       3
   14 |        2       2      SH      SH       -       -       2       2
   15 |        8       8       8       8       -       -       8       8

*/