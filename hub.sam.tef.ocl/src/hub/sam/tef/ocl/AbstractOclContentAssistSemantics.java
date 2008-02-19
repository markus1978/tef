package hub.sam.tef.ocl;

/**
 * An abstract content assist semantics. It saves a reference to an
 * OclEditorDelegate, which maintaintes an OCL context and environment factory.
 */
public class AbstractOclContentAssistSemantics {

	protected final OclTextEditor fEditor;

	public AbstractOclContentAssistSemantics(OclTextEditor editor) {
		super();
		fEditor = editor;
	}	
}
