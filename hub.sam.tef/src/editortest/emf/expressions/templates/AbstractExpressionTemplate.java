package editortest.emf.expressions.templates;

import hub.sam.tef.controllers.IAnnotationModelProvider;
import hub.sam.tef.controllers.ICursorPostionProvider;
import hub.sam.tef.controllers.IModelRepresentationProvider;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public abstract class AbstractExpressionTemplate extends ElementTemplate {

	
	public AbstractExpressionTemplate(IAnnotationModelProvider annotationModelProvider, 
			ICursorPostionProvider cursorPositionProvider, IModelRepresentationProvider modelProvider, IMetaModelElement metaModel) {
		super(annotationModelProvider, cursorPositionProvider, modelProvider, metaModel);	
	}

	public AbstractExpressionTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);
	}

	protected ValueTemplate<IModelElement> getExpressionTemplate() {
		//return new LiveParseTemplate(this);
		return new ExpressionTemplate(this);
	};
	
}
