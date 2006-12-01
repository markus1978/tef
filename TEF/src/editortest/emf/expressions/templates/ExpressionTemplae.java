package editortest.emf.expressions.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.Template;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.Text;
import editortest.emf.expressions.LiveParseText;

public class ExpressionTemplae extends Template {

	public ExpressionTemplae(DocumentText document) {
		super(document);
	}

	public ExpressionTemplae(Template template) {
		super(template);	
	}
	
	public Text createView(IModelElement parent) {		
		Text result = new LiveParseText();
		result.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));
		return result;
	}
	
}
