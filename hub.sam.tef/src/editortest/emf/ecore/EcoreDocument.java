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
package editortest.emf.ecore;

import hub.sam.tef.TEFModelDocument;
import hub.sam.tef.controllers.IAnnotationModelProvider;
import hub.sam.tef.controllers.ICursorPostionProvider;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.FixText;
import editortest.emf.ecore.templates.EPackageTemplate;
import editortest.emf.model.EMFModel;
import editortest.emf.model.EMFModelElement;
import editortest.emf.model.EMFSequence;

public class EcoreDocument extends TEFModelDocument {

	@Override
	public void initializeDocument(DocumentText result) {

		ICollection<IModelElement> outermostComposites = getModel().getOutermostComposites(getResource());
		IModelElement topLevelPackage = null;
		for (IModelElement o: outermostComposites) {
			if (o.getMetaElement().equals(getModel().getMetaElement("EPackage"))) {
				topLevelPackage = o;
				result.addText(((ElementTemplate)getTopLevelTemplate()).getView(topLevelPackage, null));
				result.addText(new FixText("\n"));
			}
		}
		if (topLevelPackage == null) {
			topLevelPackage = ((EMFModel)getModel()).createElement(getModel().getMetaElement("EPackage"));
			((EMFSequence)getModel().getOutermostComposites(getResource())).getEMFObject().add(
					((EMFModelElement)topLevelPackage).getEMFObject());
			result.addText(((ElementTemplate)getTopLevelTemplate()).getView(topLevelPackage, null));
		}		
	}

	@Override
	public Template createTopLevelTemplate(IAnnotationModelProvider annotationModelProvider, ICursorPostionProvider cursorPositionProvider) {
		return new EPackageTemplate(annotationModelProvider, cursorPositionProvider, this);
	}

}
