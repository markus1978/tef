package hub.sam.tef.expressions;

import hub.sam.tef.modelcreating.ModelCreating;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import expressions.ExpressionsPackage;
import expressions.Model;

public class CreateModelAction implements IObjectActionDelegate {

	private IFile selectedFile = null;
	
	private static String readFileContents(IFile file) 
			throws IOException, CoreException {
		InputStream in = null;
		try {
			in = file.getContents(true);
			int buffersize = 8192;
			byte[] buf = new byte[buffersize];
			int bytesRead = 0;
			while (in.available() != 0) {
				bytesRead += in.read(buf, bytesRead, 8192);
				if (bytesRead == buffersize) {
					buffersize += 8192;
					byte[] newBuf = new byte[buffersize];
					System.arraycopy(buf, 0, newBuf, 0, bytesRead);
					buf = newBuf;
				}
			}
			return new String(buf, 0, bytesRead);
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		
	}

	public void run(IAction action) {
		Model model = null;
		try {
			String content = readFileContents(selectedFile);
			model = (Model)ModelCreating.createModelFromText(
					content, Activator.getDefault().getBundle(), 
					"models/expressions.etslt", 
					new EPackage[] { ExpressionsPackage.eINSTANCE },
					ExpressionsEditorDelegate.createExpressionsSemanticsProvider());
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
		System.out.println("Model: " + model);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object sel = ((IStructuredSelection)selection).getFirstElement();
			if (sel instanceof IFile) {
				selectedFile = (IFile)sel;
			}
		}
	}

}
