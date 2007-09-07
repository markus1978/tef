package hub.sam.tef.documents;

import hub.sam.tef.annotations.IChecker;
import hub.sam.tef.annotations.IIdentifierResolver;
import hub.sam.tef.completion.ICompletionComputer;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.templates.Template;

import java.util.Collection;

public interface ILanguageModelProvider {
	public Template getTopLevelTemplate();
	public IIdentifierResolver getIdentityResolver();
	public IChecker getChecker();
	public AbstractLayoutManager getLayout();
	public Collection<ICompletionComputer> getCompletions();
}
