package hub.sam.tef.expressions;

import hub.sam.tef.annotations.IAnnotationModelProvider;
import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.expressions.templates.ModelTemplate;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.templates.Template;

public class ExpressionsDocument extends TEFDocument {

	@Override
	protected AbstractLayoutManager createLayout() {
		return new ExpressionLayout();
	}

	@Override
	protected Template createTopLevelTemplate(IAnnotationModelProvider annotationProvider) {
		return new ModelTemplate(getModelProvider());
	}
	
}
