package hub.sam.tef.primitivetypes;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.tsl.ValueBinding;

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
				ModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			String stringValue = parseTreeNode.getNodeText();
			return stringValue.substring(1, stringValue.length() - 1);
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
	public IRule getHighlightRule() {
		return new SingleLineRule("\"", "\"", new Token(new TextAttribute(
				new Color(Display.getCurrent(), new RGB(0,0,160)), 
				null, SWT.ITALIC)), '\\' );
	}
}