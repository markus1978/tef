package editortest.emf.ecoretemplates;

import editortest.model.IModelElement;
import editortest.template.ChoiceTemplate;
import editortest.template.SequenceTemplate;
import editortest.template.Template;
import editortest.template.ValueTemplate;
import editortest.view.DocumentText;

public class EPackageTemplate extends EModelElementTemplate {
	
	public EPackageTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EPackage"));
	}
	
	public EPackageTemplate(DocumentText document) {
		super(document, document.getDocument().getModel().getMetaElement("EPackage"));
	}
	
	@Override
	public Template[] getContentsTemplates() {
		return new Template[] {
				new SequenceTemplate<IModelElement>(this, "eSubpackages", "\n", true) {
					@Override
					protected ValueTemplate createElementTemplate() {
						return new EPackageTemplate(this);
					}	    			
	    		},
	    		new SequenceTemplate<IModelElement>(this, "eClassifiers", "\n", true) {
					@Override
					protected ValueTemplate createElementTemplate() {
						return new ChoiceTemplate<IModelElement>(this) {
							@Override
							public ValueTemplate<? extends IModelElement>[] createAlternativeTemplates() {
								return new ValueTemplate[] {
										new EClassTemplate(this)
								};
							}							
						};
					}	    			
	    		}	    		
		};	    
	}

	@Override
	String getElementKeyWord() {
		return "package";
	}

	@Override
	Template[] getReferenceTemplates() {		
		return null;
	}		
}
