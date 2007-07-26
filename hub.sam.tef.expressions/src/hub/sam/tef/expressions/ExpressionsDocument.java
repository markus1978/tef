package hub.sam.tef.expressions;

import hub.sam.tef.annotations.IAnnotationModelProvider;
import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.expressions.templates.MyFunctionWithIdentifierTemplate;
import hub.sam.tef.expressions.templates.MyFunctionCallTemplate;
import hub.sam.tef.expressions.templates.MyParameterIdentifierTemplate;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.tdl.Syntax;
import hub.sam.tef.tdl.TDLDocument;
import hub.sam.tef.tdl.TDLDocumentProvider;
import hub.sam.tef.tdl.TDLTextDocumentProvider;
import hub.sam.tef.tdl.delegators.TemplateFactory;
import hub.sam.tef.templates.Template;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

public class ExpressionsDocument extends TEFDocument {

	private final TemplateFactory templateFactory = new TemplateFactory();
	
	@Override
	protected AbstractLayoutManager createLayout() {
		return new ExpressionLayout();
	}
	
	/*
	// This is the code to use if you want to use a tdl model file.
	@Override
	protected Template createTopLevelTemplate(IAnnotationModelProvider annotationProvider) {	
		templateFactory.registerTemplateClass("FuncIdTpl", MyFucntionWithIdentifierTemplate.class);
		templateFactory.registerTemplateClass("ParamTpl", MyParameterIdentifierTemplate.class);
				
		EditingDomain editingDomain = ExpressionsDocumentProvider.getSharedEditingDomain();
		
		// put here your own syntax
		URI resourceId = URI.createURI("platform:/plugin/hub.sam.tef.expressions/models/expressions.tdl");		
		
		Resource resource = editingDomain.getResourceSet().getResource(resourceId, true);
		Syntax syntax = (Syntax)resource.getContents().iterator().next();		
		return templateFactory.createTemplate(getModelProvider(), syntax.getTopLevelTemplate());		
	}
	*/
	
	// This is the code to use if you want to use a tdlt text file.
	@Override
	protected Template createTopLevelTemplate(IAnnotationModelProvider annotationProvider) {	
		templateFactory.registerTemplateClass("FuncIdTpl", MyFunctionWithIdentifierTemplate.class);
		templateFactory.registerTemplateClass("FuncCallTpl", MyFunctionCallTemplate.class);
		templateFactory.registerTemplateClass("ParamTpl", MyParameterIdentifierTemplate.class);
				
		Syntax syntax = loadSyntax();		
		return templateFactory.createTemplate(getModelProvider(), syntax.getTopLevelTemplate());		
	}
	
	private Syntax loadSyntax() {
		TDLTextDocumentProvider documentProvide = new TDLTextDocumentProvider();
		TDLDocument document = (TDLDocument)documentProvide.createEmptyDocument();				
				
		// This is not really working because this is a path evaluated in the running eclipse workspace not
		// in the host eclipse workspace. 
		IFile tdlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("hub.sam.tef.expressions/models/expressions.tdlt"));

		URI resource = URI.createURI("platform:/plugin/hub.sam.tef.expressions/models/expressions.ecore");
		documentProvide.getSharedEditingDomain().getResourceSet().getResource(resource, true);		
		
		try {
			documentProvide.setDocumentContent(document, tdlFile, null);
		} catch (CoreException e) {
			throw new RuntimeException("could not load tdl file for this editor " + e.getMessage());			
		}
					
		IModelElement topLevelElement = document.getModelProvider().getTopLevelElement();
		if (topLevelElement != null) {
			return (Syntax)((EMFModelElement)topLevelElement).getEMFObject();
		} else {
			throw new RuntimeException("could not load tdl file for this editor.");
		}
	}
}
