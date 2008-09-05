package hub.sam.tef.editor.model;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * This class can be extended to provide a {@link ModelEditor} that works on a
 * {@link TransactionalEditingDomain} and that encapsulates all model modifications in EMF
 * {@link Command}s.
 * 
 * @author <a href="mailto:sadilek@informatik.hu-berlin.de">Daniel Sadilek</a>
 */
public abstract class TransactionalModelEditor extends ModelEditor {
	@Override
	public IModelCreatingContext createModelCreatingContext() {
		return new TransactionalModelCreatingContext(getMetaModelPackages(),
				getSemanticsProvider(), getCurrentModel(), getCurrentText());
	}

	@Override
	protected ResourceSet createResourceSet() {
		return getEditingDomain().getResourceSet();
	}

	/**
	 * Subclasses must implement this method to return the id of the editing domain that this
	 * transactional model editor should use.
	 * 
	 * @return the id of the editing domain to be used
	 */
	protected abstract String getEditingDomainId();

	/**
	 * A model creating context working with transactions.
	 * 
	 * @author <a href="mailto:sadilek@informatik.hu-berlin.de">Daniel Sadilek</a>
	 */
	private class TransactionalModelCreatingContext extends ModelCreatingContext {
		private TransactionalModelCreatingContext(EPackage[] packages,
				ISemanticsProvider semanticsProvider, Resource resource, String text) {
			super(packages, semanticsProvider, resource, text);
		}

		@Override
		public void addCreatedObject(final EObject object) {
			execute(new RecordingCommand(getEditingDomain(), "addCreatedObject()") {
				protected void doExecute() {
					getResource().getContents().clear();
					getResource().getContents().add(object);
				}
			});
		}

		@Override
		public void addResolution(final Resolution resolution) {
			execute(new RecordingCommand(getEditingDomain(), "addResolution()") {
				protected void doExecute() {
					TransactionalModelCreatingContext.super.addResolution(resolution);
				}
			});
		}
	}

	private TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(getEditingDomainId()); //$NON-NLS-1$
		return editingDomain;
	}

	private void execute(RecordingCommand command) {
		getEditingDomain().getCommandStack().execute(command);
	}

}
