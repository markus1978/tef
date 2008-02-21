package hub.sam.tef.expressions;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

import hub.sam.tef.editor.popup.PopupEditor;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.semantics.ISemanticsProvider;

public class ExpressionsPopupEditor extends PopupEditor {

	private static final ExpressionsEditorDelegate fDelegate = new ExpressionsEditorDelegate();
	
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
	public AbstractLayoutManager createLayout() {
		return new BlockLayout();
	}

	@Override
	protected ISemanticsProvider createSemanticsProvider() {	
		return fDelegate.createSemanticsProvider();
	}
}
