package hub.sam.tef.tdl;

import hub.sam.tef.annotations.IAnnotationModelProvider;
import hub.sam.tef.annotations.IIdentifierResolver;
import hub.sam.tef.documents.TEFDocument;
import hub.sam.tef.emf.EMFIdentifierResolver;
import hub.sam.tef.layout.AbstractLayoutManager;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.tdl.templates.SyntaxTemplate;
import hub.sam.tef.templates.Template;

public class TDLDocument extends TEFDocument {

	@Override
	protected AbstractLayoutManager createLayout() {
		return new BlockLayout();
	}	

	@Override
	public IIdentifierResolver getIdentityResolver() {
		return new EMFIdentifierResolver();
	}

	@Override
	protected Template createTopLevelTemplate(IAnnotationModelProvider annotationProvider) {
		return new SyntaxTemplate(getModelProvider());
	}	
}
