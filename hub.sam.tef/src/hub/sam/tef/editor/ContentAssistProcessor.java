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
package hub.sam.tef.editor;

import hub.sam.tef.contentassist.CompletionContext;
import hub.sam.tef.contentassist.CompletionEngine;
import hub.sam.tef.contentassist.CompletionParser;
import hub.sam.tef.contentassist.ICompletionComputer;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.tsl.Binding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class ContentAssistProcessor implements IContentAssistProcessor {
	
	private CompletionParser fParser = null;
	private Collection<ICompletionComputer> fComputers = null;
	private final TextEditor fEditor;
	
	public ContentAssistProcessor(TextEditor editor) {
		super();
		fEditor = editor;
	}
	
	private void initialise() {
		if (fComputers == null) {
			fComputers = new ArrayList<ICompletionComputer>();
			Iterator<EObject> it = fEditor.getSyntax().eAllContents();
			while (it.hasNext()) {
				EObject next = it.next();
				if (next instanceof Binding) {
					IContentAssistSemantics caSemantics = fEditor.getSemanticsProvider().
							getContentAssistSemantics((Binding)next);
					if (caSemantics != null) {
						fComputers.add(caSemantics);
					}
				}
			}
		}
		
		if (fParser == null) {
			fParser = new CompletionParser(fEditor.getSyntax());
		}
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int documentOffset) {
		
		initialise();		
				
		CompletionEngine engine = new CompletionEngine(fParser, fEditor.getSyntax());
		
		CompletionContext context = new CompletionContext(
				viewer.getDocument().get().substring(0, documentOffset),
				fEditor.getCurrentModel());
				
		Collection<ICompletionProposal> result = new Vector<ICompletionProposal>();
		for (ICompletionComputer computer: fComputers) {
			result.addAll(engine.collectCompletionsFromCompletionComputer(computer, context));			
		}
		
		/* add keyword proposals is not context sensitive TODO
		 * this new implementation does not know the keywords TODO
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
				result.add(new CompletionProposal(keyword, keyword.substring(prefix.length(),
						keyword.length()), context.getCompletionOffset()));
			}
		}
		*/
				
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
