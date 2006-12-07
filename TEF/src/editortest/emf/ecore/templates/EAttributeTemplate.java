package editortest.emf.ecore.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.FlagTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class EAttributeTemplate extends EModelElementTemplate {

	public EAttributeTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EReference"));
	}
	
	@Override
	Template[] getFlags() {		
		return new Template[] {
				new SingleValueTemplate<Boolean>(this, "derived") {
					@Override
					protected ValueTemplate<Boolean> createValueTemplate() {
						return new FlagTemplate(this, "isDerived");
					}					
				},
				new SingleValueTemplate<Boolean>(this, "changeable") {
					@Override
					protected ValueTemplate<Boolean> createValueTemplate() {
						return new FlagTemplate(this, "isChangeable");
					}					
				},
				new SingleValueTemplate<Boolean>(this, "transient") {
					@Override
					protected ValueTemplate<Boolean> createValueTemplate() {
						return new FlagTemplate(this, "isTransient");
					}					
				},
				new SingleValueTemplate<Boolean>(this, "unsettable") {
					@Override
					protected ValueTemplate<Boolean> createValueTemplate() {
						return new FlagTemplate(this, "isUnsettable");
					}					
				},
				new SingleValueTemplate<Boolean>(this, "volatile") {
					@Override
					protected ValueTemplate<Boolean> createValueTemplate() {
						return new FlagTemplate(this, "isVolatile");
					}					
				}
		};
	}
	
	@Override
	Template[] getReferenceTemplates() {
		return new Template[] {
			new TerminalTemplate(this, "type", TerminalTemplate.KEY_WORD_HIGHLIGHT),
			new TerminalTemplate(this, ":["),
			new SingleValueTemplate<IModelElement>(this, "eType") {
				@Override
				protected ValueTemplate createValueTemplate() {
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
	Template[] getContentsTemplates() {
		return null;
	}

	@Override
	String getElementKeyWord() {
		return "attribute";
	}

}
