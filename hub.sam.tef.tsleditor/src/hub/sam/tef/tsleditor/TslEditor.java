package hub.sam.tef.tsleditor;

import hub.sam.tef.Utilities;
import hub.sam.tef.editor.TextEditor;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tsl.provider.TslItemProviderAdapterFactory;
import hub.sam.tef.tslsemantics.TslSemanticsProvider;

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
		throw new RuntimeException("assert");
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
}
