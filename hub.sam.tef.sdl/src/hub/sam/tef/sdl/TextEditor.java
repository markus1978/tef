package hub.sam.tef.sdl;


import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.provider.EmfSdlItemProviderAdapterFactory;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.semantics.IIdentificationScheme;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.osgi.framework.Bundle;

public class TextEditor extends hub.sam.tef.editor.text.TextEditor {

	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { EmfSdlPackage.eINSTANCE };
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected String getSyntaxPath() {
		return "/resources/sdl.etslt";
	}

	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new EmfSdlItemProviderAdapterFactory() };
	}

	@Override
	protected IIdentificationScheme createIdentificationScheme() {
		return new SDLIdentificationScheme();
	}

	@Override
	public IModelCreatingContext createModelCreatingContext() {	
		return new SdlModelCreatingContext(getMetaModelPackages(), getSemanticsProvider(), new ResourceImpl(),
				getCurrentText());
	}	
	
}