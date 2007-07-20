package hub.sam.tef.expressions;

import hub.sam.tef.annotations.IAnnotationModelProvider;
import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.expressions.templates.MyFucntionWithIdentifierTemplate;
import hub.sam.tef.expressions.templates.MyParameterIdentifierTemplate;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.tdl.Syntax;
import hub.sam.tef.tdl.delegators.TemplateFactory;
import hub.sam.tef.templates.Template;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

public class ExpressionsDocument extends TEFDocument {

	private final TemplateFactory templateFactory = new TemplateFactory();
	
	@Override
	protected AbstractLayoutManager createLayout() {
		return new ExpressionLayout();
	}
	
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
}
