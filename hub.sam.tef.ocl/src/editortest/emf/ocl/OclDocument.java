package editortest.emf.ocl;

import hub.sam.tef.annotations.IAnnotationModelProvider;
import hub.sam.tef.annotations.IChecker;
import hub.sam.tef.annotations.IIdentifierResolver;
import hub.sam.tef.completion.ICompletionComputer;
import hub.sam.tef.documents.DocumentModel;
import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.templates.Template;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import editortest.emf.ocl.annotations.OclChecker;
import editortest.emf.ocl.annotations.OclIdentifierResolver;
import editortest.emf.ocl.completion.OclCollectionOperationCompletion;
import editortest.emf.ocl.completion.OclOperationCallExpCompletion;
import editortest.emf.ocl.completion.OclPropertyCallExpCompletion;
import editortest.emf.ocl.completion.OclSingleIdentifierSchemeCompletion;
import editortest.emf.ocl.templates.ConstraintTemplate;

public class OclDocument extends TEFDocument {
	
	//private final OclChecker fChecker = new OclChecker();
	private final OclIdentifierResolver fIdentifierResolver = new OclIdentifierResolver();
	private final OclSingleIdentifierSchemeCompletion fSingleIdentifierSchemeCompletion = new OclSingleIdentifierSchemeCompletion();
	
	@Override
	public Template createTopLevelTemplate(IAnnotationModelProvider annotationModelProvider) {
		return new ConstraintTemplate(getModelProvider(), getModelProvider().getModel().getMetaElement("Constraint"));
	}

	public IIdentifierResolver getIdentityResolver() {
		return fIdentifierResolver;
	}
		
	public IChecker getChecker() {		
		//return fChecker;
		return null;
	}	

	@Override
	protected AbstractLayoutManager createLayout() {
		return new ExpressionLayout();
	}

	public Collection<ICompletionComputer> getCompletions() {
		Collection<ICompletionComputer> computers = new Vector<ICompletionComputer>();
		computers.add(new OclPropertyCallExpCompletion());
		computers.add(new OclOperationCallExpCompletion());
		computers.add(new OclCollectionOperationCompletion());
		computers.add(fSingleIdentifierSchemeCompletion);
		return computers;
	}
	
	public void setContext(EObject context) {		
		fIdentifierResolver.setContext(context);
		fSingleIdentifierSchemeCompletion.setContext(context);
		if (getModelProvider() != null) {
			((DocumentModel)getModelProvider()).reconcile();
		}
	}
}
