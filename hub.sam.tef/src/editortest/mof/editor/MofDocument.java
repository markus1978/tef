package editortest.mof.editor;

import hub.sam.tef.TEFModelDocument;
import hub.sam.tef.controllers.IAnnotationModelProvider;
import hub.sam.tef.controllers.ICursorPostionProvider;
import hub.sam.tef.templates.Template;
import hub.sam.tef.views.DocumentText;
import editortest.mof.template.MofTemplate;

public class MofDocument extends TEFModelDocument {
	
	@Override
	public void initializeDocument(DocumentText result) {
		result.addText(((MofTemplate)getTopLevelTemplate()).createText((getModel().getOutermostComposites())));
	}

	@Override
	public Template createTopLevelTemplate(IAnnotationModelProvider annotationModelProvider, ICursorPostionProvider cursorPositionProvider) {
		return new MofTemplate(annotationModelProvider, cursorPositionProvider, this);
	}

	
}
