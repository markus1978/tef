package editortest.emf.ecoretemplates;

import editortest.model.IModelElement;
import editortest.template.ElementTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.SequenceTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;

public class EClassTemplate extends EModelElementTemplate {

	public EClassTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EClass")); 
	}

	@Override
	public Template[] getContentsTemplates() {
		return new Template[] {
				
		};
	}

	@Override
	String getElementKeyWord() {
		return "class";
	}

	@Override
	Template[] getReferenceTemplates() {
		return new Template[] {
			new TerminalTemplate(this, "superclass:["),
			new SequenceTemplate<IModelElement>(this, "eSuperTypes", ", ", false) {
				@Override
				protected ValueTemplate createElementTemplate() {
					return new ReferenceTemplate(this, getModel().getMetaElement("EClass"), null) {
						@Override
						protected ElementTemplate getElementTemplate() {
							return new EIdentifierTemplate(this);
						}							
					};
				}				
			},
			new TerminalTemplate(this, "]"),
		};
	}		
	
}
