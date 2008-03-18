package $packagePrefix$;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

import $packagePrefix$.Activator; // activator class ?

import $packagePrefix$.expressions.ExpressionsPackage;
import $packagePrefix$.expressions.provider.ExpressionsItemProviderAdapterFactory;

import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.layout.BlockLayout;

public class EmbeddedEditor extends hub.sam.tef.editor.popup.PopupEditor {

	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { ExpressionsPackage.eINSTANCE };
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected String getSyntaxPath() {
		return "/resources/expressions.etslt";
	}

	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new ExpressionsItemProviderAdapterFactory() };
	}
	
	@Override
	public AbstractLayoutManager createLayout() {	
		return new BlockLayout();
	}	
}