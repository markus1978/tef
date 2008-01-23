package hub.sam.tef.ocl;

import hub.sam.tef.editor.text.TextEditor;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.osgi.framework.Bundle;

public class OclTextEditor extends TextEditor {
	
	@Override
	protected AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { };
	}

	@Override
	protected EPackage[] createMetaModelPackages() {
		return new EPackage[] { CSTPackage.eINSTANCE };
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected String getSyntaxPath() {
		return "resources/ocl.etslt";
	}
	
}
