package hub.sam.tef.pde;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewTefTextWizardFilePage extends WizardNewFileCreationPage {

	public NewTefTextWizardFilePage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);		
	}

	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			// Make sure the file ends in ".tslt" or ".etslt".			
			String enteredExt = new Path(getFileName()).getFileExtension();
			if (enteredExt == null || !(enteredExt.equals("tslt") || enteredExt.equals("etslt"))) {
				setErrorMessage("File extension must be .tslt or .etslt");
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
