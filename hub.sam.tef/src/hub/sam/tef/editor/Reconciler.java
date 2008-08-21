package hub.sam.tef.editor;

import hub.sam.tef.editor.text.TextEditor;

import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;

/**
 * This specific {@link MonoReconciler} allows to set the editor "dirty" when
 * reconciling starts. The {@link ReconcilingStrategy} has to un-"dirty" set it and
 * notify it about the change, because the UI thread might be waiting for it.
 */
public class Reconciler extends MonoReconciler {
	
	private final TextEditor fEditor;

	public Reconciler(TextEditor editor, IReconcilingStrategy strategy, boolean isIncremental) {
		super(strategy, isIncremental);
		fEditor = editor;
	}

	@Override
	protected void aboutToBeReconciled() {
		super.aboutToBeReconciled();
		fEditor.setReconciling(true);
	}	
}
