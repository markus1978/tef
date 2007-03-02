package editortest.mof.template;

import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;

public abstract class MofNamedElementTemplate  extends ElementTemplate {

	public MofNamedElementTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);		
	}

	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}
}
