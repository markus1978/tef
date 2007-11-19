package hub.sam.tef.tsleditor;

import hub.sam.tef.Utilities;
import hub.sam.tef.editor.TextEditor;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tsl.provider.TslItemProviderAdapterFactory;
import hub.sam.tef.tslsemantics.TslModelCreaatingContext;
import hub.sam.tef.tslsemantics.TslSemanticsProvider;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;

public class TslEditor extends TextEditor {
	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { TslPackage.eINSTANCE, EcorePackage.eINSTANCE };
	}
	
	@Override
	public String getPlatformURIOfSyntax() {
		Assert.isTrue(false, "supposed unreachable.");
		return null;
	}	
	
	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new TslItemProviderAdapterFactory(), 
				new EcoreItemProviderAdapterFactory() };
	}

	@Override
	public Syntax createSyntax() {
		return Utilities.getTslSyntax();
	}

	@Override
	public ISemanticsProvider createSemanticsProvider() {
		return new TslSemanticsProvider();
	}

	@Override
	public ModelCreatingContext createModelCreatingContext() {
		return new TslModelCreaatingContext(getMetaModelPackages(), getSemanticsProvider());
	}
	
	
}
