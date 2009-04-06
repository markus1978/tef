/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2008, 2009 Dirk Fahland
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */

package hub.sam.tef.primitivetypes;

/**
 * DO NOT EDIT - Syntax generated from EtslActionParameter.syntax
 * at Sun Jan 18 18:21:28 CET 2009
 * by hub.sam.tef.rcc.util.SourceGenerator.
 */

import hub.sam.tef.rcc.syntax.*;

public final class EtslActionParameterSyntax extends Syntax
{
	/**
	 * @generated
	 */
	private static final long serialVersionUID = -1232299288484L;

	public static final String etsl_action_parameter = "etsl_action_parameter";
	public static final String token = "token";

	public EtslActionParameterSyntax()	{
		super(6);

		Rule rule;

		rule = new Rule(etsl_action_parameter, 2);	// 0
		rule.addRightSymbol("'$'");
		rule.addRightSymbol("_digit_LIST");
		addRule(rule);

		rule = new Rule("_digit_LIST", 2);	// 1
		rule.addRightSymbol("_digit_LIST");
		rule.addRightSymbol("_digit");
		addRule(rule);

		rule = new Rule("_digit_LIST", 1);	// 2
		rule.addRightSymbol("_digit");
		addRule(rule);

		rule = new Rule("_digit", 1);	// 3
		rule.addRightSymbol("`digit`");
		addRule(rule);

		rule = new Rule(etsl_action_parameter, 2);	// 4
		rule.addRightSymbol("'$'");
		rule.addRightSymbol("'$'");
		addRule(rule);

		rule = new Rule(token, 1);	// 5
		rule.addRightSymbol(etsl_action_parameter);
		addRule(rule);
	}
}
