package hub.sam.tef.tsleditor;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.Utilities;
import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tsl.provider.TslItemProviderAdapterFactory;
import hub.sam.tef.tslsemantics.TslModelCreatingContext;
import hub.sam.tef.tslsemantics.TslSemanticsProvider;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.framework.Bundle;

public class TslEditor extends TextEditor {
	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { TslPackage.eINSTANCE, EcorePackage.eINSTANCE };
	}
	
	@Override
	public String getSyntaxPath() {
		Assert.isTrue(false, "supposed unreachable.");
		return null;
	}		
	
	@Override
	protected Bundle getPluginBundle() {
		return TEFPlugin.getDefault().getBundle();
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
	public IModelCreatingContext createModelCreatingContext() {		
		return new TslModelCreatingContext(getMetaModelPackages(), 
				getSemanticsProvider(), new ResourceImpl(), getCurrentText(),
				((FileEditorInput)getEditorInput()).getFile().getProject(),
				(TslModelCreatingContext)getLastModelCreatingContext());
	}
	
	
}
