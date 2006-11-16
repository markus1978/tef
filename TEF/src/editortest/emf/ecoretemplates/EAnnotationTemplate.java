package editortest.emf.ecoretemplates;

import editortest.model.IModelElement;
import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.ValueTemplate;
import editortest.template.whitespaces.LayoutElementTemplate;
import editortest.template.whitespaces.LayoutManager;

public class EAnnotationTemplate extends EModelElementTemplate {

	public EAnnotationTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EAnnotation"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new LayoutElementTemplate(this, LayoutManager.INDENT),
			new SingleValueTemplate<String>(this, "source") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new StringTemplate(this);
				}					
			}
		};
	}

	@Override
	public boolean isTemplateFor(IModelElement model) {
		return model.getMetaElement().equals(getModel().getMetaElement("EAnnotation"));
	}
}
