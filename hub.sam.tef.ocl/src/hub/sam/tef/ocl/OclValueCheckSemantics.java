/**
 * 
 */
package hub.sam.tef.ocl;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.tsl.ElementBinding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.helper.OCLParsingException;
import org.eclipse.jface.text.Position;

public class OclValueCheckSemantics implements IValueCheckSemantics {
	
	private final OclTextEditor fEditor;
	private IOCLHelper fOclHelper = null;
	
	public OclValueCheckSemantics(OclTextEditor editor) {
		super();
		fEditor = editor;
	}
	
	private void initialize() {
		if (fOclHelper == null) {
			fOclHelper = HelperUtil.createOCLHelper(fEditor.getEnvironmentFactory());			
		}
	}

	public void check(ParseTreeNode parseTreeNode,
			IModelCreatingContext context, EObject value,
			ElementBinding binding) throws ModelCreatingException {

		
		if (value.eContainer() != null) {
			return;
		}
		
		initialize();
		fOclHelper.setContext(fEditor.getContext());
						
		String text = context.getText();
		try {			
			fOclHelper.createInvariant(text);
		} catch (OCLParsingException e) {
			context.addError(new Error(
					new Position(0, text.length()), e.getMessage()));
		}				
	}
}