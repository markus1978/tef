package editortest.emf.ecore.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class EClassTemplate extends EModelElementTemplate {

	public EClassTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EClass")); 
	}

	@Override
	public Template[] getContentsTemplates() {
		return new Template[] {
				new SequenceTemplate<IModelElement>(this, "eStructuralFeatures", ";\n", true) {
					@Override					
					protected ValueTemplate createElementTemplate() {
						return new ChoiceTemplate<IModelElement>(this) {
							@Override
							public ValueTemplate<? extends IModelElement>[] createAlternativeTemplates() {
								return new ValueTemplate[] {
										new EAttributeTemplate(this)
								};
							}							
						};						
					}					
				}
		};
	}

	@Override
	String getElementKeyWord() {
		return "class";
	}

	@Override
	Template[] getReferenceTemplates() {
		return new Template[] {
			new TerminalTemplate(this, "superclass", TerminalTemplate.KEY_WORD_HIGHLIGHT),
			new TerminalTemplate(this, ":["),
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

	@Override
	Template[] getFlags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean showAnnotations() {
		return false;
	}			
}
