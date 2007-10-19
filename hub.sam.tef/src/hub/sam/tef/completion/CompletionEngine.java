/*
TEF -- Textual Editing Framework
Copyright (C) 2007 Markus Scheidgen
    This library is free software; you can redistribute it and/or modify it
under the terms of the GNU General Public License as published by the
Free Software Foundation; either version 2 of the License, or any later
version.

    This library is distributed in the hope that it will be useful, but WITHOUT
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
details.

    You should have received a copy of the GNU General Public License
along with this library; if not, write to the Free Software Foundation, Inc.,
59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
*/

package hub.sam.tef.completion;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.reconciliation.syntax.ParserInterface;
import hub.sam.tef.reconciliation.syntax.UpdateTreeSemantic;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.Status;

public class CompletionEngine {

	private final ParserInterface fParserInterface;
	
	public CompletionEngine(final ParserInterface parser) {
		super();
		fParserInterface = parser;
	}

	public Collection<TEFCompletionProposal> collectCompletionsFromCompletionComputer(ICompletionComputer completion, 
			CompletionContext context) {
		try {
			UpdateTreeSemantic semantic = new UpdateTreeSemantic(fParserInterface, context.getContent());		
					
			CompletionParser parser = (CompletionParser)fParserInterface.getParser();
			parser.reset();
			parser.setCompletionOffset(context.getCompletionOffset());
			fParserInterface.parse(context.getContent(), semantic);
						
			context.setIdentifierPrefix(parser.getIdentifierPrefix());
			
			boolean completionOk = completion.reduceParseStack(parser);
			Collection<TEFCompletionProposal> proposals = new HashSet<TEFCompletionProposal>();
			if (completionOk) {
				if (parser.hasValidStack()) {					
					proposals.addAll(completion.createProposals((ASTElementNode)parser.getParseResult(0), context));
				}
			}
	
			List<TEFCompletionProposal> sortedProposals = new Vector<TEFCompletionProposal>();
			sortedProposals.addAll(proposals);
			Collections.sort(sortedProposals, new Comparator<TEFCompletionProposal>() {
				public int compare(TEFCompletionProposal o1, TEFCompletionProposal o2) {
					return o1.getDisplayString().compareTo(o2.getDisplayString());
				}				
			});
			
			// We have to clear the created tree for memory issues.
			semantic.getCurrentResult().dispose();
			
			return sortedProposals;
		} catch (Exception ex) {			
			TEFPlugin.getDefault().getLog().log(new Status(Status.WARNING,
					TEFPlugin.PLUGIN_ID, Status.OK, "completion failed: " + ex.getMessage(), null));
			return Collections.EMPTY_LIST;
			
		}
	}
}
