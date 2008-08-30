package hub.sam.tef.primitivetypes;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.tsl.ValueBinding;

import java.util.Collection;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class FloatDescriptor extends PrimitiveTypeDescriptor {
	
	private static final IValueCreationSemantics valueCreationSemantics = new IValueCreationSemantics() {
		public Object createValue(ParseTreeNode parseTreeNode,
				IModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			String stringValue = parseTreeNode.getNodeText();
			if (stringValue.equals("")) {
				return null;
			} else {
				return new Double(stringValue);
			}
		}		
	};

	@Override
	public String getNonTerminalName() {
		return "FLOAT";
	}

	@Override
	public String getRCCSymbol() {
		return "`float`";
	}

	@Override
	public IValueCreationSemantics getValueCreationSemantics() {
		return valueCreationSemantics;
	}
	
	@Override
	public IContentAssistSemantics getContentAssistSemantics() {
		return new IContentAssistSemantics() {
			public Collection<ContentAssistProposal> createProposals(
					ContentAssistContext context) {
				return ContentAssistProposal.createProposals(
						new String[] { "<float>" }, context, 
						null, ContentAssistProposal.PRIMITIVE_IMAGE, ContentAssistProposal.PRIMITIVE);
			}			
		};
	}
	
	@Override
	public IRule getHighlightRule() {	
		return new NumberRule(new Token(new TextAttribute(new Color(Display.getCurrent(), 
				new RGB(0,0,160)), 
				null, SWT.NORMAL)));
	}	
}
