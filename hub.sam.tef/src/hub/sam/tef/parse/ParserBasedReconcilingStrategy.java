package hub.sam.tef.parse;

import hub.sam.tef.TEFDocument;
import hub.sam.tef.models.IModel;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;

public class ParserBasedReconcilingStrategy implements IReconcilingStrategy {
	
	private TEFDocument document;	
	private ParserInterface fParserInterface;
	
	/**
	 * We ignore the dirtyRegion, because TEFDocuments keeps track of changes based on TEF-editing and
	 * text-editing, whereas dirtyRegion only includes text-editing.
	 */	
	public void reconcile(IRegion dirtyRegion)  {
		if (!document.isInTEFMode()) {
			if (getParserInterface().parse(document.getContent(), new EmptySemantic())) {
				// the current content can be parsed (contains no syntax errors)
				TextBasedAST oldAST = TextBasedAST.createASTTree(document.getModelDocument().getDocumentText());				
				UpdatedASTTreeSemantic semantic = new UpdatedASTTreeSemantic(oldAST, document.getChanges(), getParserInterface());
				getParserInterface().parse(document.getContent(), semantic);				
				TextBasedUpdatedAST newAST = semantic.getCurrentResult();
				newAST.topDownInclusionOfOldAST(oldAST);
				newAST.print(System.out);

				IModel model = document.getModelDocument().getModel();				
				model.getCommandFactory().remove(model.getOutermostCompositesOfEditedResource(), 
						model.getOutermostCompositesOfEditedResource().iterator().next()).execute();				
				document.getModelDocument().
						getTopLevelTemplate().executeASTSemantics(newAST, null, null, true, false);
				
			} else {
				System.out.println(document.getContent());
			}
		} else {
			// only normal changes, ignore them
			System.out.println("changes in TEF mode, ignored by reconciler");
		}
	}
	
	

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(dirtyRegion);
	}
	
	private ParserInterface getParserInterface() {
		if (fParserInterface == null) {
			fParserInterface = new ParserInterface(((TEFDocument)document).getModelDocument().getTopLevelTemplate()); 
		}
		return fParserInterface;
	}
	
	public void setDocument(IDocument document) {
		this.document = (TEFDocument)document;		
	}

}
