package hub.sam.tef.parse;

import hub.sam.tef.TEFDocument;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.reconciler.AbstractReconciler;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;

public class TEFReconciler extends AbstractReconciler {
	
	private TEFDocument document;	
	private ParserInterface parser;
	
	/**
	 * We ignore the dirtyRegion, because TEFDocuments keeps track of changes based on TEF-editing and
	 * text-editing, whereas dirtyRegion only includes text-editing.
	 */
	@Override
	protected void process(DirtyRegion dirtyRegion)  {
		if (!document.isInTEFMode()) {
			if (parser.parse(document.getContent(), new EmptySemantic())) {
				// the current content can be parsed (contains no syntax errors)
				TextBasedAST oldAST = TextBasedAST.createASTTree(document.getDocument());
				UpdatedASTTreeSemantic semantic = new UpdatedASTTreeSemantic(oldAST, document.getChanges());
				parser.parse(document.getContent(), semantic);
				TextBasedUpdatedAST newAST = semantic.getCurrentResult().getChildNodes().get(0); // remove the start node				
				//newAST.print(System.out);
				newAST.topDownInclusionOfOldAST(oldAST);
				newAST.print(System.out);
				
				/*
				ParseAlongTreeSemantic parseAlong = new ParseAlongTreeSemantic(
						TextBasedAST.createASTTree(document.getDocument()));
				parser.parse(document.getContent(), parseAlong);
				
				if (parseAlong.isOk()) {
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
						public void run() {										
							document.switchModes(true);
						}				
					});
					
				} else {
					System.out.println("parseAlong was not ok");
				}
				*/
			} else {
				System.out.println(document.getContent());
			}
		} else {
			// only normal changes, ignore them
			System.out.println("changes in TEF mode, ignored by reconciler");
		}
	}

	/**
	 * This method is used to give the renciler an update of the document when it has changed. Reason
	 * is that this reconciler is used for all editors.
	 */
	@Override
	protected void reconcilerDocumentChanged(IDocument newDocument) {
		this.document = (TEFDocument)newDocument;
		parser = new ParserInterface(document.getTopLevelTemplate());
	}

	/**
	 * We only have one strategy no matter what content type. This strategy is processed right here.
	 */
	public IReconcilingStrategy getReconcilingStrategy(String contentType) {		
		return null;
	}

}
