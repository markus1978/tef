package editortest.emf.ocl.templates;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.OptionalTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.views.DocumentText;

public class ConstraintTemplate  extends ElementTemplate {
	
	public ConstraintTemplate(DocumentText document, IMetaModelElement metaModel) {
		super(document, metaModel);	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new OptionalTemplate<IModelElement>(this, "body") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new OclExpressionTemplate(this);
					}				
				}
		};
	}
	
}
