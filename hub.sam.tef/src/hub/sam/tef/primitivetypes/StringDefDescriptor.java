package hub.sam.tef.primitivetypes;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.semantics.IValuePrintSemantics;
import hub.sam.tef.tsl.ValueBinding;

import java.util.Collection;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class StringDefDescriptor extends PrimitiveTypeDescriptor {

	private static final IValueCreationSemantics valueCreationSemantics = new IValueCreationSemantics() {
		@Override
		public Object createValue(ParseTreeNode parseTreeNode,
				IModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			String stringValue = parseTreeNode.getNodeText();
			if (stringValue.equals("")) {
				return null;
			} else {
				return stringValue.substring(1, stringValue.length() - 1);
			}
		}		
	};
	
	@Override
	public String getNonTerminalName() {
		return "STRINGDEF";
	}

	@Override
	public String getRCCSymbol() {
		return "`stringdef`";
	}

	@Override
	public IValueCreationSemantics getValueCreationSemantics() {
		return valueCreationSemantics;
	}	
	
	@Override
	public IContentAssistSemantics getContentAssistSemantics() {
		return new IContentAssistSemantics() {			
			@Override
			public Collection<ContentAssistProposal> createProposals(
					ContentAssistContext context) {
				return ContentAssistProposal.createProposals(
						new String[] { "\"<string>\"" }, context,  
						null, ContentAssistProposal.PRIMITIVE_IMAGE, ContentAssistProposal.PRIMITIVE);
			}			
		};
	}
	
	@Override
	public IValuePrintSemantics getValuePrintSemantics() {
		return new IValuePrintSemantics() {
			@Override
			public boolean printValue(Object modelValue, ValueBinding binding, 
					PrettyPrintState state, PrettyPrinter printer) throws ModelCreatingException {
				if (modelValue != null) {
					state.append("\"" + modelValue.toString() + "\"");
					return true;
				} else {
					return false;
				}
			}					
		};
	}

	@Override
	public IRule getHighlightRule() {
		return new SingleLineRule("\"", "\"", new Token(new TextAttribute(
				new Color(Display.getCurrent(), new RGB(0,0,160)), 
				null, SWT.ITALIC)), '\\' );
	}
}
