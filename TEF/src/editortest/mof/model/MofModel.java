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
package editortest.mof.model;

import hub.sam.mof.Repository;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.ICommandFactory;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;

import java.io.InputStream;

import cmof.Package;
import cmof.Property;
import cmof.UmlClass;
import cmof.cmofFactory;
import cmof.reflection.Extent;

public class MofModel implements IModel {
	
	public ICommandFactory getCommandFactory() {
		// TODO 
		return null;
	}

	private final Extent fExtent;
	private final cmofFactory fFactory;
	private final Package cmofPackage;
	
	public MofModel(InputStream input) {
		fExtent = Repository.getLocalRepository().createExtent("textExtent");
		
		cmofPackage = (Package)Repository.getLocalRepository().
						getExtent(Repository.CMOF_EXTENT_NAME).query("Package:cmof");
		fFactory = (cmofFactory)Repository.getLocalRepository().createFactory(fExtent, cmofPackage);
		try {
			Repository.getLocalRepository().loadXmiIntoExtent(fExtent, cmofPackage, input);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public MofModel() {
		fExtent = Repository.getLocalRepository().createExtent("textExtent");
		
		cmofPackage = (cmof.Package)Repository.getLocalRepository().
						getExtent(Repository.CMOF_EXTENT_NAME).query("Package:cmof");
		fFactory = (cmofFactory)Repository.getLocalRepository().createFactory(fExtent, cmofPackage);
		
		Package aPackage = fFactory.createPackage();
		aPackage.setName("APackage");
		UmlClass aClass = fFactory.createUmlClass();
		aClass.setPackage(aPackage);
		aClass.setName("EineKlasseNamensBernt");
		Property aProperty = fFactory.createProperty();
		aProperty.setName("selfReference");
		aProperty.setType(aClass);
		aClass.getOwnedAttribute().add(aProperty);		
	}	
	
	public ICollection getOutermostComposites() {
		return new MofSetImpl(fExtent.outermostComposites());
	}
	
	private cmofFactory getFactory() {
		return fFactory;
	}
	
	public Extent getExtent() {
		return fExtent;
	}
	
	public Package getMetaModel() {
		return cmofPackage;
	}
	
	public IMetaModelElement getMetaElement(String name) {
		UmlClass result = (UmlClass)Repository.getLocalRepository().getExtent(Repository.CMOF_EXTENT_NAME).
				query("Package:cmof/Class:" + name);
		if (result == null) {
			throw new RuntimeException("assert");
		}
		return new MofMetaModelElementImpl(result);
	}

	public IModelElement createElement(IMetaModelElement metaElement) {
		return new MofModelElementImpl(getFactory().create(
				((MofMetaModelElementImpl)metaElement).getMofElement()));
	}

	public Iterable<IModelElement> getElements(IMetaModelElement metaElement) {
		return new MofSetImpl(getExtent().objectsOfType(
				((MofMetaModelElementImpl)metaElement).getMofElement(), 
				true));
	}		
}
