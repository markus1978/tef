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

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.rcc.syntax.builder.SyntaxSeparation;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.semantics.IValuePrintSemantics;
import hub.sam.tef.tsl.ValueBinding;

import java.util.Collection;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * token representation class for parameters of action statements
 * used in ETSL action statements, the class is properly used in
 * TEF by the primitive type extension point
 * 
 * ETSL action parameters have the syntax $$ or $1, $2, $3, ...
 *  
 * @author Dirk Fahland
 */
public class EtslActionParameter extends PrimitiveTypeDescriptor {
	
	/**
	 * convert parsed text into the value that is read by the
	 * framework
	 */
	private static final IValueCreationSemantics valueCreationSemantics = new IValueCreationSemantics() {
		public Object createValue(ParseTreeNode parseTreeNode,
				IModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			String stringValue = parseTreeNode.getNodeText();
			if (stringValue.equals("")) {
				return null;
			} else {
				// strip the leading '$' and convert to integer
				String parameter = stringValue.substring(1);
				if (parameter.equals("$"))
					return new Integer(-1);
				else
					return new Integer(parameter);
			}
		}		
	};

	@Override
	public String getNonTerminalName() {
		return "ETSL_ACTION_PARAMETER";
	}

	@Override
	public String getRCCSymbol() {
		return "etsl_action_parameter";
	}
	
	@Override
	public IValueCreationSemantics getValueCreationSemantics() {
		return valueCreationSemantics;
	}
	
	private Syntax lexerSyntax = null;
	
	/**
	 * construct scanner rules from external syntax file EtslActionParamtere.syntax
	 * 
	 * TODO create java class that construct scanner rules
	 */
	private void constructScannerRules () {
		
		try {
			/*
			// read the syntax from EBNF file
			Reader syntaxInput = new InputStreamReader(EtslActionParameter.class.getResourceAsStream("EtslActionParameter.syntax"));
			
			SyntaxBuilder sb = new SyntaxBuilder(syntaxInput);
			Syntax syntax = sb.getSyntax();
			SyntaxSeparation separation = new SyntaxSeparation(syntax);
			lexerSyntax = separation.getLexerSyntax();
			*/
			Syntax syntax = new EtslActionParameterSyntax();
			SyntaxSeparation separation = new SyntaxSeparation(syntax);
			lexerSyntax = separation.getLexerSyntax();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * construct scanner rules and return array of the rules
	 */
	@Override
	protected Rule[] getAdditionalRCCRules() {
		constructScannerRules();
		
		Rule[] rules = new Rule[lexerSyntax.size()];
		for (int i=0;i<lexerSyntax.size();i++)
			rules[i] = lexerSyntax.getRule(i);
		
		return rules;
	}
	
	@Override
	public IContentAssistSemantics getContentAssistSemantics() {
		return new IContentAssistSemantics() {			
			public Collection<ContentAssistProposal> createProposals(
					ContentAssistContext context) {
				return ContentAssistProposal.createProposals(
						new String[] { "$<int>" }, context,  
						null, ContentAssistProposal.PRIMITIVE_IMAGE, ContentAssistProposal.PRIMITIVE);
			}			
		};
	}
	
	@Override
	public IValuePrintSemantics getValuePrintSemantics() {
		return new IValuePrintSemantics() {
			public boolean printValue(Object modelValue, ValueBinding binding, 
					PrettyPrintState state, PrettyPrinter printer) throws ModelCreatingException {
				if (modelValue != null && modelValue instanceof Integer) {
					Integer i = (Integer)modelValue;
					if (i == -1)
						state.append("$$");
					else
						state.append("$" + i);
					return true;
				} else {
					return false;
				}
			}					
		};
	}

	/**
	 * @return eclipse text editor rendering rule for action parameter tokens
	 */
	@Override
	public IRule getHighlightRule() {
		// construct new specific rule for specific syntax
		return new IRule() {

			private final Token fToken = new Token(new TextAttribute(new Color(Display.getCurrent(), 
					new RGB(255,46,248)), // pink-ish
					null, SWT.NORMAL));
			
			/*
			 * @see IRule#evaluate(ICharacterScanner)
			 */
			public IToken evaluate(ICharacterScanner scanner) {
				int c = scanner.read();
				if ( ((char)c) == '$' )
				{
					c = scanner.read();	// next
					if (Character.isDigit((char)c)) {
						do {
							c = scanner.read();
						} while (Character.isDigit((char) c));
						scanner.unread();
						return fToken;
					} else if ( ((char)c) == '$' ) {
						return fToken;
					}
					// else: not the correct token, step back
					scanner.unread();
				}
				// else: not the correct token, step back
				scanner.unread();
				return Token.UNDEFINED;
			}
		};
	}	
}
