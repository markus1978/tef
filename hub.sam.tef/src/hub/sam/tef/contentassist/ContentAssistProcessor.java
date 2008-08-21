package hub.sam.tef.contentassist;

import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.ParseTreeRuleNode;
import hub.sam.tef.modelcreating.Parser;
import hub.sam.tef.modelcreating.ParserSemantics;
import hub.sam.tef.rcc.ParserTables;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.Token.Range;
import hub.sam.tef.rcc.lexer.LexerException;
import hub.sam.tef.rcc.parsertables.ParserBuildException;
import hub.sam.tef.rcc.syntax.SyntaxException;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.ValueBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class ContentAssistProcessor implements IContentAssistProcessor {

	
	private final TextEditor fEditor;
	private final ContentAssistParser fParser;
	private final PartialContentAssistParser fPartialParser;
	
	public ContentAssistProcessor(TextEditor editor) {
		super();
		fEditor = editor;
		fParser = new ContentAssistParser(fEditor.getSyntax());
		fPartialParser = new PartialContentAssistParser(fEditor.getSyntax());
	}
	
	/** 
	 * A specific RCC parser interface for {@link RccPartialParser}.
	 */
	private class PartialContentAssistParser extends Parser {
		public PartialContentAssistParser(Syntax syntax) {
			super(syntax);
		}

		@Override
		protected hub.sam.tef.rcc.Parser createRccParser(ParserTables parserTables) {
			return new RccPartialParser(parserTables);
		}

		@Override
		public RccPartialParser getRccParser() throws SyntaxException,
				ParserBuildException, LexerException, TslException {
			return (RccPartialParser)super.getRccParser();
		}				
	}
	
	/**
	 * A specific parser semantics for partial parsing. This will try to access
	 * the parse-tree node "closest" to the completion offset.
	 */
	private class CompletionParseSemantics extends ParserSemantics {
		public CompletionParseSemantics(Syntax syntaxDescription, 
				int completionOffset) {
			super(syntaxDescription);
			this.fCompletionOffset = completionOffset;
		}
		
		private final int fCompletionOffset;

		/**
		 * This is the parse-tree node closest to the completion offset.
		 */
		private ParseTreeNode completionNode = null;
		
		private boolean hitsOffset(Range range) {
			return (range.end.offset >= fCompletionOffset); 
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public Object doSemantic(
				hub.sam.tef.rcc.syntax.Rule rccRule,
				List parseResults, List<Range> resultRanges) {
			ParseTreeNode result = (ParseTreeNode) 
					super.doSemantic(rccRule, parseResults, resultRanges);
			boolean startsInFrontOfOffset = false;			
			int hitsOffsetAt = -1;
			int i = 0;
			for (Range range: resultRanges) {
				if (hitsOffset(range)) {
					if (startsInFrontOfOffset) {
						hitsOffsetAt = i;
					}
				} else {
					startsInFrontOfOffset = true;
				}		
				i++;
			}
			
			if (hitsOffsetAt >= 0) {
				if (completionNode == null) {
					Object parseTreeNode = parseResults.get(hitsOffsetAt);
					if (parseTreeNode instanceof ParseTreeNode) {
						completionNode = (ParseTreeNode)parseTreeNode; 
					} else {
						completionNode = result;
					}
				}
			}
			
			return result;
		}					
	}
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {					
		String content = viewer.getTextWidget().getText();		
		try {
			fParser.setup();
			RccContentAssistParser rccParser = fParser.getRccParser();
			rccParser.setCompletionOffset(offset);					
			rccParser.parse(content, null);			
																
			if (rccParser.completionParseOk()) {											
				EObject completionObject = null;
				try {
					completionObject = partialParse(offset, content);					
				} catch (Exception e) {
					System.out.println("Warning: " + e.getMessage());
				}
				
				Collection<ICompletionProposal> unsortedCompletions = 
						new HashSet<ICompletionProposal>(); 
				getCompletions(offset, content, rccParser, 
						completionObject, unsortedCompletions);
								
				if (rccParser.lastTokenWasAPattern()) {
					rccParser.resumeContentAssistParse();
					if (rccParser.completionParseOk()) {
						getCompletions(offset, content, rccParser, 
								completionObject, unsortedCompletions);		
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

	/**
	 * Parses up to the given offset and returns a model created (but not
	 * resolved or checked) for the text up to the completion offset.
	 * 
	 * @param offset
	 * @param content
	 * @return
	 * @throws SyntaxException
	 * @throws ParserBuildException
	 * @throws LexerException
	 * @throws TslException
	 * @throws IOException
	 * @throws ModelCreatingException
	 */
	private EObject partialParse(int offset, String content)
			throws SyntaxException, ParserBuildException, LexerException,
			TslException, IOException, ModelCreatingException {
		RccPartialParser pp = fPartialParser.getRccParser();
		pp.setCompletionOffset(offset);
		CompletionParseSemantics parserSemantics = 
				new CompletionParseSemantics(fEditor.getSyntax(), offset);
		parserSemantics.setText(content);
		boolean parseOk = pp.parse(content, parserSemantics);
		if (!parseOk) {
			return null;
		}
		
		ParseTreeNode parseResult = parserSemantics.getResult();				
		IModelCreatingContext modelCreatingContext = fEditor.createModelCreatingContext();
		parseResult.createModel(modelCreatingContext, null);
		
		ParseTreeNode completionNode = parserSemantics.completionNode;
		ParseTreeNode i = completionNode;
		parseResult.aquireParents();
		EObject completionObject = null;
		while (completionObject == null && i != null) {
			if (i instanceof ParseTreeRuleNode) {
				Object nodeValue = ((ParseTreeRuleNode)i).getValue();
				if (nodeValue != null && nodeValue instanceof EObject) {
					completionObject = (EObject)nodeValue;
				}
			}
			i = i.getParent();
		}			
		parseResult.looseParents();
		return completionObject;
	}

	private void getCompletions(int offset, String content, 
			RccContentAssistParser rccParser,
			EObject completionObject,
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
		ContentAssistContext context = 
			new ContentAssistContext(offset, lastTokenPrefix, completionObject, fEditor);				
		
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
					if (valueBinding != null) {
						IContentAssistSemantics semantics = semanticsProvider.
								getContentAssistSemantics(valueBinding);
						if (semantics != null) {
							result.addAll(semantics.createProposals(context));
							completed = true;
						}
					}
				}
			}
			if (!completed && followupSymbol instanceof FixTerminal) {
				fixTerminalCompletions.add(((FixTerminal)followupSymbol).getTerminal());				
			}
		}
			
		result.addAll(ContentAssistProposal.createProposals(
				fixTerminalCompletions, context, 
				null, ContentAssistProposal.KEWORD_IMAGE, ContentAssistProposal.KEYWORD));		
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