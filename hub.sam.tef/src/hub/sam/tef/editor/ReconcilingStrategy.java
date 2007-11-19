package hub.sam.tef.editor;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.modelcreating.ModelChecker;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.Parser;
import hub.sam.tef.modelcreating.ParserError;
import hub.sam.tef.modelcreating.ParserSemantics;
import hub.sam.tef.modelcreating.ResolutionState;
import hub.sam.tef.semantics.AbstractError;

import java.util.Collection;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;

/**
 * This reconciling strategy is used for TEF text editors. It parsed the document text,
 * creates a model from it, resolve references, does model checking, and updates
 * the showed annotations to report errors to the user. The reconciler is
 * configured with the editors meta-model, syntax, and semantics.
 */
public class ReconcilingStrategy implements IReconcilingStrategy {

	private final Parser fParser;
	private final TextEditor fEditor;
		
	private IDocument document = null;
	private final ISourceViewer fSourceViewer;
	
	
	/**
	 * @param packages
	 *            is the meta-model.
	 * @param syntax
	 *            is the used syntax.
	 * @param semanticsProvider
	 *            a provider for the used semantics.
	 * @param sourceViewer
	 *            the sourceViewer that all reconciling results are reported to
	 *            as annotations.
	 */
	public ReconcilingStrategy(TextEditor editor, ISourceViewer sourceViewer) { 
		super();
		fEditor = editor;
		fSourceViewer = sourceViewer;
		fParser = new Parser(editor.getSyntax());	
	}

	/**
	 * Performs the actual reconciling.
	 */
	private void reconcileWithExceptions() throws ModelCreatingException {
		String text = document.get();
		ModelCreatingContext context = fEditor.createModelCreatingContext();
		context.initialise(new ResourceImpl(), text);

		ParserSemantics parserSemantics = new ParserSemantics(fEditor.getSyntax());
		boolean parseOk = fParser.parse(text, parserSemantics);
		
		if (!parseOk) {
			context.addError(new ParserError(fParser.getLastOffset()));
		} else {		
			ParseTreeNode parseResult = parserSemantics.getResult();
			EObject creationResult = null;

			creationResult = (EObject)parseResult.createModel(context, null);
			context.addToResource(creationResult);
			
			ResolutionState state = new ResolutionState(creationResult);
			parseResult.resolveModel(context, state);
			
			new ModelChecker().checkModel(creationResult, context);
		}
		
		// update annotations
		IAnnotationModel annotationModel = fSourceViewer.getAnnotationModel();		
		Collection<Annotation> annotations = fEditor.getAnnotations();
		for (Annotation annotation: annotations) {
			annotationModel.removeAnnotation(annotation);
		}
		annotations.clear();
		for (AbstractError error: context.getErrors()) {
			Annotation annotation = new ErrorAnnotation(error.getMessage());
			int offset = error.getPosition(context).getOffset();
			int length = error.getPosition(context).getLength();
			annotationModel.addAnnotation(annotation, new Position(offset, length));
			annotations.add(annotation);
		}
		
		if (parseOk) {
			fEditor.updateCurrentModel(context.getResource());
		}
	}
	
	private void reconcile() {
		try {
			reconcileWithExceptions();
		} catch (Throwable ex) {
			TEFPlugin.getDefault().getLog().log(new Status(Status.WARNING, TEFPlugin.PLUGIN_ID,
					Status.OK, "Reconciliation failed (" + ex.getMessage() + ")", ex));
			ex.printStackTrace(); // TODO debug out
		}
	}
	
	/**
	 * Delegator.
	 */
	@Override
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile();
	}

	/**
	 * Delegator.
	 */
	@Override
	public void reconcile(IRegion partition) {
		reconcile();
	}

	/**
	 * Sets the currently reconciled document and initially reconciles it.
	 */
	@Override
	public void setDocument(IDocument document) {
		this.document = document;
		reconcile();
	}
}
