package editortest.emf.expressions;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.IDocument;

import editortest.emf.editor.EMFDocumentProvider;
import editortest.emf.editor.EcoreDocument;
import editortest.emf.expressions.emfmodel.ExpressionsFactory;
import editortest.emf.expressions.emfmodel.ExpressionsPackage;;

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
}
