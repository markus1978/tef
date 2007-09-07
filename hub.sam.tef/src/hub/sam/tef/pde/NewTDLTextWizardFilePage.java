package hub.sam.tef.pde;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewTDLTextWizardFilePage extends WizardNewFileCreationPage {

	public NewTDLTextWizardFilePage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);		
	}

	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			// Make sure the file ends in ".tdlt".
			String requiredExt = "tdlt";
			String enteredExt = new Path(getFileName()).getFileExtension();
			if (enteredExt == null || !enteredExt.equals(requiredExt)) {
				setErrorMessage("File extension must be .tdlt");
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
	
}
