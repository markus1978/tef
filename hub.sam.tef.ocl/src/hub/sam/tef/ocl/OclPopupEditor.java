package hub.sam.tef.ocl;

import hub.sam.tef.editor.popup.PopupEditor;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.semantics.ISemanticsProvider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

/**
 * A normal TEF editor for OCL texts. In contrast to other editors, this one
 * needs someone, who sets a context. The context can be set to the
 * OclEditorDelegate of this editor.
 */
public class OclPopupEditor extends PopupEditor {

	private final OclEditorDelegate fDelegate = new OclEditorDelegate();
	
	@Override
	protected AdapterFactory[] createItemProviderAdapterFactories() {
		return fDelegate.createItemProviderAdapterFactories();
	}

	@Override
	protected EPackage[] createMetaModelPackages() {
		return fDelegate.createMetaModelPackages();
	}

	@Override
	protected Bundle getPluginBundle() {
		return fDelegate.getPluginBundle();
	}

	@Override
	protected String getSyntaxPath() {
		return fDelegate.getSyntaxPath();
	}

	@Override
	protected ISemanticsProvider createSemanticsProvider() {
		return fDelegate.createSemanticsProvider();
	}

	@Override
	public AbstractLayoutManager createLayout() {
		return null;
	}
}
