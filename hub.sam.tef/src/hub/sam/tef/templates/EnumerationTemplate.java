package hub.sam.tef.templates;

import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ISyntaxHighlightProvider;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.ModelASTElement;
import hub.sam.tef.reconciliation.treerepresentation.PrimitiveTreeRepresentation;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class EnumerationTemplate extends ValueTemplate<String> {

	private final String[] fValues;
	private final String name;
	
	public EnumerationTemplate(Template template, String name, String[] values) {
		super(template, template.getModelProvider().getModel().getType(String.class));
		this.fValues = values;
		this.name = name;
	}	
	
	@Override
	protected Object getId() {
		return name;
	}

	@Override
	public ICommand getCommandToCreateADefaultValue(IModelElement owner, String property, boolean composite) {		
		return getModel().getCommandFactory().set(owner, property, "name");
	}		
		
	@Override
	public Object getAdapter(Class adapter) {
		if (ISyntaxProvider.class == adapter || ISyntaxHighlightProvider.class == adapter) {
			return new SyntaxProvider();
		} else if (IASTProvider.class == adapter) {
			return new TreeRepresentationProvider();
		} else if (ISemanticProvider.class == adapter) {
			return new SemanticProvider();
		} else {
			return super.getAdapter(adapter);
		}
	}	
	
	class SyntaxProvider implements ISyntaxProvider, ISyntaxHighlightProvider {			
		public String getNonTerminal() {
			return name;
		}

		public String[][] getRules() {
			Collection<String[]> result = new Vector<String[]>();
			for (String value: fValues) {
				result.add(new String[] { getNonTerminal(), "'" + value + "'" });
			}			
			return result.toArray(new String[][] {});
		}

		public Collection<IRule> getHighlightRules() {
			Collection<IRule> result = new Vector<IRule>();
			for (String fTerminalText: fValues) {
				if (fTerminalText.matches("[a-zA-Z]*")) {
					IToken token = new Token(
							new TextAttribute(new Color(Display.getCurrent(), new RGB(120,120,0)), null, SWT.BOLD));
					WordRule rule = new WordRule(new IWordDetector() {
						public boolean isWordPart(char c) {
							return Character.isJavaIdentifierStart(c);
						}
	
						public boolean isWordStart(char c) {
							return Character.isJavaIdentifierPart(c);
						}				
					});
					rule.addWord(fTerminalText, token);
					result.add(rule);
				}
			}	
			return result;
		}
	}
	
	class TreeRepresentationProvider implements IASTProvider {
		public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout) {
			ASTElementNode result = new ASTElementNode(new ModelASTElement(EnumerationTemplate.this, null));
			result.addNodeObject(new PrimitiveTreeRepresentation((model == null) ? "unknown" : model));
			return result;
		}

		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {			
			getModel().getCommandFactory().set(owner, property, tree.getContent()).execute();
			return null;
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {		
			return null;
		}		
	}
	
	class SemanticProvider implements ISemanticProvider {
		
		public void check(ASTElementNode representation, SemanticsContext context) {		
			
		}		
	}
	
}
