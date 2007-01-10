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

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.FlagTemplate;
import hub.sam.tef.templates.IntegerTemplate;
import hub.sam.tef.templates.LayoutElementTemplate;
import hub.sam.tef.templates.LayoutManager;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.List;

import editortest.emf.model.EMFMetaModelElement;

public class EAttributeTemplate extends ElementTemplate {

	public EAttributeTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EAttribute"));
	}
	
	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new LayoutElementTemplate(this, LayoutManager.INDENT),				
				new TerminalTemplate(this,  "attribute ", TerminalTemplate.KEY_WORD_HIGHLIGHT),
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
				new SingleValueTemplate<Boolean>(this, "unsettable") {
					@Override
					protected ValueTemplate<Boolean> createValueTemplate() {
						return new FlagTemplate(this, "isUnsettable");
					}					
				},
				new SingleValueTemplate<String>(this, "eType") {
					@Override
					protected ValueTemplate createValueTemplate() {
						return new ReferenceTemplate(this, getModel().getMetaElement("EDataType"), null) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new EIdentifierTemplate(this);
							}						
						};
					}					
				},	
				new TerminalTemplate(this, "["),
				new SingleValueTemplate(this, "lowerBound") {
					@Override
					protected ValueTemplate<Integer> createValueTemplate() {
						return new IntegerTemplate(this, 0);
					}					
				},
				new TerminalTemplate(this, ".."),
				new SingleValueTemplate(this, "upperBound") {
					@Override
					protected ValueTemplate<Integer> createValueTemplate() {
						return new IntegerTemplate(this, 1);
					}					
				},
				new TerminalTemplate(this, "] "),				
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new IdentifierValueTemplate(this);
					}					
				}
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}

}