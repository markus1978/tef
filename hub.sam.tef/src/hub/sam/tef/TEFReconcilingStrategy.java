package hub.sam.tef;

import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.reconciliation.ReconciliationFailedException;
import hub.sam.tef.reconciliation.ReconciliationResults;
import hub.sam.tef.reconciliation.ReconciliationUnit;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.PlatformUI;

public class TEFReconcilingStrategy implements IReconcilingStrategy {	
	private TEFDocument fDocument;	
	private ReconciliationUnit fReconciliationUnit;
	
	
	public TEFReconcilingStrategy(final ISourceViewer viewer) {
		super();		
		fReconciliationUnit = new ReconciliationUnit();
		fDocument = (TEFDocument)viewer.getDocument();
	}

	public void reconcile()  {				
		if (fDocument.needsReconciling()) {			
			TEFPlugin.getDefault().getLog().log(new Status(Status.INFO,
					TEFPlugin.PLUGIN_ID, Status.OK, "reconciling, parsing", null));
			try {
				final ReconciliationResults result = fReconciliationUnit.run(fDocument);
				PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {				
					public void run() {			
						fDocument.setModelContent(result.getTopLevelTreeNode(), result.getTopLevelElement());
					}				
				});
			} catch (ReconciliationFailedException ex) {
				TEFPlugin.getDefault().getLog().log(new Status(Status.WARNING,
						TEFPlugin.PLUGIN_ID, Status.OK, 
						"reconciling failed: " + ex.getClass().getCanonicalName() + "[" + ex.getMessage() + "]",
						ex));				
			}
		}
	}	

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(dirtyRegion);
	}	
	
	public void reconcile(IRegion partition) {
		reconcile();
	}
	
	public void setDocument(IDocument document) {
		this.fDocument = (TEFDocument)document;		
	}

}
