package hub.sam.tef.contentassist;

import hub.sam.tef.rcc.Semantic;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.Token.Range;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.impl.SyntaxImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class TestContentAssistProcessor implements IContentAssistProcessor {

	
	private final ContentAssistTestEditor fEditor;
	
	public TestContentAssistProcessor(ContentAssistTestEditor editor) {
		super();
		fEditor = editor;
	}
	
	private class ContentAssistParserSemantics implements Semantic {

		@SuppressWarnings("unchecked")
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

		public Object doSemanticForErrorRecovery(String recoverSymbol) {		
			Assert.isTrue(false, "supposed unreachable");
			return null;
		}		
	}
		
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {				
		ContentAssistParser fParser = new ContentAssistParser(fEditor.getSyntax());
				
		Semantic semantics = new ContentAssistParserSemantics();
		String content = viewer.getTextWidget().getText();
		
		Collection<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
		
		try {
			fParser.getRccParser().setCompletionOffset(offset);	
			
			fParser.getRccParser().parse(content, semantics);
														
			if (fParser.getRccParser().completionParseOk()) {
				Token lastToken = fParser.getRccParser().getLastToken();
				String lastTokenPrefix = null;
				if (lastToken != null && lastToken.range.end.offset <= content.length()) {
					lastTokenPrefix = content.substring(lastToken.range.start.offset, 
							lastToken.range.end.offset);
				}
				Collection<Symbol> followupSymbols = 
					fParser.getRccParser().getFollowSymbols(fEditor.getSyntax());
				
				for (final Symbol followupSymbol: followupSymbols) {					
					result.add(new ICompletionProposal() {

						public void apply(IDocument document) {							
						}

						public String getAdditionalProposalInfo() {
							return null;
						}

						public IContextInformation getContextInformation() {
							return null;
						}

						public String getDisplayString() {
							return followupSymbol.toString();
						}

						public Image getImage() {
							return null;
						}

						public Point getSelection(IDocument document) {					
							return null;
						}						
					});
				}				
				System.out.println(lastTokenPrefix);
			} else {
				System.out.println("NOT PARSED");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return result.toArray(new ICompletionProposal[] {});
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}
	
}
