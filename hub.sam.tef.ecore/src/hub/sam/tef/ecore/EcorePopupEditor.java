package hub.sam.tef.ecore;

import hub.sam.tef.gmf.GMFPopupEditor;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.layout.BlockLayout;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.osgi.framework.Bundle;

public class EcorePopupEditor extends GMFPopupEditor {

	@Override
	public AbstractLayoutManager createLayout() {
		return new BlockLayout();
	}

	@Override
	protected AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new EcoreItemProviderAdapterFactory() };
	}

	@Override
	protected EPackage[] createMetaModelPackages() {
		return new EPackage[] { EcorePackage.eINSTANCE };
	}

	@Override
	protected Bundle getPluginBundle() {
		return EcoreEditorPlugin.getDefault().getBundle();
	}

	@Override
	protected String getSyntaxPath() {
		return "models/ecore.etslt";
	}
}
