package hub.sam.tef.expressions;

import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.semantics.ISemanticsProvider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

public class ExpressionsTextEditor extends TextEditor {
	
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
	protected ISemanticsProvider createSemanticsProvider() {	
		return fDelegate.createSemanticsProvider();
	}
	
	
}
