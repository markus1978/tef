package hub.sam.tef.contentassist;

import hub.sam.tef.editor.TextEditor;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Symbol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class ContentAssistProcessor implements IContentAssistProcessor {

	
	private final TextEditor fEditor;
	private final ContentAssistParser fParser;
	
	public ContentAssistProcessor(TextEditor editor) {
		super();
		fEditor = editor;
		fParser = new ContentAssistParser(fEditor.getSyntax());
	}
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {				
					
		String content = viewer.getTextWidget().getText();
		
		
		
		try {
			fParser.getRccParser().setCompletionOffset(offset);				
			fParser.getRccParser().parse(content, null);
																
			if (fParser.getRccParser().completionParseOk()) {
				Token lastToken = fParser.getRccParser().getLastToken();
				String lastTokenPrefix = null;
				if (lastToken != null && lastToken.range.end.offset <= content.length()) {
					lastTokenPrefix = content.substring(lastToken.range.start.offset, 
							lastToken.range.end.offset);
				}
				Collection<Symbol> followupSymbols = 
					fParser.getRccParser().getFollowSymbols(fEditor.getSyntax());
		
				Collection<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
				List<String> fixTerminalCompletions = new ArrayList<String>();
				ContentAssistContext context = new ContentAssistContext(offset, lastTokenPrefix,
						fEditor.getCurrentModel());				
				for (final Symbol followupSymbol: followupSymbols) {
					PropertyBinding propertyBinding = followupSymbol.getPropertyBinding();
					boolean completed = false;
					if (propertyBinding != null) {
						IContentAssistSemantics semantics = fEditor.getSemanticsProvider().
								getContentAssistSemantics(propertyBinding);
						if (semantics != null) {
							result.addAll(semantics.createProposals(context));
							completed = true;
						}
					}
					if (!completed && followupSymbol instanceof FixTerminal) {
						fixTerminalCompletions.add(((FixTerminal)followupSymbol).getTerminal());
					}
				}
				result.addAll(ContentAssistProposal.createProposals(
						fixTerminalCompletions, context, null));
				return result.toArray(new ICompletionProposal[] {});
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
		return new ICompletionProposal[] {};
	}

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}
	
}