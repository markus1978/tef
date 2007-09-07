package hub.sam.tef.emf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.text.IDocument;

import hub.sam.tef.documents.TEFDocumentProvider;

public abstract class AbstractEMFDocumentProvider extends TEFDocumentProvider {
	protected abstract Iterable<EPackage> getPackage();
	protected abstract Iterable<EFactory> getFactory();	
	
	public EditingDomain getEditingDomain() {
		return getSharedEditingDomain();
	}
	
	private static AdapterFactoryEditingDomain sharedEditingDomain = null;

	private static ComposedAdapterFactory createAdaptorFactory() {
		List factories = new ArrayList();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		return new ComposedAdapterFactory(factories);
	}
	  
	@Deprecated
	public static AdapterFactoryEditingDomain getSharedEditingDomain() {
		if (sharedEditingDomain == null) {
			BasicCommandStack commandStack = new BasicCommandStack();	
			sharedEditingDomain = new AdapterFactoryEditingDomain(
					createAdaptorFactory(), commandStack, new HashMap());
		}
		return sharedEditingDomain;
	}
}
