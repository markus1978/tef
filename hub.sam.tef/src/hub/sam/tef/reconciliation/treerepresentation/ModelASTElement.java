package hub.sam.tef.reconciliation.treerepresentation;

import hub.sam.tef.emf.model.IOccurence;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.templates.Template;
import hub.sam.util.container.AbstractWatchedDisposable;

public class ModelASTElement extends AbstractWatchedDisposable implements IASTElement, IOccurence {

	private final IModelElement fModel;
	private final Template fTemplate;	
	
	private ASTElementNode fTreeRepresentation;
	
	public ModelASTElement(final Template template, final IModelElement fmodel) {
		super();
		this.fModel = fmodel;
		fTemplate = template;
	}
	
	public IModelElement getModelElement() {
		return fModel;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(fTemplate.getAdapter(ISyntaxProvider.class).getNonTerminal() + " ");
		return result.toString();
	}
	
	public String getSymbol() {
		return getSyntaxProvider().getNonTerminal();
	}

	public ISyntaxProvider getSyntaxProvider() {
		return fTemplate.getAdapter(ISyntaxProvider.class);
	}	

	public Template getTemplate() {
		return fTemplate;
	}

	public void setAST(ASTElementNode treeNode) {
		this.fTreeRepresentation = treeNode;	
	}

	public int getAbsolutOffset(int innerOffset) {
		return fTreeRepresentation.getAbsoluteOffset(innerOffset);
	}

	public int getLength() {	
		return fTreeRepresentation.getLength();
	}

	@Override
	public void dispose() {		
		super.dispose();
		fTreeRepresentation = null;		
	}

	public boolean isActive() {
		return fTreeRepresentation != null;
	}			
}
