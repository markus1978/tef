package hub.sam.tef.pde;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.importer.ecore.EcoreImporter;
import org.eclipse.emf.importer.ui.contribution.base.ModelImporterDetailPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class NewTefTextWizard extends Wizard implements INewWizard {
	private NewTefTextWizardFilePage newFileCreationPage;
	private EcoreImporter ecoreImporter;
	private IStructuredSelection selection;

	public NewTefTextWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@SuppressWarnings("unchecked")
	public void addPages() {				
		newFileCreationPage = new NewTefTextWizardFilePage("Whatever", selection);
		newFileCreationPage.setTitle("Select a file name");
		newFileCreationPage.setDescription("Select a file name");
		newFileCreationPage.setFileName("new_file.etslt");		
		addPage(newFileCreationPage);
		
		ecoreImporter = new EcoreImporter();
		Iterator it = selection.iterator();
        if (it.hasNext()) {
            Object object = it.next();
            IResource selectedResource = null;
            if (object instanceof IResource) {
                selectedResource = (IResource) object;
            } else if (object instanceof IAdaptable) {
                selectedResource = (IResource) ((IAdaptable) object)
                        .getAdapter(IResource.class);
            }
            if (selectedResource != null) {
                if (selectedResource.getType() == IResource.FILE) {
                	if (selectedResource.getFullPath().getFileExtension().equals("ecore")) {
                		ecoreImporter.setModelFile((IFile)selectedResource);
                	}					
				}                
            }
        }
		
		ModelImporterDetailPage detailPage = new ModelImporterDetailPage(ecoreImporter, "EcoreModel");
	    detailPage.setTitle("Select the meta-model");
	    detailPage.setDescription("Select the meta-model that you want to create a syntax for");	    
	    addPage(detailPage);
	}

	public boolean performFinish() {
		final String ecorepath = ecoreImporter.getModelLocation();
		final String containerName = newFileCreationPage.getContainerFullPath().toString();
		final String fileName = newFileCreationPage.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, ecorepath, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	private void doFinish(String containerName, String fileName, String ecorepath, IProgressMonitor monitor)
			throws CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream(ecorepath);
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}

	private InputStream openContentStream(String ecorepath) {
		String contents = "syntax(Model) \"" + ecorepath + "\" {\n}";
		return new ByteArrayInputStream(contents.getBytes());
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "hub.sam.tef", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}