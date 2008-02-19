package hub.sam.tef.editor.popup;

import hub.sam.tef.tsl.TslException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.texteditor.ITextEditor;

public interface IPopupEditor extends ITextEditor {
	
	public void setEditingDomainProvider(IEditingDomainProvider editingDomainProvider);
	public void setCloser(AbstractOpenPopupEditor.Closer closer);
	
	public void close(boolean store);
	
	public void reduceSyntax(EClass metaClass) throws TslException;
}
