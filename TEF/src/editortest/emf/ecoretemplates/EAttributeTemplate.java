package editortest.emf.ecoretemplates;

import editortest.template.FlagTemplate;
import editortest.template.SingleValueTemplate;
import editortest.template.Template;
import editortest.template.ValueTemplate;

public class EAttributeTemplate extends EModelElementTemplate {

	public EAttributeTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EAttribute"));
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
	Template[] getContentsTemplates() {
		return null;
	}

	@Override
	String getElementKeyWord() {
		return "attribute";
	}

	@Override
	Template[] getReferenceTemplates() {		
		return new Template[] {};
	}

}
