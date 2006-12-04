package editortest.emf.expressions;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;

import editortest.emf.ecore.EMFDocumentProvider;
import editortest.emf.expressions.emfmodel.ExpressionsFactory;
import editortest.emf.expressions.emfmodel.ExpressionsPackage;
import editortest.emf.expressions.emfmodel.presentation.ExpressionsEditor;

public class ExpressionDocumentProvider extends EMFDocumentProvider {

	private final EPackage fExpressionsPackage = ExpressionsPackage.eINSTANCE;
	private final EFactory fExpressionsFactory = ExpressionsFactory.eINSTANCE;
	
	@Override
	protected EFactory getFactory() {
		return fExpressionsFactory;
	}
	@Override
	protected EPackage getPackage() {
		return fExpressionsPackage;
	}
	
	@Override
	protected IDocument createEmptyDocument()  {
		return new ExpressionDocument();		
	}
	
	@Override
	protected EditingDomain getEditingDomain() {
		return ExpressionsEditor.getSharedEditingDomain();
	}	
	
}
