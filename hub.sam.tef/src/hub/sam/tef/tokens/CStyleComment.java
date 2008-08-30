package hub.sam.tef.tokens;

import hub.sam.tef.rcc.syntax.Rule;

import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;


public class CStyleComment extends TokenDescriptor {

	@Override
	protected Rule[] getAdditionalRCCRules() {
		return new Rule[] {
				// load standard RCC C-Style comment scanner pattern
				new hub.sam.tef.rcc.syntax.Rule(new String[] {"ignored", "`cstylecomment`"})
		};
	}

	@Override
	public String getRCCSymbol() {
		return "`cstylecomment`";
	}

	@Override
	public List<IRule> getHighlightRules() {
		java.util.LinkedList<IRule> rules = new java.util.LinkedList<IRule>();

		// add rules for comments
		rules.add(new MultiLineRule("/*", "*/", new Token(new TextAttribute(
				new Color(Display.getCurrent(), new RGB(120,120,120)), null, 
				SWT.ITALIC))));
		rules.add(new EndOfLineRule("//", new Token(new TextAttribute(
				new Color(Display.getCurrent(), new RGB(120,120,120)), null, 
				SWT.ITALIC))));
		
		return rules;
	}
}
