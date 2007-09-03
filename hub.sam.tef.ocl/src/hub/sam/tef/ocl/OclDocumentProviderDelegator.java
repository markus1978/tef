package hub.sam.tef.ocl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.text.IDocument;

public class OclDocumentProviderDelegator {
	private final EPackage fOclExpressionsPackage = org.eclipse.emf.ocl.expressions.ExpressionsPackage.eINSTANCE;
	private final EFactory fOclExpressionsFactory = org.eclipse.emf.ocl.expressions.ExpressionsFactory.eINSTANCE;
	
	private final EPackage fUmlPackage = org.eclipse.emf.ocl.uml.UMLPackage.eINSTANCE;
	private final org.eclipse.emf.ocl.uml.UMLFactory fUmlFactory = org.eclipse.emf.ocl.uml.UMLFactory.eINSTANCE;
	
	private final EPackage fEcorePackage = EcorePackage.eINSTANCE;
	private final EFactory fEcoreFactory = EcoreFactory.eINSTANCE;

	private static AdapterFactoryEditingDomain sharedEditingDomain = null;
		
	protected Iterable<EFactory> getFactory() {
		Vector<EFactory> result = new Vector<EFactory>();
		result.add(fOclExpressionsFactory);
		result.add(fUmlFactory);
		result.add(fEcoreFactory);
		return result;
	}
		
	protected Iterable<EPackage> getPackage() {
		Vector<EPackage> result = new Vector<EPackage>();
		result.add(fOclExpressionsPackage);
		result.add(fUmlPackage);
		result.add(fEcorePackage);
		return result;
	}	

	private static ComposedAdapterFactory createAdaptorFactory() {
		// Create an adapter factory that yields item providers.
		List factories = new ArrayList();
		factories.add(new ResourceItemProviderAdapterFactory());
		//factories.add(new org.eclipse.emf.ocl.expressions.provider.ExpressionsItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		return new ComposedAdapterFactory(factories);
	}
		
	protected EditingDomain getEditingDomain() {
		if (sharedEditingDomain == null) {
			// Create the command stack that will notify this editor as commands
			// are executed.
			//

			BasicCommandStack commandStack = new BasicCommandStack();
			// Create the editing domain with a special command stack.
			sharedEditingDomain = new AdapterFactoryEditingDomain(createAdaptorFactory(), commandStack, new HashMap());
		}
		return sharedEditingDomain;
		//return EcoreEditor.getSharedEditingDomain();
	}	
	
	protected IDocument createEmptyDocument() {
		return new OclDocument();
	}
}
