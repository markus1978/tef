package hub.sam.tef.tsleditor;

import hub.sam.tef.editor.TextEditor;
import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.etsl.provider.EtslItemProviderAdapterFactory;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tsl.provider.TslItemProviderAdapterFactory;
import hub.sam.tef.tslsemantics.TslModelCreaatingContext;
import hub.sam.tef.tslsemantics.TslSemanticsProvider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;

public class ExtendedTslEditor extends TextEditor {
	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { EtslPackage.eINSTANCE, TslPackage.eINSTANCE, EcorePackage.eINSTANCE };
	}
	
	@Override
	public String getPlatformURIOfSyntax() {
		return "/hub.sam.tef/resources/models/etsl.tslt";
	}	
	
	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new EtslItemProviderAdapterFactory(),
				new TslItemProviderAdapterFactory(), 
				new EcoreItemProviderAdapterFactory() };
	}
	
	@Override
	protected ISemanticsProvider createSemanticsProvider() {
		return new TslSemanticsProvider();
	}
	
	@Override
	public ModelCreatingContext createModelCreatingContext() {
		return new TslModelCreaatingContext(getMetaModelPackages(), getSemanticsProvider());
	}
	
	
}
