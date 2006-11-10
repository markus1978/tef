package editortest.mof.template;

import editortest.model.IMetaModelElement;
import editortest.template.ElementTemplate;
import editortest.template.Template;

public abstract class MofNamedElementTemplate  extends ElementTemplate {

	public MofNamedElementTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);		
	}

	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}
}
