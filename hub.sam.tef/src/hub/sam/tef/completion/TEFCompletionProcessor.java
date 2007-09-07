/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package hub.sam.tef.completion;

import fri.patterns.interpreter.parsergenerator.Parser;
import fri.patterns.interpreter.parsergenerator.ParserTables;
import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.documents.ILanguageModelProvider;
import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.reconciliation.syntax.ParserInterface;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Vector;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;


public class TEFCompletionProcessor implements IContentAssistProcessor {
	
	private ParserInterface fParserInterface;
	private Collection<String> keywords = null;
	
	public TEFCompletionProcessor() {
		super();	
	}
	
	private ParserInterface getParserInterface(ILanguageModelProvider language) {
		if (fParserInterface == null) {
			fParserInterface = new ParserInterface(language.getTopLevelTemplate()) {
				@Override
				protected Parser createParser(ParserTables parserTables) {
					return new CompletionParser(parserTables);
				}				
			}; 
		}
		return fParserInterface;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int documentOffset) {
		IDocumentModelProvider modelProvider = ((TEFDocument)viewer.getDocument()).getModelProvider();
		ILanguageModelProvider languageProvider = ((TEFDocument)viewer.getDocument());
		
		CompletionEngine engine = new CompletionEngine(getParserInterface(languageProvider));		
		CompletionContext context = new CompletionContext(viewer.getDocument().get().substring(0, documentOffset),
				languageProvider, modelProvider);
		
		Collection<ICompletionComputer> computers = languageProvider.getCompletions();
		/*
		computers.add(new OclPropertyCallExpCompletion());
		computers.add(new OclOperationCallExpCompletion());
		computers.add(new OclVariableExpCompletion());
		*/
		
		Collection<ICompletionProposal> result = new Vector<ICompletionProposal>();
		for (ICompletionComputer computer: computers) {
			result.addAll(engine.collectCompletionsFromCompletionComputer(computer, context));			
		}
		
		if (keywords == null) {
			keywords = new HashSet<String>();		
			for (Template tpl: Template.collectTemplates(languageProvider.getTopLevelTemplate())) {
				if (tpl instanceof TerminalTemplate) {
					String terminalText = ((TerminalTemplate)tpl).getTerminalText();
					if (terminalText.matches("[a-zA-Z]*")) {
						keywords.add(terminalText);
					}
				}
			}
		}
		
		StringBuffer prefixBuffer = new StringBuffer();
		int i = documentOffset - 1;
		char charAtIndex = 'a';
		while((i>=0)) {
			try {
				charAtIndex = modelProvider.getText().charAt(i);
			} catch (StringIndexOutOfBoundsException ex) {
				break;
			}
			if (charAtIndex > 'A' && 
					charAtIndex < 'z') {
				prefixBuffer.insert(0, charAtIndex);
			} else {
				break;
			}
			i--;						
		}
		String prefix = prefixBuffer.toString();
		
		for (String keyword: keywords) {			
			if (keyword.startsWith(prefix)) {
				result.add(new TEFCompletionProposal(keyword, keyword.substring(prefix.length(),
						keyword.length()), context.getCompletionOffset()));
			}
		}
				
		return result.toArray(new ICompletionProposal[] {}); 
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) { 
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
