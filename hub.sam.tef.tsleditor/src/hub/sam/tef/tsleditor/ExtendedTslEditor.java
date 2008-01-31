package hub.sam.tef.tsleditor;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.editor.SourceViewerConfiguration;
import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.etsl.provider.EtslItemProviderAdapterFactory;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tsl.provider.TslItemProviderAdapterFactory;
import hub.sam.tef.tslsemantics.TslModelCreatingContext;
import hub.sam.tef.tslsemantics.TslSemanticsProvider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.framework.Bundle;

public class ExtendedTslEditor extends TextEditor {
	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { EtslPackage.eINSTANCE, TslPackage.eINSTANCE, EcorePackage.eINSTANCE };
	}
	
	@Override
	public String getSyntaxPath() {
		return "resources/models/etsl.tslt";
	}	
	
	@Override
	protected Bundle getPluginBundle() {
		return TEFPlugin.getDefault().getBundle();
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
	public IModelCreatingContext createModelCreatingContext() {
		return new TslModelCreatingContext(getMetaModelPackages(), 
				getSemanticsProvider(), new ResourceImpl(), getCurrentText(), 
				((FileEditorInput)getEditorInput()).getFile().getProject(),
				(TslModelCreatingContext)getLastModelCreatingContext());
	}
	
	private ValidateGrammarAction fValidateGrammarAction = null;
	
	@Override
	protected void createActions() {	
		super.createActions();
				
		fValidateGrammarAction = new ValidateGrammarAction(this);
		setAction(ValidateGrammarAction.ACTION_DEFINITION_ID, fValidateGrammarAction);	
	}
	
	@Override
	protected void addActions(Collection<String> actionIds) {
		super.addActions(actionIds);
		actionIds.add(ValidateGrammarAction.ACTION_DEFINITION_ID);
	}

	@Override
	protected SourceViewerConfiguration createSourceViewerConfiguration() {	
		return new TslSourceViewerConfiguration(this);
	}
	
	
}
