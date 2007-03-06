package hub.sam.tef;

import hub.sam.tef.parse.ParserBasedReconcilingStrategy;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.reconciler.AbstractReconciler;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;

public class TEFReconciler extends AbstractReconciler {

	private final IReconcilingStrategy fParserBasedReconcilingStrategy = new ParserBasedReconcilingStrategy();	
	
	private TEFDocument document = null;

	@Override
	protected void process(DirtyRegion dirtyRegion) {
		if (!document.isInTEFMode()) {
			fParserBasedReconcilingStrategy.reconcile(dirtyRegion, null);
		}
	}

	@Override
	protected void reconcilerDocumentChanged(IDocument newDocument) {
		document = (TEFDocument)newDocument;
		fParserBasedReconcilingStrategy.setDocument(newDocument);
	}

	public IReconcilingStrategy getReconcilingStrategy(String contentType) {
		throw new RuntimeException("assert");
	}

}
