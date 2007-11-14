package hub.sam.tef.editor;

import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.Syntax;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class TokenScanner extends RuleBasedScanner {

	public TokenScanner(Syntax syntax) {
		super();		
		configure(syntax);
	}

	private void configure(Syntax syntax) {
		List<IRule> rules = new Vector<IRule>();
		
		// add a rule for each keyword
		Iterator<EObject> it = syntax.eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof FixTerminal) {
				String terminal = ((FixTerminal)next).getTerminal();
				if (terminal.matches("[a-zA-Z]*")) {
					IToken token = new Token(new TextAttribute(
							new Color(Display.getCurrent(), new RGB(120,120,0)), null, 
							SWT.BOLD));
					WordRule rule = new WordRule(new IWordDetector() {
						public boolean isWordPart(char c) {
							return Character.isLetter(c);
						}

						public boolean isWordStart(char c) {
							return Character.isLetter(c);
						}				
					});
					rule.addWord(terminal, token);
					rules.add(rule);
				}					
			}
		}	
		
		// add the rules taken from primitive types
		for(PrimitiveTypeDescriptor primitiveType: 
				PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
			IRule rule = primitiveType.getHighlightRule();
			if (rule != null) {
				rules.add(rule);
			}
		}
		setRules(rules.toArray(new IRule[]{}));
	}
}
