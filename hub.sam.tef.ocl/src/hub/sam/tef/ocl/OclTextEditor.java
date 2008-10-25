package hub.sam.tef.ocl;

import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.semantics.DefaultIdentificationScheme;
import hub.sam.tef.semantics.DefaultSemanticsProvider;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.osgi.framework.Bundle;

public class OclTextEditor extends TextEditor {

	private EObject context = EcorePackage.eINSTANCE.getEClass();
	private EnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(EPackage.Registry.INSTANCE);
	
	protected AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] {};
	}

	protected EPackage[] createMetaModelPackages() {
		return new EPackage[] { CSTPackage.eINSTANCE };
	}

	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}

	protected String getSyntaxPath() {
		return "resources/ocl.etslt";
	}	

	public EObject getContext() {
		return context;
	}

	public void setContext(EObject context) {
		this.context = context;
	}	

	public EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	public void setEnvironmentFactory(EnvironmentFactory environmentFactory) {
		this.environmentFactory = environmentFactory;
	}

	protected ISemanticsProvider createSemanticsProvider() {
		return new DefaultSemanticsProvider(DefaultIdentificationScheme.INSTANCE) {
			@Override
			public IValueCheckSemantics getValueCheckSemantics(
					ElementBinding binding) {
				if (CSTPackage.eINSTANCE.getOCLExpressionCS().isSuperTypeOf(binding.getMetaclass())) {
					return fCheckSemantics;
				} else {
					return null;
				}
			}

			@Override
			public IContentAssistSemantics getContentAssistSemantics(
					Binding binding) {
				if (binding instanceof CompositeBinding) {
					CompositeBinding compositeBinding = (CompositeBinding)binding;					
					if ("variable".equals(compositeBinding.getBindingId())) {
						return fVariableAssistSemantics;
					} else if ("collection".equals(compositeBinding.getBindingId())) {
						return fCollectionContentAssistSemantics;
					} else if ("navigation".equals(compositeBinding.getBindingId())) {
						return fNavigationContentAssistSemantics;
					} else if ("operation".equals(compositeBinding.getBindingId())) {
						return fOperationContentAssistSemantics;
					}
				}
				return null;
			}
		};
	}
	
	private final IValueCheckSemantics fCheckSemantics = new OclValueCheckSemantics(this);
	private final IContentAssistSemantics fVariableAssistSemantics = 
			new OclVariableContentAssistSemantics(this);
	private final IContentAssistSemantics fCollectionContentAssistSemantics =
			new OclCollectionFunctionsContentAssistSemantics();
	private final IContentAssistSemantics fNavigationContentAssistSemantics =
			new OclNavigationContentAssisSemantics(this);
	private final IContentAssistSemantics fOperationContentAssistSemantics =
			new OclOperationContentAssisSemantics(this);
}
