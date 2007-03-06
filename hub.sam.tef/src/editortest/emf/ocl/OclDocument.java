package editortest.emf.ocl;

import hub.sam.tef.TEFModelDocument;
import hub.sam.tef.controllers.IAnnotationModelProvider;
import hub.sam.tef.controllers.ICursorPostionProvider;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.FixText;
import editortest.emf.model.EMFModel;
import editortest.emf.model.EMFModelElement;
import editortest.emf.model.EMFSequence;
import editortest.emf.ocl.templates.ConstraintTemplate;

public class OclDocument extends TEFModelDocument {
	
	@Override
	public void initializeDocument(DocumentText result) {				
		ICollection<IModelElement> outermostComposites = getModel().getOutermostComposites();
		IModelElement topLevelExpression = null;
		for (IModelElement o: outermostComposites) {
			if (o.getMetaElement().equals(getModel().getMetaElement("Constraint"))) {
				topLevelExpression = o;
				result.addText(((ElementTemplate)getTopLevelTemplate()).getView(topLevelExpression, null));
				result.addText(new FixText("\n"));
			}
		}
		if (topLevelExpression == null) {
			topLevelExpression = ((EMFModel)getModel()).createElement(getModel().getMetaElement("Constraint"));
			((EMFSequence)getModel().getOutermostComposites()).getEMFObject().add(
					((EMFModelElement)topLevelExpression).getEMFObject());
			result.addText(((ElementTemplate)getTopLevelTemplate()).getView(topLevelExpression, null));
		}						
	}

	@Override
	public Template createTopLevelTemplate(IAnnotationModelProvider annotationModelProvider, ICursorPostionProvider cursorPositionProvider) {
		return new ConstraintTemplate(annotationModelProvider,
				cursorPositionProvider, this, getModel().getMetaElement("Constraint"));
	}
	
	
}
