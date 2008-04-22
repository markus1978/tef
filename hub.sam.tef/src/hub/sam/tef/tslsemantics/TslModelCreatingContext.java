package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

public class TslModelCreatingContext extends ModelCreatingContext {
	
	public interface IEcoreModel {
		public void loadModel(String uri);
		public Iterator<Object> getAllContents();
	}
	
	private IEcoreModel fEcoreModel = new IEcoreModel() {
		private ResourceSet metaModel = null;
		private String metaModelPath = null;
		
		@SuppressWarnings("unchecked")
		public Iterator<Object> getAllContents() {
			if (metaModel == null) {
				return Collections.EMPTY_LIST.iterator();
			} else {
				return (Iterator)metaModel.getAllContents();
			}
		}
		
		private void loadReference(EList<EObject> listOfObjects, Collection<EObject> loaded) {
			for(EObject object: listOfObjects) {
				if (!loaded.contains(object)) {
					if (object instanceof ETypedElement) {
						((ETypedElement)object).getEType();						
					}
					if (object instanceof EClass) {
						((EClass)object).getESuperTypes();
					}
					loadReference(object.eContents(), loaded);
				}
			}
		}

		public void loadModel(String uri) {
			if (uri.equals(metaModelPath)) {
				return;
			} else {
				metaModelPath = uri;
			}
			try {				
				URI metaModelURI = null;
				if (fBundle != null) {
					URL url = FileLocator.find(fBundle, new Path(uri), null);
					metaModelURI = URI.createURI(url.toExternalForm());
				} else {					
					metaModelURI = URI.createFileURI(fProject.getLocation() + "/" + uri);
				}
				EPackage metaMetaModel = EcorePackage.eINSTANCE;
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getPackageRegistry().put(metaMetaModel.getNsURI(),
						metaMetaModel);
				// TODO there must be a better way to load all referenced elements. At least
				// you can optimise it.
				loadReference(
						resourceSet.getResource(metaModelURI, true).getContents(),
						new HashSet<EObject>());				
				metaModel = resourceSet;
			} catch (RuntimeException ex) {
				metaModel = null;
				metaModelPath = null;
				throw ex;
			}
		}
	};
	
	private final Bundle fBundle;
	private final IProject fProject;

	/**
	 * Use this constructor to create a TSL model from a TSL-File within a 
	 * bundle. This happens when an editor uses this TSL-File; the TSL-File is then
	 * part of the editor's plugin's bundle. Referenced meta-models are searched
	 * for in that bundle.
	 */
	public TslModelCreatingContext(EPackage[] packages,
			ISemanticsProvider semanticsProvider, Resource resource, String text,
			Bundle bundle) {
		super(packages, semanticsProvider, resource, text);
		fBundle = bundle;
		fProject = null;
	}
	
	/**
	 * Use this constructor to create a TSL model during editing TSL-Text. This
	 * happens when TSL is edited in a TSL editor; the edited TSL-File can
	 * provide its project, which is then used as a root for referenced
	 * meta-models.
	 */
	public TslModelCreatingContext(EPackage[] packages,
			ISemanticsProvider semanticsProvider, Resource resource, String text,
			IProject project, TslModelCreatingContext lastContext) {
		super(packages, semanticsProvider, resource, text);
		fBundle = null;
		fProject = project;		
		if (lastContext != null) {
			fEcoreModel = lastContext.fEcoreModel;
		}		
	}

	/**
	 * Provides an {@link IEcoreModel} instance. This ECORE model provides
	 * access to the referenced meta-model.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == IEcoreModel.class) {
			return (T)fEcoreModel;
		}
		return super.getAdapter(adapter);		
	}

	
}
