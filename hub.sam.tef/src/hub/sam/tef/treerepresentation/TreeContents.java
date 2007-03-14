package hub.sam.tef.treerepresentation;

import java.util.Collection;
import java.util.Vector;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.parse.ISyntaxProvider;
import hub.sam.tef.templates.Template;

public abstract class TreeContents {
	
	private final Collection<IContentChangedListener> fListeners = new Vector<IContentChangedListener>();

	public final String getSymbol() {
		Template template = getTemplate();
		return (template == null) ? null : template.getAdapter(ISyntaxProvider.class).getNonTerminal();
	}
	
	public abstract Template getTemplate();
	
	public abstract IModelElement getModel();
	
	public abstract String getContent();
	
	public abstract int getLength();
	
	public abstract void dispose();
	
	public void addContentChangedListener(IContentChangedListener listener) {
		fListeners.add(listener);
	}
	
	public void removeContentChangedListener(IContentChangedListener listener) {
		fListeners.remove(listener);
	}
	
	protected void fireContentChangedListener(int start, int length, String text) {
		for (IContentChangedListener listener: fListeners) {
			listener.contentChanged(start, length, text);
		}
	}
}
