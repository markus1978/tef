package hub.sam.tef.contentassist;

import hub.sam.tef.editor.TextEditor;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
			RccContentAssistParser rccParser = fParser.getRccParser();
			rccParser.setCompletionOffset(offset);				
			rccParser.parse(content, null);
																
			if (rccParser.completionParseOk()) {
				
				Collection<ICompletionProposal> unsortedCompletions = 
						new HashSet<ICompletionProposal>(); 
				getCompletions(offset, content, rccParser, unsortedCompletions);
								
				if (rccParser.lastTokenWasAPattern()) {
					rccParser.resumeContentAssistParse();
					if (rccParser.completionParseOk()) {
						getCompletions(offset, content, rccParser, unsortedCompletions);		
					}
				}
				
				List<ICompletionProposal> proposals = 
					new ArrayList<ICompletionProposal>(unsortedCompletions.size());
				proposals.addAll(unsortedCompletions);
				ContentAssistProposal.sort(proposals);
				
				return proposals.toArray(new ICompletionProposal[] {});
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
		return new ICompletionProposal[] {};
	}

	private void getCompletions(int offset, String content, RccContentAssistParser rccParser,
			Collection<ICompletionProposal> result) throws TslException {
		Token lastToken = rccParser.getLastToken();
		String lastTokenPrefix = "";
		if (lastToken != null && lastToken.range.end.offset <= content.length()) {
			lastTokenPrefix = content.substring(lastToken.range.start.offset, 
					lastToken.range.end.offset);
		}
		Collection<Symbol> followupSymbols = 
			rccParser.getFollowSymbols(fEditor.getSyntax());

		List<String> fixTerminalCompletions = new ArrayList<String>();
		ContentAssistContext context = new ContentAssistContext(offset, lastTokenPrefix,
				fEditor.getCurrentModel());				
		
		ISemanticsProvider semanticsProvider = fEditor.getSemanticsProvider();
		for (final Symbol followupSymbol: followupSymbols) {
			boolean completed = false;
			PropertyBinding propertyBinding = followupSymbol.getPropertyBinding();
			if (propertyBinding != null) {
				IContentAssistSemantics semantics = semanticsProvider.
						getContentAssistSemantics(propertyBinding);
				if (semantics != null) {
					result.addAll(semantics.createProposals(context));
					completed = true;
				}
			}
			if (followupSymbol instanceof NonTerminal) {
				for (Rule followRule: fEditor.getSyntax().getRulesForNonTerminal(
						(NonTerminal)followupSymbol)) {
					ValueBinding valueBinding = followRule.getValueBinding();
					IContentAssistSemantics semantics = semanticsProvider.
					getContentAssistSemantics(valueBinding);
					if (semantics != null) {
						result.addAll(semantics.createProposals(context));
						completed = true;
					}
				}
			}
			if (!completed && followupSymbol instanceof FixTerminal) {
				fixTerminalCompletions.add(((FixTerminal)followupSymbol).getTerminal());				
			}
		}
			
		result.addAll(ContentAssistProposal.createProposals(
				fixTerminalCompletions, 
				context, 
				null, ContentAssistProposal.KEWORD_IMAGE, ContentAssistProposal.KEYWORD));		
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