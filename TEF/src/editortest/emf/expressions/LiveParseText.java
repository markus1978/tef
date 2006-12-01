package editortest.emf.expressions;

import java.util.Collection;

import hub.sam.tef.controllers.ITextEventListener;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.liveparser.Parser;
import hub.sam.tef.liveparser.Scanner;
import hub.sam.tef.liveparser.SyntaxRule;
import hub.sam.tef.views.ChangeText;
import hub.sam.tef.views.Text;

public class LiveParseText extends ChangeText {

	private StringBuffer content;
	
	private final Collection<SyntaxRule> fRules;
	private final Object fStartSymbol;
	private final Scanner fScanner;
		
	public LiveParseText(Collection<SyntaxRule> rules, Object startSymbol) {
		fRules = rules;
		fStartSymbol = startSymbol;
		fScanner = new Scanner(Scanner.getTokensFromRules(fRules));
		content = new StringBuffer("");
		setText("");
		
		addElement(ITextEventListener.class, new ITextEventListener() {
			public boolean handleEvent(Text text, TextEvent event) {
				content.replace(event.getBegin(), event.getEnd(), event.getText());
				setText(content.toString());
				update();
				return true;
			}
			public boolean verifyEvent(Text text, TextEvent event) {
				Parser parser = new Parser(fRules, fStartSymbol);
				StringBuffer tryContent = new StringBuffer(content.toString());
				tryContent.replace(event.getBegin(), event.getEnd(), event.getText());
				fScanner.setStringToScann(tryContent.toString());
				if (parser.parser(fScanner)) {
					return true;
				} else {
					return false;
				}
			}			
		});
	}

	@Override
	public void setText(String text) {
		Parser parser = new Parser(fRules, fStartSymbol);
		fScanner.setStringToScann(text);
		parser.parser(fScanner);
		super.setText(text);
	}
}
