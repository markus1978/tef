package editortest.emf.ecoretemplates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.views.DocumentText;

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

	@Override
	Template[] getFlags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean showAnnotations() {
		return true;
	}
}
