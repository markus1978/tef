package hub.sam.tef.primitivetypes;

import org.eclipse.jface.text.rules.IRule;

public class IdentifierDescriptor  extends PrimitiveTypeDescriptor {
	
	@Override
	public String getNonTerminalName() {
		return "IDENTIFIER";
	}

	@Override
	public String getRCCSymbol() {
		return "`identifier`";
	}
	
	@Override
	public IRule getHighlightRule() {
		return null;
		// this is pretty ugly, TODO customer defined highlights for everything
		// return new IdentifierRule(new Token(
		//		new TextAttribute(new Color(Display.getCurrent(), new RGB(140,0,140)), 
		//		null, SWT.NORMAL)));
	}
}