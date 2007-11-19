package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class TslModelCreaatingContext extends ModelCreatingContext {
	
	public interface IEcoreModel {
		public void loadModel(String uri);
		public Iterator<EObject> getAllContents();
	}
	
	private final IEcoreModel fEcoreModel = new IEcoreModel() {
		private Resource metaModel = null;
		private String metaModelPlatformURI = null;
		
		@SuppressWarnings("unchecked")
		@Override
		public Iterator<EObject> getAllContents() {
			if (metaModel == null) {
				return Collections.EMPTY_LIST.iterator();
			} else {
				return metaModel.getAllContents();
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
				this.metaModel = resourceSet.getResource(metaModelURI, true);
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
