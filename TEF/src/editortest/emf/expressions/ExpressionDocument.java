package editortest.emf.expressions;

import hub.sam.tef.TEFDocument;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.FixText;
import editortest.emf.ecoretemplates.EPackageTemplate;
import editortest.emf.expressions.templates.ParenthesisTemplate;
import editortest.emf.model.EMFModel;
import editortest.emf.model.EMFModelElement;
import editortest.emf.model.EMFSequence;

public class ExpressionDocument extends TEFDocument {

	@Override
	public DocumentText createDocument() {
		DocumentText result = new DocumentText(this);
		ICollection<IModelElement> outermostComposites = getModel().getOutermostComposites();
		IModelElement topLevelExpression = null;
		for (IModelElement o: outermostComposites) {
			if (o.getMetaElement().equals(getModel().getMetaElement("Parenthesis"))) {
				topLevelExpression = o;
				result.addText(new ParenthesisTemplate(result, getModel().getMetaElement("Parenthesis")).createView(topLevelExpression));
				result.addText(new FixText("\n"));
			}
		}
		if (topLevelExpression == null) {
			topLevelExpression = ((EMFModel)getModel()).createElement(getModel().getMetaElement("Parenthesis"));
			((EMFSequence)getModel().getOutermostComposites()).getEMFObject().add(
					((EMFModelElement)topLevelExpression).getEMFObject());
			result.addText(new ParenthesisTemplate(result, getModel().getMetaElement("Parenthesis")).
					createView(topLevelExpression));
		}		
		return result;
	}

	
}
