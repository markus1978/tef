package fri.patterns.interpreter.parsergenerator.syntax.builder;

import java.util.*;
import fri.patterns.interpreter.parsergenerator.syntax.*;
import fri.patterns.interpreter.parsergenerator.parsertables.AbstractParserTables;

/**
 * DO NOT EDIT - ParserTables generated
 * at Sat Jun 12 15:21:11 CEST 2004
 * by fri.patterns.interpreter.parsergenerator.parsertables.AbstractParserTables.
 */

public final class SyntaxBuilderParserTables extends AbstractParserTables
{
	public SyntaxBuilderParserTables()	{
		syntax = new Syntax(26);
		Rule s;

		syntax.addRule(s = new Rule("<START>", 1));	// rule 0
		s.addRightSymbol("syntax");

		syntax.addRule(s = new Rule("syntax", 2));	// rule 1
		s.addRightSymbol("syntax");
		s.addRightSymbol("rule");

		syntax.addRule(s = new Rule("syntax", 1));	// rule 2
		s.addRightSymbol("rule");

		syntax.addRule(s = new Rule("set", 3));	// rule 3
		s.addRightSymbol("`bnf_chardef`");
		s.addRightSymbol("\"..\"");
		s.addRightSymbol("`bnf_chardef`");

		syntax.addRule(s = new Rule("intersectionstartunit", 1));	// rule 4
		s.addRightSymbol("set");

		syntax.addRule(s = new Rule("intersectionstartunit", 1));	// rule 5
		s.addRightSymbol("`identifier`");

		syntax.addRule(s = new Rule("intersectionstartunit", 1));	// rule 6
		s.addRightSymbol("`ruleref`");

		syntax.addRule(s = new Rule("intersectionunit", 1));	// rule 7
		s.addRightSymbol("`bnf_chardef`");

		syntax.addRule(s = new Rule("intersectionunit", 1));	// rule 8
		s.addRightSymbol("`stringdef`");

		syntax.addRule(s = new Rule("intersectionunit", 1));	// rule 9
		s.addRightSymbol("intersectionstartunit");

		syntax.addRule(s = new Rule("intersectionsubtracts", 2));	// rule 10
		s.addRightSymbol("intersectionsubtracts");
		s.addRightSymbol("intersectionsubtract");

		syntax.addRule(s = new Rule("intersectionsubtracts", 1));	// rule 11
		s.addRightSymbol("intersectionsubtract");

		syntax.addRule(s = new Rule("intersectionsubtract", 2));	// rule 12
		s.addRightSymbol("'-'");
		s.addRightSymbol("intersectionunit");

		syntax.addRule(s = new Rule("intersection", 2));	// rule 13
		s.addRightSymbol("intersectionstartunit");
		s.addRightSymbol("intersectionsubtracts");

		syntax.addRule(s = new Rule("sequnit", 1));	// rule 14
		s.addRightSymbol("intersection");

		syntax.addRule(s = new Rule("sequnit", 1));	// rule 15
		s.addRightSymbol("intersectionunit");

		syntax.addRule(s = new Rule("sequnit", 3));	// rule 16
		s.addRightSymbol("'('");
		s.addRightSymbol("unionseq");
		s.addRightSymbol("')'");

		syntax.addRule(s = new Rule("quantifiedsequnit", 2));	// rule 17
		s.addRightSymbol("sequnit");
		s.addRightSymbol("`quantifier`");

		syntax.addRule(s = new Rule("quantifiedsequnit", 1));	// rule 18
		s.addRightSymbol("sequnit");

		syntax.addRule(s = new Rule("sequence", 2));	// rule 19
		s.addRightSymbol("sequence");
		s.addRightSymbol("quantifiedsequnit");

		syntax.addRule(s = new Rule("sequence", 1));	// rule 20
		s.addRightSymbol("quantifiedsequnit");

		syntax.addRule(s = new Rule("sequence_opt", 1));	// rule 21
		s.addRightSymbol("sequence");

		syntax.addRule(s = new Rule("sequence_opt", 0));	// rule 22

		syntax.addRule(s = new Rule("unionseq", 3));	// rule 23
		s.addRightSymbol("unionseq");
		s.addRightSymbol("'|'");
		s.addRightSymbol("sequence_opt");

		syntax.addRule(s = new Rule("unionseq", 1));	// rule 24
		s.addRightSymbol("sequence_opt");

		syntax.addRule(s = new Rule("rule", 4));	// rule 25
		s.addRightSymbol("`identifier`");
		s.addRightSymbol("\"::=\"");
		s.addRightSymbol("unionseq");
		s.addRightSymbol("';'");


		loadGotoTable();
		loadParseActionTable();

		terminalsWithoutEpsilon = new ArrayList(12);
		terminalsWithoutEpsilon.add("`bnf_chardef`");
		terminalsWithoutEpsilon.add("\"..\"");
		terminalsWithoutEpsilon.add("`identifier`");
		terminalsWithoutEpsilon.add("`ruleref`");
		terminalsWithoutEpsilon.add("`stringdef`");
		terminalsWithoutEpsilon.add("'-'");
		terminalsWithoutEpsilon.add("'('");
		terminalsWithoutEpsilon.add("')'");
		terminalsWithoutEpsilon.add("`quantifier`");
		terminalsWithoutEpsilon.add("'|'");
		terminalsWithoutEpsilon.add("\"::=\"");
		terminalsWithoutEpsilon.add("';'");
	}
	private void loadGotoTable()	{
		gotoTable = new ArrayList(35);

		loadGoto_0();
		loadGoto_1();
		gotoTable.add(null);  // state 2
		loadGoto_3();
		loadGoto_4();
		gotoTable.add(null);  // state 5
		loadGoto_6();
		loadGoto_7();
		gotoTable.add(null);  // state 8
		loadGoto_9();
		loadGoto_10();
		gotoTable.add(null);  // state 11
		gotoTable.add(null);  // state 12
		loadGoto_13();
		gotoTable.add(null);  // state 14
		loadGoto_15();
		gotoTable.add(null);  // state 16
		gotoTable.add(null);  // state 17
		gotoTable.add(null);  // state 18
		gotoTable.add(null);  // state 19
		gotoTable.add(null);  // state 20
		loadGoto_21();
		loadGoto_22();
		gotoTable.add(null);  // state 23
		gotoTable.add(null);  // state 24
		loadGoto_25();
		loadGoto_26();
		gotoTable.add(null);  // state 27
		loadGoto_28();
		gotoTable.add(null);  // state 29
		gotoTable.add(null);  // state 30
		gotoTable.add(null);  // state 31
		gotoTable.add(null);  // state 32
		gotoTable.add(null);  // state 33
		gotoTable.add(null);  // state 34
	}
	private void loadGoto_0()	{
		Hashtable g = new Hashtable(3, 1);
		gotoTable.add(g);
		g.put("syntax", new Integer(3));
		g.put("`identifier`", new Integer(1));
		g.put("rule", new Integer(2));
	}
	private void loadGoto_1()	{
		Hashtable g = new Hashtable(1, 1);
		gotoTable.add(g);
		g.put("\"::=\"", new Integer(4));
	}
	private void loadGoto_3()	{
		Hashtable g = new Hashtable(2, 1);
		gotoTable.add(g);
		g.put("`identifier`", new Integer(1));
		g.put("rule", new Integer(5));
	}
	private void loadGoto_4()	{
		Hashtable g = new Hashtable(14, 1);
		gotoTable.add(g);
		g.put("`identifier`", new Integer(16));
		g.put("'('", new Integer(15));
		g.put("`ruleref`", new Integer(11));
		g.put("intersectionunit", new Integer(18));
		g.put("sequence_opt", new Integer(12));
		g.put("unionseq", new Integer(6));
		g.put("sequence", new Integer(9));
		g.put("intersection", new Integer(8));
		g.put("intersectionstartunit", new Integer(13));
		g.put("`stringdef`", new Integer(17));
		g.put("`bnf_chardef`", new Integer(7));
		g.put("sequnit", new Integer(10));
		g.put("set", new Integer(19));
		g.put("quantifiedsequnit", new Integer(14));
	}
	private void loadGoto_6()	{
		Hashtable g = new Hashtable(2, 1);
		gotoTable.add(g);
		g.put("';'", new Integer(20));
		g.put("'|'", new Integer(21));
	}
	private void loadGoto_7()	{
		Hashtable g = new Hashtable(1, 1);
		gotoTable.add(g);
		g.put("\"..\"", new Integer(22));
	}
	private void loadGoto_9()	{
		Hashtable g = new Hashtable(11, 1);
		gotoTable.add(g);
		g.put("quantifiedsequnit", new Integer(23));
		g.put("'('", new Integer(15));
		g.put("`stringdef`", new Integer(17));
		g.put("`ruleref`", new Integer(11));
		g.put("intersectionstartunit", new Integer(13));
		g.put("`identifier`", new Integer(16));
		g.put("intersection", new Integer(8));
		g.put("`bnf_chardef`", new Integer(7));
		g.put("intersectionunit", new Integer(18));
		g.put("sequnit", new Integer(10));
		g.put("set", new Integer(19));
	}
	private void loadGoto_10()	{
		Hashtable g = new Hashtable(1, 1);
		gotoTable.add(g);
		g.put("`quantifier`", new Integer(24));
	}
	private void loadGoto_13()	{
		Hashtable g = new Hashtable(3, 1);
		gotoTable.add(g);
		g.put("intersectionsubtract", new Integer(27));
		g.put("intersectionsubtracts", new Integer(25));
		g.put("'-'", new Integer(26));
	}
	private void loadGoto_15()	{
		Hashtable g = new Hashtable(14, 1);
		gotoTable.add(g);
		g.put("`identifier`", new Integer(16));
		g.put("'('", new Integer(15));
		g.put("`ruleref`", new Integer(11));
		g.put("intersectionunit", new Integer(18));
		g.put("sequence_opt", new Integer(12));
		g.put("unionseq", new Integer(28));
		g.put("sequence", new Integer(9));
		g.put("intersection", new Integer(8));
		g.put("intersectionstartunit", new Integer(13));
		g.put("`stringdef`", new Integer(17));
		g.put("`bnf_chardef`", new Integer(7));
		g.put("sequnit", new Integer(10));
		g.put("set", new Integer(19));
		g.put("quantifiedsequnit", new Integer(14));
	}
	private void loadGoto_21()	{
		Hashtable g = new Hashtable(13, 1);
		gotoTable.add(g);
		g.put("intersection", new Integer(8));
		g.put("intersectionunit", new Integer(18));
		g.put("quantifiedsequnit", new Integer(14));
		g.put("sequnit", new Integer(10));
		g.put("'('", new Integer(15));
		g.put("intersectionstartunit", new Integer(13));
		g.put("`bnf_chardef`", new Integer(7));
		g.put("set", new Integer(19));
		g.put("sequence_opt", new Integer(29));
		g.put("`stringdef`", new Integer(17));
		g.put("`identifier`", new Integer(16));
		g.put("sequence", new Integer(9));
		g.put("`ruleref`", new Integer(11));
	}
	private void loadGoto_22()	{
		Hashtable g = new Hashtable(1, 1);
		gotoTable.add(g);
		g.put("`bnf_chardef`", new Integer(30));
	}
	private void loadGoto_25()	{
		Hashtable g = new Hashtable(2, 1);
		gotoTable.add(g);
		g.put("intersectionsubtract", new Integer(31));
		g.put("'-'", new Integer(26));
	}
	private void loadGoto_26()	{
		Hashtable g = new Hashtable(7, 1);
		gotoTable.add(g);
		g.put("`identifier`", new Integer(16));
		g.put("`bnf_chardef`", new Integer(7));
		g.put("`ruleref`", new Integer(11));
		g.put("intersectionunit", new Integer(33));
		g.put("set", new Integer(19));
		g.put("intersectionstartunit", new Integer(32));
		g.put("`stringdef`", new Integer(17));
	}
	private void loadGoto_28()	{
		Hashtable g = new Hashtable(2, 1);
		gotoTable.add(g);
		g.put("')'", new Integer(34));
		g.put("'|'", new Integer(21));
	}
	private void loadParseActionTable()	{
		parseTable = new ArrayList(35);

		loadParseAction_0();
		loadParseAction_1();
		loadParseAction_2();
		loadParseAction_3();
		loadParseAction_4();
		loadParseAction_5();
		loadParseAction_6();
		loadParseAction_7();
		loadParseAction_8();
		loadParseAction_9();
		loadParseAction_10();
		loadParseAction_11();
		loadParseAction_12();
		loadParseAction_13();
		loadParseAction_14();
		loadParseAction_15();
		loadParseAction_16();
		loadParseAction_17();
		loadParseAction_18();
		loadParseAction_19();
		loadParseAction_20();
		loadParseAction_21();
		loadParseAction_22();
		loadParseAction_23();
		loadParseAction_24();
		loadParseAction_25();
		loadParseAction_26();
		loadParseAction_27();
		loadParseAction_28();
		loadParseAction_29();
		loadParseAction_30();
		loadParseAction_31();
		loadParseAction_32();
		loadParseAction_33();
		loadParseAction_34();
	}
	private void loadParseAction_0()	{
		Hashtable p = new Hashtable(1, 1);
		parseTable.add(p);
		p.put("`identifier`", new Integer(-2));
	}
	private void loadParseAction_1()	{
		Hashtable p = new Hashtable(1, 1);
		parseTable.add(p);
		p.put("\"::=\"", new Integer(-2));
	}
	private void loadParseAction_2()	{
		Hashtable p = new Hashtable(2, 1);
		parseTable.add(p);
		p.put("`identifier`", new Integer(2));
		p.put("\"EoI\"", new Integer(2));
	}
	private void loadParseAction_3()	{
		Hashtable p = new Hashtable(2, 1);
		parseTable.add(p);
		p.put("`identifier`", new Integer(-2));
		p.put("\"EoI\"", new Integer(0));
	}
	private void loadParseAction_4()	{
		Hashtable p = new Hashtable(7, 1);
		parseTable.add(p);
		p.put("'|'", new Integer(22));
		p.put("'('", new Integer(-2));
		p.put("';'", new Integer(22));
		p.put("`bnf_chardef`", new Integer(-2));
		p.put("`ruleref`", new Integer(-2));
		p.put("`identifier`", new Integer(-2));
		p.put("`stringdef`", new Integer(-2));
	}
	private void loadParseAction_5()	{
		Hashtable p = new Hashtable(2, 1);
		parseTable.add(p);
		p.put("`identifier`", new Integer(1));
		p.put("\"EoI\"", new Integer(1));
	}
	private void loadParseAction_6()	{
		Hashtable p = new Hashtable(2, 1);
		parseTable.add(p);
		p.put("';'", new Integer(-2));
		p.put("'|'", new Integer(-2));
	}
	private void loadParseAction_7()	{
		Hashtable p = new Hashtable(11, 1);
		parseTable.add(p);
		p.put("`identifier`", new Integer(7));
		p.put("'('", new Integer(7));
		p.put("`stringdef`", new Integer(7));
		p.put("`quantifier`", new Integer(7));
		p.put("`ruleref`", new Integer(7));
		p.put("'-'", new Integer(7));
		p.put("')'", new Integer(7));
		p.put("';'", new Integer(7));
		p.put("`bnf_chardef`", new Integer(7));
		p.put("'|'", new Integer(7));
		p.put("\"..\"", new Integer(-2));
	}
	private void loadParseAction_8()	{
		Hashtable p = new Hashtable(9, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(14));
		p.put("';'", new Integer(14));
		p.put("'('", new Integer(14));
		p.put("'|'", new Integer(14));
		p.put("`quantifier`", new Integer(14));
		p.put("')'", new Integer(14));
		p.put("`identifier`", new Integer(14));
		p.put("`stringdef`", new Integer(14));
		p.put("`bnf_chardef`", new Integer(14));
	}
	private void loadParseAction_9()	{
		Hashtable p = new Hashtable(8, 1);
		parseTable.add(p);
		p.put("`bnf_chardef`", new Integer(-2));
		p.put("`ruleref`", new Integer(-2));
		p.put("'|'", new Integer(21));
		p.put("')'", new Integer(21));
		p.put("'('", new Integer(-2));
		p.put("';'", new Integer(21));
		p.put("`stringdef`", new Integer(-2));
		p.put("`identifier`", new Integer(-2));
	}
	private void loadParseAction_10()	{
		Hashtable p = new Hashtable(9, 1);
		parseTable.add(p);
		p.put("`identifier`", new Integer(18));
		p.put("'('", new Integer(18));
		p.put("`stringdef`", new Integer(18));
		p.put("`quantifier`", new Integer(-2));
		p.put("`ruleref`", new Integer(18));
		p.put("')'", new Integer(18));
		p.put("';'", new Integer(18));
		p.put("`bnf_chardef`", new Integer(18));
		p.put("'|'", new Integer(18));
	}
	private void loadParseAction_11()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(6));
		p.put("';'", new Integer(6));
		p.put("'('", new Integer(6));
		p.put("'|'", new Integer(6));
		p.put("`quantifier`", new Integer(6));
		p.put("')'", new Integer(6));
		p.put("`identifier`", new Integer(6));
		p.put("`stringdef`", new Integer(6));
		p.put("'-'", new Integer(6));
		p.put("`bnf_chardef`", new Integer(6));
	}
	private void loadParseAction_12()	{
		Hashtable p = new Hashtable(3, 1);
		parseTable.add(p);
		p.put("')'", new Integer(24));
		p.put("';'", new Integer(24));
		p.put("'|'", new Integer(24));
	}
	private void loadParseAction_13()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("';'", new Integer(9));
		p.put("')'", new Integer(9));
		p.put("`stringdef`", new Integer(9));
		p.put("`identifier`", new Integer(9));
		p.put("`bnf_chardef`", new Integer(9));
		p.put("`quantifier`", new Integer(9));
		p.put("'-'", new Integer(-2));
		p.put("`ruleref`", new Integer(9));
		p.put("'|'", new Integer(9));
		p.put("'('", new Integer(9));
	}
	private void loadParseAction_14()	{
		Hashtable p = new Hashtable(8, 1);
		parseTable.add(p);
		p.put("';'", new Integer(20));
		p.put("`ruleref`", new Integer(20));
		p.put("'|'", new Integer(20));
		p.put("'('", new Integer(20));
		p.put("')'", new Integer(20));
		p.put("`identifier`", new Integer(20));
		p.put("`bnf_chardef`", new Integer(20));
		p.put("`stringdef`", new Integer(20));
	}
	private void loadParseAction_15()	{
		Hashtable p = new Hashtable(7, 1);
		parseTable.add(p);
		p.put("')'", new Integer(22));
		p.put("'|'", new Integer(22));
		p.put("'('", new Integer(-2));
		p.put("`bnf_chardef`", new Integer(-2));
		p.put("`ruleref`", new Integer(-2));
		p.put("`identifier`", new Integer(-2));
		p.put("`stringdef`", new Integer(-2));
	}
	private void loadParseAction_16()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(5));
		p.put("';'", new Integer(5));
		p.put("'('", new Integer(5));
		p.put("'|'", new Integer(5));
		p.put("`quantifier`", new Integer(5));
		p.put("')'", new Integer(5));
		p.put("`identifier`", new Integer(5));
		p.put("`stringdef`", new Integer(5));
		p.put("'-'", new Integer(5));
		p.put("`bnf_chardef`", new Integer(5));
	}
	private void loadParseAction_17()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(8));
		p.put("';'", new Integer(8));
		p.put("'('", new Integer(8));
		p.put("'|'", new Integer(8));
		p.put("`quantifier`", new Integer(8));
		p.put("')'", new Integer(8));
		p.put("`identifier`", new Integer(8));
		p.put("`stringdef`", new Integer(8));
		p.put("'-'", new Integer(8));
		p.put("`bnf_chardef`", new Integer(8));
	}
	private void loadParseAction_18()	{
		Hashtable p = new Hashtable(9, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(15));
		p.put("';'", new Integer(15));
		p.put("'('", new Integer(15));
		p.put("'|'", new Integer(15));
		p.put("`quantifier`", new Integer(15));
		p.put("')'", new Integer(15));
		p.put("`identifier`", new Integer(15));
		p.put("`stringdef`", new Integer(15));
		p.put("`bnf_chardef`", new Integer(15));
	}
	private void loadParseAction_19()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(4));
		p.put("';'", new Integer(4));
		p.put("'('", new Integer(4));
		p.put("'|'", new Integer(4));
		p.put("`quantifier`", new Integer(4));
		p.put("')'", new Integer(4));
		p.put("`identifier`", new Integer(4));
		p.put("`stringdef`", new Integer(4));
		p.put("'-'", new Integer(4));
		p.put("`bnf_chardef`", new Integer(4));
	}
	private void loadParseAction_20()	{
		Hashtable p = new Hashtable(2, 1);
		parseTable.add(p);
		p.put("`identifier`", new Integer(25));
		p.put("\"EoI\"", new Integer(25));
	}
	private void loadParseAction_21()	{
		Hashtable p = new Hashtable(8, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(-2));
		p.put("'|'", new Integer(22));
		p.put("';'", new Integer(22));
		p.put("`stringdef`", new Integer(-2));
		p.put("')'", new Integer(22));
		p.put("`bnf_chardef`", new Integer(-2));
		p.put("`identifier`", new Integer(-2));
		p.put("'('", new Integer(-2));
	}
	private void loadParseAction_22()	{
		Hashtable p = new Hashtable(1, 1);
		parseTable.add(p);
		p.put("`bnf_chardef`", new Integer(-2));
	}
	private void loadParseAction_23()	{
		Hashtable p = new Hashtable(8, 1);
		parseTable.add(p);
		p.put("';'", new Integer(19));
		p.put("`ruleref`", new Integer(19));
		p.put("'|'", new Integer(19));
		p.put("'('", new Integer(19));
		p.put("')'", new Integer(19));
		p.put("`identifier`", new Integer(19));
		p.put("`bnf_chardef`", new Integer(19));
		p.put("`stringdef`", new Integer(19));
	}
	private void loadParseAction_24()	{
		Hashtable p = new Hashtable(8, 1);
		parseTable.add(p);
		p.put("';'", new Integer(17));
		p.put("`ruleref`", new Integer(17));
		p.put("'|'", new Integer(17));
		p.put("'('", new Integer(17));
		p.put("')'", new Integer(17));
		p.put("`identifier`", new Integer(17));
		p.put("`bnf_chardef`", new Integer(17));
		p.put("`stringdef`", new Integer(17));
	}
	private void loadParseAction_25()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`identifier`", new Integer(13));
		p.put("')'", new Integer(13));
		p.put("'('", new Integer(13));
		p.put("`quantifier`", new Integer(13));
		p.put("`ruleref`", new Integer(13));
		p.put("'|'", new Integer(13));
		p.put("';'", new Integer(13));
		p.put("`stringdef`", new Integer(13));
		p.put("`bnf_chardef`", new Integer(13));
		p.put("'-'", new Integer(-2));
	}
	private void loadParseAction_26()	{
		Hashtable p = new Hashtable(4, 1);
		parseTable.add(p);
		p.put("`stringdef`", new Integer(-2));
		p.put("`ruleref`", new Integer(-2));
		p.put("`identifier`", new Integer(-2));
		p.put("`bnf_chardef`", new Integer(-2));
	}
	private void loadParseAction_27()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(11));
		p.put("';'", new Integer(11));
		p.put("'('", new Integer(11));
		p.put("'|'", new Integer(11));
		p.put("`quantifier`", new Integer(11));
		p.put("')'", new Integer(11));
		p.put("`identifier`", new Integer(11));
		p.put("`stringdef`", new Integer(11));
		p.put("'-'", new Integer(11));
		p.put("`bnf_chardef`", new Integer(11));
	}
	private void loadParseAction_28()	{
		Hashtable p = new Hashtable(2, 1);
		parseTable.add(p);
		p.put("')'", new Integer(-2));
		p.put("'|'", new Integer(-2));
	}
	private void loadParseAction_29()	{
		Hashtable p = new Hashtable(3, 1);
		parseTable.add(p);
		p.put("')'", new Integer(23));
		p.put("';'", new Integer(23));
		p.put("'|'", new Integer(23));
	}
	private void loadParseAction_30()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(3));
		p.put("';'", new Integer(3));
		p.put("'('", new Integer(3));
		p.put("'|'", new Integer(3));
		p.put("`quantifier`", new Integer(3));
		p.put("')'", new Integer(3));
		p.put("`identifier`", new Integer(3));
		p.put("`stringdef`", new Integer(3));
		p.put("'-'", new Integer(3));
		p.put("`bnf_chardef`", new Integer(3));
	}
	private void loadParseAction_31()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(10));
		p.put("';'", new Integer(10));
		p.put("'('", new Integer(10));
		p.put("'|'", new Integer(10));
		p.put("`quantifier`", new Integer(10));
		p.put("')'", new Integer(10));
		p.put("`identifier`", new Integer(10));
		p.put("`stringdef`", new Integer(10));
		p.put("'-'", new Integer(10));
		p.put("`bnf_chardef`", new Integer(10));
	}
	private void loadParseAction_32()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(9));
		p.put("';'", new Integer(9));
		p.put("'('", new Integer(9));
		p.put("'|'", new Integer(9));
		p.put("`quantifier`", new Integer(9));
		p.put("')'", new Integer(9));
		p.put("`identifier`", new Integer(9));
		p.put("`stringdef`", new Integer(9));
		p.put("'-'", new Integer(9));
		p.put("`bnf_chardef`", new Integer(9));
	}
	private void loadParseAction_33()	{
		Hashtable p = new Hashtable(10, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(12));
		p.put("';'", new Integer(12));
		p.put("'('", new Integer(12));
		p.put("'|'", new Integer(12));
		p.put("`quantifier`", new Integer(12));
		p.put("')'", new Integer(12));
		p.put("`identifier`", new Integer(12));
		p.put("`stringdef`", new Integer(12));
		p.put("'-'", new Integer(12));
		p.put("`bnf_chardef`", new Integer(12));
	}
	private void loadParseAction_34()	{
		Hashtable p = new Hashtable(9, 1);
		parseTable.add(p);
		p.put("`ruleref`", new Integer(16));
		p.put("';'", new Integer(16));
		p.put("'('", new Integer(16));
		p.put("'|'", new Integer(16));
		p.put("`quantifier`", new Integer(16));
		p.put("')'", new Integer(16));
		p.put("`identifier`", new Integer(16));
		p.put("`stringdef`", new Integer(16));
		p.put("`bnf_chardef`", new Integer(16));
	}
}