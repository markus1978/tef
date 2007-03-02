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

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class ExpressionTemplate extends ChoiceTemplate {	
	
	private static final TextAttribute liveParseTextAttribute = new TextAttribute(
			Display.getCurrent().getSystemColor(SWT.COLOR_BLACK), 
			Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW), SWT.ROMAN);
	
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
			new SymbolRule(EXPR, new Object[] {ID}, "Integer", new String[] {"value"}),
			
			new TokenRule(ID, new RegexpToken("[0-9]+")),
			new TokenRule(OBRACE, new FixToken("(")),
			new TokenRule(CBRACE, new FixToken(")")),
			new TokenRule(PLUS, new FixToken("+")),
			new TokenRule(TIMES, new FixToken("*")),
	});
	
	public static final Object fStartSymbol = EXPR; 
	
	public ExpressionTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Expression"));
		fScanner = new Scanner(Scanner.getTokensFromRules(fRules));
	}

	@Override
	public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
		return new ValueTemplate[] {
				new IntegerTemplate(this),
				new PlusTemplate(this),
				new TimesTemplate(this),
				new ParenthesisTemplate(this)
		};
	}
	
	class LiveParseTextEventListener implements ITextEventListener {		
		private final ChangeText fView;
		private final IValueChangeListener<IModelElement> fListener;
	
		public LiveParseTextEventListener(final ChangeText view, final IValueChangeListener<IModelElement> listener) {
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
			return ExpressionTemplate.this.verifyEvent(fView.getContent(), event);
		}	
	}
	
	private boolean verifyEvent(String content, TextEvent event) {
		Parser parser = new Parser(fRules, fStartSymbol);
		StringBuffer tryContent = new StringBuffer(content);
		tryContent.replace(event.getBegin(), event.getEnd(), event.getText());
		fScanner.setStringToScann(tryContent.toString());
		if (parser.parser(fScanner)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean doNotupdate = false; // TODO ultra dirty
	
	class TextEventListener implements ITextEventListener {		
		private final IValueChangeListener<IModelElement> fChangeListener;		
		public TextEventListener(final IValueChangeListener<IModelElement> changeListener) {
			super();
			fChangeListener = changeListener;
		}
		public boolean handleEvent(Text text, TextEvent event) {			
			if (text.getElement(LiveParseFlag.class).liveParse) {
				throw new RuntimeException("assert");
			}
			switchModes(text, null, text.getContent());
			doNotupdate = true;
			fChangeListener.valueChanges((IModelElement)null);
			doNotupdate = false;
			for (ITextEventListener listener: ((CompoundText)text).getTexts().get(0).getAllElements(ITextEventListener.class)) {
				listener.handleEvent(text, event);
			}			
			return true;
		}
		public boolean verifyEvent(Text text, TextEvent event) {			
			return ExpressionTemplate.this.verifyEvent(text.getContent(), event);
		}		
	}
	
	/**
	 * Switches the given view from live parsing to normal model view and vice
	 * versa. To switch from live parse to normal model, value must not be null
	 * and the view must be flagged live parse. To switch from model to live
	 * parse, value must be null and the view must not be flagged live parse.
	 * 
	 * @param view
	 *            The view to switch.
	 * @param value
	 *            The new model or null.
	 * @param content
	 *            The textual representation of the current model, used when
	 *            switching to live parse.
	 */
	private void switchModes(Text view, IModelElement value, String content) {
		IValueChangeListener<IModelElement> changeListener = view.getElement(IValueChangeListener.class);
		if (value == null && !view.getElement(LiveParseFlag.class).liveParse) {
			((CompoundText)view).replaceText(((CompoundText)view).getTexts().get(0), 
					createLiveParseView(changeListener, content));
			view.getElement(LiveParseFlag.class).liveParse = true;
		} else if (value != null && view.getElement(LiveParseFlag.class).liveParse) {
			((CompoundText)view).replaceText(((CompoundText)view).getTexts().get(0), 
					super.createView(value, changeListener));
			view.getElement(LiveParseFlag.class).liveParse = false;
		} else {
			if (!view.getElement(LiveParseFlag.class).liveParse) {
				super.updateView(((CompoundText)view).getTexts().get(0), value);
			} else {
				((CompoundText)view).replaceText(((CompoundText)view).getTexts().get(0), 
						createLiveParseView(changeListener, content));
				view.getElement(LiveParseFlag.class).liveParse = true;				
			}
		}
	}
	
	private Text createLiveParseView(IValueChangeListener<IModelElement> changeListener, String content) {
		ChangeText result = new ChangeText();
		if (content != null) {
			result.setText(content);
		}
		result.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));			
		result.addElement(ITextEventListener.class, new LiveParseTextEventListener(result, changeListener));	
		result.setElement(TextAttribute.class, liveParseTextAttribute);
		return result;
	}

	@Override
	public Text createView(IModelElement model, IValueChangeListener<IModelElement> changeListener) {
		CompoundText outer = new CompoundText();
		if (model != null) {
			outer.addText(super.createView(model, changeListener));
			outer.setElement(LiveParseFlag.class, new LiveParseFlag(false));
		} else {			
			outer.addText(createLiveParseView(changeListener, null));
			outer.setElement(LiveParseFlag.class, new LiveParseFlag(true));
		}
		outer.setElement(IValueChangeListener.class, changeListener);
		outer.addElement(ITextEventListener.class, new TextEventListener(changeListener));
		return outer;
	}	
	
	/**
	 * This is to flag views. Only one flag per view, refere to
	 * {@link Text#setElement(Class, Object)}. The flag determines wheather the
	 * view is a normal model view or a view representing a live parse.
	 */
	class LiveParseFlag {
		boolean liveParse;
		public LiveParseFlag(boolean liveParse) {
			super();
			this.liveParse = liveParse;
		}		
	}
	
	@Override
	public void updateView(Text view, IModelElement value) {
		if (!doNotupdate) {
			switchModes(view, value, null);
		}
	}

	private void createElementFromASTNode(SymbolASTNode node, IModelElement owner, String property) {
		getModel().getCommandFactory().createChild(owner, getModel().getMetaElement((String)node.getSymbol()),
				property).execute();
	}	
}
