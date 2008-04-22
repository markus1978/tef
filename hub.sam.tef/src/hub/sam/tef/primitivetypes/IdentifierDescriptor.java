package hub.sam.tef.primitivetypes;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.semantics.IContentAssistSemantics;

import java.util.Collection;

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
	public IContentAssistSemantics getContentAssistSemantics() {
		return new IContentAssistSemantics() {
			public Collection<ContentAssistProposal> createProposals(
					ContentAssistContext context) {
				return ContentAssistProposal.createProposals(
						new String[] { "<name>" }, context, 
						null, ContentAssistProposal.PRIMITIVE_IMAGE, ContentAssistProposal.PRIMITIVE);
			}			
		};
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