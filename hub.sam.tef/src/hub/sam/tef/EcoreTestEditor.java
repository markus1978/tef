package hub.sam.tef;

import hub.sam.tef.editor.TextEditor;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.DefaultSemanitcsProvider;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.semantics.ModelCheckError;
import hub.sam.tef.tsl.ElementBinding;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;

public class EcoreTestEditor extends TextEditor {
	
	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { EcorePackage.eINSTANCE };
	}
	
	@Override
	public String getPlatformURIOfSyntax() {
		return "/hub.sam.tef.examples/example-syntax.tsl";
	}	

	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new EcoreItemProviderAdapterFactory() };
	}

	@Override
	public ISemanticsProvider createSemanticsProvider() {
		return new DefaultSemanitcsProvider() {
			@Override
			public IValueCheckSemantics getValueCheckSemantics(ElementBinding binding) {
				if (binding.getMetaclass() == EcorePackage.eINSTANCE.getEClass()) {
					return new IValueCheckSemantics() {
						@Override
						public void check(
								ParseTreeNode parseTreeNode,
								ModelCreatingContext context, EObject value,
								ElementBinding binding)
								throws ModelCreatingException {
							if (((EClass)value).getEAllSuperTypes().contains((EClass)value)) {
								context.addError(new ModelCheckError("Cyclic super types.", (EObject)value));
							}
						}						
					};
				} else {
					return super.getValueCheckSemantics(binding);
				}
			}			
		};
	}
}
