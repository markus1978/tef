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

public class EDataTypeTemplate extends ElementTemplate {

	public EDataTypeTemplate (Template template) {
		super(template, template.getModel().getMetaElement("EDataType"));
	}
	
	@Override
	public Template[] createTemplates() {
		return new Template[] {			
				new LayoutElementTemplate(this, LayoutManager.INDENT),	
				new TerminalTemplate(this, "data type", TerminalTemplate.KEY_WORD_HIGHLIGHT),	
				new TerminalTemplate(this, " "),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new IdentifierValueTemplate(this);
					}					
				},
				new TerminalTemplate(this, ";")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}

	@Override
	protected boolean isIdentifierProperty(String property) {
		return property.equals("name");
	}
}
