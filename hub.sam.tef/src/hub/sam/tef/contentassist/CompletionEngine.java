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

package hub.sam.tef.contentassist;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.ParserSemantics;
import hub.sam.tef.tsl.Syntax;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.Status;

public class CompletionEngine {

	private final CompletionParser fParser;
	private final Syntax fSyntax;
	
	public CompletionEngine(CompletionParser parser, Syntax syntax) {
		super();
		fParser = parser;
		fSyntax = syntax;
	}

	@SuppressWarnings("unchecked")
	public Collection<CompletionProposal> collectCompletionsFromCompletionComputer(ICompletionComputer completion, 
			CompletionContext context) {
		try {				
			ParserSemantics semantics = new ParserSemantics(fSyntax);
			semantics.setText(context.getContent());
			
			fParser.getRccParser().reset();
			fParser.getRccParser().setCompletionOffset(context.getCompletionOffset());
			fParser.parse(context.getContent(), semantics);
						
			context.setIdentifierPrefix(fParser.getRccParser().getIdentifierPrefix());
			
			boolean completionOk = completion.reduceParseStack(fParser.getRccParser());
			Collection<CompletionProposal> proposals = new HashSet<CompletionProposal>();
			if (completionOk) {
				if (fParser.getRccParser().hasValidStack()) {					
					proposals.addAll(completion.createProposals(
							(ParseTreeNode)fParser.getRccParser().getParseResult(0), context));
				}
			}
	
			List<CompletionProposal> sortedProposals = new Vector<CompletionProposal>();
			sortedProposals.addAll(proposals);
			Collections.sort(sortedProposals, new Comparator<CompletionProposal>() {
				public int compare(CompletionProposal o1, CompletionProposal o2) {
					return o1.getDisplayString().compareTo(o2.getDisplayString());
				}				
			});
			
			return sortedProposals;
		} catch (Exception ex) {			
			TEFPlugin.getDefault().getLog().log(new Status(Status.WARNING,
					TEFPlugin.PLUGIN_ID, Status.OK, "completion failed: " + ex.getMessage(), null));
			return Collections.EMPTY_LIST;			
		}
	}
}
