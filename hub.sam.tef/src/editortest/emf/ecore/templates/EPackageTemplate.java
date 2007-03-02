/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package editortest.emf.ecore.templates;

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
				new SequenceTemplate<IModelElement>(this, "eSubpackages", "\n", true, true) {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new EPackageTemplate(this);
					}	    			
	    		},
	    		new SequenceTemplate<IModelElement>(this, "eClassifiers", "\n", true, true) {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new ChoiceTemplate(this, getModel().getMetaElement("EClassifier")) {
							@Override
							public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
								return new ValueTemplate[] {
										new EClassTemplate(this),
										new EDataTypeTemplate(this)
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
		return false;
	}
}
