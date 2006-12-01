package editortest.emf.expressions.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.ITextEventListener;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.liveparser.ASTNode;
import hub.sam.tef.liveparser.FixToken;
import hub.sam.tef.liveparser.Parser;
import hub.sam.tef.liveparser.RegexpToken;
import hub.sam.tef.liveparser.Scanner;
import hub.sam.tef.liveparser.SymbolASTNode;
import hub.sam.tef.liveparser.SymbolRule;
import hub.sam.tef.liveparser.SyntaxRule;
import hub.sam.tef.liveparser.TerminalASTNode;
import hub.sam.tef.liveparser.TokenRule;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.IValueChangeListener;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.views.ChangeText;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.Text;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.ui.internal.IChangeListener;

public class ExpressionTemplate extends ChoiceTemplate<IModelElement> {	
	private final Scanner fScanner;
	
	private static final String OBRACE = "obrace";
	private static final String CBRACE = "cbrace";
	private static final String EXPR = "expr";
	private static final String PLUS = "plus";
	private static final String TIMES = "times";
	private static final String ID = "id";

	public static final Collection<SyntaxRule> fRules = Arrays.asList(new SyntaxRule[] {
			new SymbolRule(EXPR, new Object[] {OBRACE, EXPR, CBRACE}, "Parenthesis", new String[] {null, "subexpression", null}),
			new SymbolRule(EXPR, new Object[] {EXPR, PLUS, EXPR}, "Plus", new String[] {"operand1", null, "operand2"}),
			new SymbolRule(EXPR, new Object[] {EXPR, TIMES, EXPR}, "Times", new String[] {"operand1", null, "operand2"}),
			new SymbolRule(EXPR, new Object[] {ID}, "Identifier", new String[] {"id"}),
			
			new TokenRule(ID, new RegexpToken("[a-zA-Z0-9_]+")),
			new TokenRule(OBRACE, new FixToken("(")),
			new TokenRule(CBRACE, new FixToken(")")),
			new TokenRule(PLUS, new FixToken("+")),
			new TokenRule(TIMES, new FixToken("*")),
	});
	
	public static final Object fStartSymbol = EXPR; 
	
	public ExpressionTemplate(Template template) {
		super(template);	
		fScanner = new Scanner(Scanner.getTokensFromRules(fRules));
	}

	@Override
	public ValueTemplate<? extends IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new IdentifierTemplate(this),
				new PlusTemplate(this),
				new TimesTemplate(this),
				new ParenthesisTemplate(this)
		};
	}
	
	class TextEventListener implements ITextEventListener {		
		private final ChangeText fView;
		private final IValueChangeListener<IModelElement> fListener;
	
		public TextEventListener(final ChangeText view, final IValueChangeListener<IModelElement> listener) {
			super();
			fView = view;
			fListener = listener;
		}
		
		public boolean handleEvent(Text text, TextEvent event) {
			StringBuffer content = new StringBuffer(fView.getContent());
			content.replace(event.getBegin(), event.getEnd(), event.getText());				
			Parser parser = new Parser(fRules, fStartSymbol);				
			fScanner.setStringToScann(content.toString());
			parser.parser(fScanner);
			
			if (parser.finished()) {
				List<ASTNode> derivation = parser.getDerivation();			
				fListener.valueChanges((SymbolASTNode)derivation.get(0));
			} else {
				fView.setText(content.toString());
				fView.update();
			}			
			return true;
		}
		public boolean verifyEvent(Text text, TextEvent event) {
			Parser parser = new Parser(fRules, fStartSymbol);
			StringBuffer tryContent = new StringBuffer(fView.getContent());
			tryContent.replace(event.getBegin(), event.getEnd(), event.getText());
			fScanner.setStringToScann(tryContent.toString());
			if (parser.parser(fScanner)) {
				return true;
			} else {
				return false;
			}
		}	
	}
	
	private Text createLiveParseView(IModelElement model, IValueChangeListener<IModelElement> changeListener) {
		ChangeText result = new ChangeText();			
		result.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));			
		result.addElement(ITextEventListener.class, new TextEventListener(result, changeListener));			
		return result;
	}

	@Override
	public Text createView(IModelElement model, IValueChangeListener<IModelElement> changeListener) {
		CompoundText outer = new CompoundText();
		if (model != null) {
			outer.addText(super.createView(model, changeListener));
			outer.setElement(LiveParseFlag.class, new LiveParseFlag(false));
		} else {			
			outer.addText(createLiveParseView(model, changeListener));
			outer.setElement(LiveParseFlag.class, new LiveParseFlag(true));
		}
		outer.setElement(IValueChangeListener.class, changeListener);
		return outer;
	}	
	
	class LiveParseFlag {
		boolean liveParse;
		public LiveParseFlag(boolean liveParse) {
			super();
			this.liveParse = liveParse;
		}		
	}
	
	@Override
	public void updateView(Text view, IModelElement value) {
		IValueChangeListener<IModelElement> changeListener = view.getElement(IValueChangeListener.class);
		if (value == null && !view.getElement(LiveParseFlag.class).liveParse) {
			((CompoundText)view).replaceText(((CompoundText)view).getTexts().get(0), 
					createLiveParseView(value, changeListener));
			view.getElement(LiveParseFlag.class).liveParse = true;
		} else if (value != null && view.getElement(LiveParseFlag.class).liveParse) {
			((CompoundText)view).replaceText(((CompoundText)view).getTexts().get(0), 
					super.createView(value, changeListener));
			view.getElement(LiveParseFlag.class).liveParse = false;
		} else {
			if (!view.getElement(LiveParseFlag.class).liveParse) {
				super.updateView(((CompoundText)view).getTexts().get(0), value);
			} else {
				throw new RuntimeException("assert");
			}
		}
	}

	private void createElementFromASTNode(SymbolASTNode node, IModelElement owner, String property) {
		getModel().getCommandFactory().createChild(owner, getModel().getMetaElement((String)node.getSymbol()),
				property).execute();
	}	
}
