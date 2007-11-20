package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class TslModelCreaatingContext extends ModelCreatingContext {
	
	public interface IEcoreModel {
		public void loadModel(String uri);
		public Iterator<Notifier> getAllContents();
	}
	
	private final IEcoreModel fEcoreModel = new IEcoreModel() {
		private ResourceSet metaModel = null;
		private String metaModelPlatformURI = null;
		
		@SuppressWarnings("unchecked")
		@Override
		public Iterator<Notifier> getAllContents() {
			if (metaModel == null) {
				return Collections.EMPTY_LIST.iterator();
			} else {
				return metaModel.getAllContents();
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

		@Override
		public void loadModel(String uri) {
			if (uri.equals(metaModelPlatformURI)) {
				return;
			} else {
				metaModelPlatformURI = uri;
			}
			try {
				URI metaModelURI = URI.createPlatformResourceURI(uri, false);
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
				metaModelPlatformURI = null;
				throw ex;
			}
		}
	};

	public TslModelCreaatingContext(EPackage[] packages,
			ISemanticsProvider semanticsProvider) {
		super(packages, semanticsProvider);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == IEcoreModel.class) {
			return (T)fEcoreModel;
		}
		return super.getAdapter(adapter);
	}

	
}
