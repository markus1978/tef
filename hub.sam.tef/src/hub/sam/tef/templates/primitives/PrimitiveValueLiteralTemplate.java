package hub.sam.tef.templates.primitives;

import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IType;
import hub.sam.tef.reconciliation.syntax.ISyntaxHighlightProvider;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.PrimitiveTreeRepresentation;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public abstract class PrimitiveValueLiteralTemplate<ModelType> extends ValueTemplate<ModelType> {

	public PrimitiveValueLiteralTemplate(Template template, IType type) {
		super(template, type);
	}
	
	protected abstract String getNonTerminal();
		
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (IASTProvider.class == adapter) {
			return (T) new TreeRepresentationProvider();
		} else  if (ISyntaxProvider.class == adapter) {
			return (T)new SyntaxProvider();
		} else if (ISyntaxHighlightProvider.class == adapter) {
			return (T)new SyntaxHighlighProvider();
		} else {
			return super.getAdapter(adapter);
		}
	}
		
	class SyntaxProvider implements ISyntaxProvider {	
		public String getNonTerminal() {
			return PrimitiveValueLiteralTemplate.this.getNonTerminal();
		}
		public String[][] getRules() {
			return PrimitiveValueLiteralTemplate.this.getRules();
		}
	}
	
	protected abstract Object getObjectValueFromStringValue(String value);
	
	protected String[][] getRules() {
		return new String[][] {};
	}
	
	protected String getStringValueFromObjectValue(Object value) {
		return value.toString();
	}

	class TreeRepresentationProvider implements IASTProvider {
		public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout) {
			return new PrimitiveTreeRepresentation((model == null) ? "unknown" : getStringValueFromObjectValue(model));
		}

		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {
			getModel().getCommandFactory().set(owner, property, 
					getObjectValueFromStringValue(((PrimitiveTreeRepresentation)tree).getContent())).execute();
			return null;
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {		
			return null;
		}	
		
	}
	
	protected abstract IRule getHightlightRule(IToken token);
	
	protected abstract TextAttribute getHighlightAttribute();
	
	class SyntaxHighlighProvider implements ISyntaxHighlightProvider {
		public Collection<IRule> getHighlightRules() {			
			Collection<IRule> result = new Vector<IRule>();
			IRule rule = getHightlightRule(new Token(getHighlightAttribute()));
			if (rule != null) {
				result.add(rule);
			}
			return result;
		}		
	}
}
