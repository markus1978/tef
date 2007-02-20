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
				new SequenceTemplate<IModelElement>(this, "eStructuralFeatures", ";\n", true, true) {
					@Override					
					protected ValueTemplate createElementTemplate() {
						return new ChoiceTemplate<IModelElement>(this, getModel().getMetaElement("EStructuralFeature")) {
							@Override
							public ValueTemplate<? extends IModelElement>[] createAlternativeTemplates() {
								return new ValueTemplate[] {
										new EReferenceTemplate(this),
										new EAttributeTemplate(this)
								};
							}							
						};						
					}					
				},
				new SequenceTemplate<IModelElement>(this, "eOperations", ";\n", true, true) {
					@Override					
					protected ValueTemplate createElementTemplate() {
						return new ChoiceTemplate<IModelElement>(this, getModel().getMetaElement("EOperation")) {
							@Override
							public ValueTemplate<? extends IModelElement>[] createAlternativeTemplates() {
								return new ValueTemplate[] {
										new EOperationTemplate(this)
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
