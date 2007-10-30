package hub.sam.tef;

import hub.sam.tef.documents.TEFDocumentProvider;
import hub.sam.tef.emf.EMFModelDocumentProvider;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.IDocument;

public abstract class TEFEMFModelEditor extends TEFEMFEditor {
			
	@Override
	protected TEFDocumentProvider createDocumentProvider() {
		return new EMFModelDocumentProvider() {

			@Override
			protected Iterable<EFactory> getFactory() {
				return getModelFactories();
			}

			@Override
			protected Iterable<EPackage> getPackage() {
				return getMetaModelPackages();
			}
			
			@Override
			public IDocument createEmptyDocument()  {
				return TEFEMFModelEditor.this.createEmptyDocument();
			}
		};
	}

}
