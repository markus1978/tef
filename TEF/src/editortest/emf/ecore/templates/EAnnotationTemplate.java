package editortest.emf.ecore.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.LayoutElementTemplate;
import hub.sam.tef.templates.LayoutManager;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import editortest.mof.template.MofIdentifierTemplate;

public class EAnnotationTemplate extends EModelElementTemplate {

	public EAnnotationTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EAnnotation"));
	}

	@Override
	public Template[] getNameTemplates() {
		return new Template[] {			
			new TerminalTemplate(this, "source: "),
			new SingleValueTemplate<String>(this, "source") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new StringTemplate(this);
				}					
			},						
		};
	}
	
	@Override
	Template[] getContentsTemplates() {	
		return null;
	}

	@Override
	String getElementKeyWord() {
		return "annotation";
	}

	@Override
	Template[] getReferenceTemplates() {
		return new Template[] {
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

	@Override
	Template[] getFlags() {	
		return null;
	}
}
