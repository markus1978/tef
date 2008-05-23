package hub.sam.tef.ecore;

import hub.sam.tef.Utilities;
import hub.sam.tef.editor.model.ModelEditor;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingContext;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.Bundle;

public class EcoreModelEditor extends ModelEditor {

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
	
	@Override
	public IModelCreatingContext createModelCreatingContext() {
		Resource currentModel = getCurrentModel();
		return new ModelCreatingContext(
				getMetaModelPackages(), getSemanticsProvider(), 
				currentModel, getCurrentText()) {
					private boolean initalized = false;
					
					@Override
					public void addCreatedObject(EObject object) {
						if (getResource() != null) {
							getResource().getContents().clear();
						}
						super.addCreatedObject(object);
						
						if (!initalized) {	
							// TODO we only and always load the ecore model
							// this should be replaced by a load resource option in
							// the context menu
							EObject ecore = Utilities.loadPackage(EcorePackage.eNS_URI);
							getResource().getContents().add(ecore);							
							initalized = true;							
						}						
					}			
		};
	}
	
}
