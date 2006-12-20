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
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.LayoutElementTemplate;
import hub.sam.tef.templates.LayoutManager;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.views.DocumentText;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import editortest.emf.model.EMFMetaModelElement;

public abstract class EModelElementTemplate extends ElementTemplate {

	public EModelElementTemplate(DocumentText document, IMetaModelElement metaModel) {
		super(document, metaModel);
	}

	public EModelElementTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);
	}

	protected Template[] getAnnotationTemplates() {
		return new Template[] {
			new LayoutElementTemplate(this, LayoutManager.INDENT),
			new TerminalTemplate(this, "annotations"),
			new LayoutElementTemplate(this, LayoutManager.BEGIN_BLOCK),
			new TerminalTemplate(this, ": [\n"),
			new SequenceTemplate<IModelElement>(this, "eAnnotations", "\n", true) {
				@Override
				protected ValueTemplate<IModelElement> createElementTemplate() {
					return new EAnnotationTemplate(this);
				}
			},
			new LayoutElementTemplate(this, LayoutManager.END_BLOCK),
			new LayoutElementTemplate(this, LayoutManager.INDENT),
			new TerminalTemplate(this, "]")
		};
	}
	
	public Template[] getNameTemplates(boolean withComma) {
		return new Template[] {
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new IdentifierValueTemplate(this);
				}					
			},			
			(withComma) ?  new TerminalTemplate(this, ", ") : new TerminalTemplate(this, " ")
		};
	}
	
	@Override
	public Template[] createTemplates() {
		Collection<Template> templates = new Vector<Template>();
		templates.add(new LayoutElementTemplate(this, LayoutManager.INDENT));
		Template[] flags = getFlags();
		if (flags != null) {
			templates.addAll(Arrays.asList(flags));
		}
		templates.add(new TerminalTemplate(this, getElementKeyWord() + " ", 
				TerminalTemplate.KEY_WORD_HIGHLIGHT));
		Template[] references = getReferenceTemplates();
		templates.addAll(Arrays.asList(getNameTemplates(references != null)));		
		if (references != null) {
			templates.addAll((Arrays.asList(references)));		
		}
			
		Template[] contents = getContentsTemplates();			
		if (showAnnotations()) {
			templates.add(new TerminalTemplate(this, "\n"));
			templates.add(new LayoutElementTemplate(this, LayoutManager.BEGIN_BLOCK));
			templates.addAll(Arrays.asList(getAnnotationTemplates()));
			templates.add(new LayoutElementTemplate(this, LayoutManager.END_BLOCK));
		}
	    		
		if (contents != null) {
			templates.add(new TerminalTemplate(this, "\n"));
			templates.add(new LayoutElementTemplate(this, LayoutManager.INDENT));
			templates.add(new LayoutElementTemplate(this, LayoutManager.BEGIN_BLOCK, "{\n"));
			templates.addAll(Arrays.asList(contents));		    
		    templates.add(new LayoutElementTemplate(this, LayoutManager.END_BLOCK));
		    templates.add(new LayoutElementTemplate(this, LayoutManager.INDENT));
		    templates.add(new TerminalTemplate(this, "}"));			
		} 			
		return templates.toArray(new Template[]{});
	}
	
	abstract Template[] getFlags();	
	abstract String getElementKeyWord();
	abstract Template[] getReferenceTemplates();
	abstract Template[] getContentsTemplates();
	
	protected boolean showAnnotations() {
		return false;
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}
	
	protected static Template[] concat(Template[][] ts) {		
		Collection<Template> result = new Vector<Template>();
		for(Template[] t: ts) {
			for(Template s: t) {
				result.add(s);
			}
		}
		return result.toArray(new Template[]{});
	}

	@Override
	protected boolean isIdentifierProperty(String property) {
		return property.equals("name");
	}
	
	
}
