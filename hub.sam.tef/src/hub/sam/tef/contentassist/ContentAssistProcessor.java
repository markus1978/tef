package hub.sam.tef.contentassist;

import hub.sam.tef.editor.TextEditor;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Symbol;

import java.util.ArrayList;
import java.util.Collection;

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
	
	/*
	private class ContentAssistParserSemantics implements Semantic {

		@SuppressWarnings("unchecked")
		@Override
		public Object doSemantic(Rule rule, List parseResults,
				List<Range> resultRanges) {
			if (rule.getNonterminal().equals(SyntaxImpl.START_SYMBOL)) {
				if (parseResults.size() != 1) {
					throw new RuntimeException(new TslException("Unexpected start symbol rule."));
				} else {
					return parseResults.get(0);
				}
			}
			try {
				return fEditor.getSyntax().getRuleForRccRule(rule).getLhs().getName();
			} catch (TslException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public Object doSemanticForErrorRecovery(String recoverSymbol) {		
			Assert.isTrue(false, "supposed unreachable");
			return null;
		}		
	}
	*/
	
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {				
					
		String content = viewer.getTextWidget().getText();
		
		Collection<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
		
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
				
				ContentAssistContext context = new ContentAssistContext(content, fEditor.getCurrentModel());
				context.setIdentifierPrefix(lastTokenPrefix);
				for (final Symbol followupSymbol: followupSymbols) {
					PropertyBinding propertyBinding = followupSymbol.getPropertyBinding();
					if (propertyBinding != null) {
						IContentAssistSemantics semantics = fEditor.getSemanticsProvider().
								getContentAssistSemantics(propertyBinding);
						if (semantics != null) {
							result.addAll(semantics.createProposals(context));
						}
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return result.toArray(new ICompletionProposal[] {});
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