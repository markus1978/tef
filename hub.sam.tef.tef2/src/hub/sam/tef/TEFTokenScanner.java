package hub.sam.tef;

import hub.sam.tef.documents.ILanguageModelProvider;
import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.reconciliation.syntax.ISyntaxHighlightProvider;
import hub.sam.tef.templates.Template;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.text.source.ISourceViewer;

public class TEFTokenScanner extends RuleBasedScanner implements ITokenScanner {

	private final ISourceViewer fViewer;
	private boolean configured = false;
	
	public TEFTokenScanner(final ISourceViewer viewer) {
		super();
		fViewer = viewer;		
	}

	private synchronized void configure(ILanguageModelProvider language) {
		if (!configured) {
			List<IRule> rules = new Vector<IRule>();
			collectRules(language.getTopLevelTemplate(), rules, new HashSet<Template>());
			// the rules must be sorted, keyword rules have to have priority, because rules
			// like those for identifiers also match all the keywords.
			Collections.sort(rules, new Comparator<IRule>() {
				@Override
				public int compare(IRule o1, IRule o2) {
					if (o1 instanceof WordRule && o2 instanceof WordRule) {
						return 0;
					} else if (o1 instanceof WordRule) {
						return -1;
					} else if (o2 instanceof WordRule) {
						return 1;
					} else {
						return 0;
					}
				}				
			});
			setRules(rules.toArray(new IRule[]{}));
			configured = true;
		}
	}
	
	
	@Override
	public void setRange(IDocument document, int offset, int length) {
		configure((TEFDocument)fViewer.getDocument());
		super.setRange(document, offset, length);
	}

	private void collectRules(Template template, Collection<IRule> rules, Collection<Template> visited) {
		visited.add(template);
		ISyntaxHighlightProvider provider = template.getAdapter(ISyntaxHighlightProvider.class);
		if (provider != null) {
			rules.addAll(provider.getHighlightRules());
		}
		for (Template nestedTemplate: template.getNestedTemplates()) {
			if (!visited.contains(nestedTemplate)) {
				collectRules(nestedTemplate, rules, visited);
			}
		}
	}
}
