package editortest.emf.ecoretemplates;

import editortest.model.IModelElement;
import editortest.mof.template.MofIdentifierTemplate;
import editortest.template.ElementTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.SequenceTemplate;
import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
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
			new TerminalTemplate(this, "source: "),
			new SingleValueTemplate<String>(this, "source") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new StringTemplate(this);
				}					
			},
			new TerminalTemplate(this, ", "),	
			new TerminalTemplate(this, "references: ["),
			new SequenceTemplate<IModelElement>(this, "references", ", ", false) {
				@Override
				protected ValueTemplate createElementTemplate() {
					return new ReferenceTemplate(this, getModel().getMetaElement("EModelElement"), null) {
						@Override
						protected ElementTemplate getElementTemplate() {
							return new EIdentifierTemplate(this);
						}							
					};
				}				
			},
			new TerminalTemplate(this, "]")			
		};
	}

	@Override
	public boolean isTemplateFor(IModelElement model) {
		return model.getMetaElement().equals(getModel().getMetaElement("EAnnotation"));
	}
}
