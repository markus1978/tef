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
package hub.sam.tef.emf.model;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.models.AbstractModel;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.ICommandFactory;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IType;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

public class EMFModel extends AbstractModel {
	
	private final Map<EPackage, EFactory> fFactorys;
	private final Collection<EPackage> fPackage;
	private final Resource fResource;	// TODO this resource is the only one that elements can be created in
	private final EditingDomain fDomain;
	
	public EMFModel(final EFactory factory, final EPackage thePackage,
			final Resource resource, final EditingDomain editingDomain) {
		super(resource.getURI());
		fFactorys = new HashMap<EPackage, EFactory>();
		fFactorys.put(thePackage, factory);
		fResource = resource;
		fPackage = new Vector<EPackage>();
		fPackage.add(thePackage);				
		fDomain = editingDomain;		
	}
	
	public EMFModel(final Iterable<EFactory> factories, final Iterable<EPackage> packages,
			final Resource resource, final EditingDomain editingDomain) {
		super(resource.getURI());
		fFactorys = new HashMap<EPackage, EFactory>();				
		fPackage = new Vector<EPackage>();
		Iterator<EFactory> factoriesIt = factories.iterator();
		for (EPackage aPackage: packages) {
			fPackage.add(aPackage);
			fFactorys.put(aPackage, factoriesIt.next());
		}
		fResource = resource;		
		fDomain = editingDomain;		
	}

	@Override
	protected ICommandFactory createCommandFactory() {
		return new EMFCommandFactory(fDomain, this);
	}

	public IModelElement createElement(IMetaModelElement metaElement) {
		EClass eMetaElement = ((EMFMetaModelElement)metaElement).getEMFObject();
		EObject result = fFactorys.get(eMetaElement.getEPackage()).create(eMetaElement);		
		fResource.getContents().add(result);		
		return new EMFModelElement(result);
	}

	public Iterable<IModelElement> getElements(IMetaModelElement metaElement) {
		return getElements(metaElement, null);
	}	

	public Iterable<IModelElement> getElements(IMetaModelElement metaElement, Object resourceFilter) {
		// TODO performance !!!		
		Collection<Resource> filteredResources = new Vector<Resource>();
		for (Object resource: fDomain.getResourceSet().getResources()) {
			if (resourceFilter == null || !((Resource)resource).getURI().equals((URI)resourceFilter)) {
				filteredResources.add((Resource)resource);				
			}
		}
		
		EList result = new BasicEList();		
		for (Resource resource: filteredResources) {
			Iterator iterator = resource.getAllContents();
			
			while (iterator.hasNext()) {
				Object next = iterator.next();
				if (next instanceof EObject) {
					EObject nextObject = (EObject)next;
					
					if (((EClass)((EMFMetaModelElement)metaElement).getEMFObject()).isSuperTypeOf(nextObject.eClass())) {														
						result.add(nextObject);	
					}				
				}
			}			
		}
		return new EMFSequence(result);
	}

	public IMetaModelElement getMetaElement(String name) {
		for (EPackage aPackage: fPackage) {
			EClassifier classifier = aPackage.getEClassifier(name);
			if (classifier != null) {
				if (classifier instanceof EClass) {
					// TODO elements with same name in different packages
					return new EMFMetaModelElement((EClass)classifier);
				} else {
					// TODO
					TEFPlugin.getDefault().getLog().log(
							new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
									Status.CANCEL, "Non class meta-element requested.", null));
					return null;
				}
			}
		}
		TEFPlugin.getDefault().getLog().log(
				new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
						Status.CANCEL, "Non class meta-element requested.", null));
		return null;
	}

	public ICollection getOutermostComposites(Object resourceId) {
		Resource resource = fDomain.getResourceSet().getResource((URI)resourceId, false);
		if (resource != null) {
			return new EMFSequence(resource.getContents());
		} else {
			return new EMFSequence(new BasicEList());
		}
	}

	public static Object getModelForEMFObject(Object emfObject) {
		if (emfObject instanceof EObject) {
			return new EMFModelElement((EObject)emfObject);
		} else if (emfObject instanceof EList) {
			return new EMFSequence((EList)emfObject);
		} else {
			return emfObject;
		}
	}

	public static Object getEMFObjectForModel(Object model) {
		if (model instanceof EMFModelElement) {
			return ((EMFModelElement)model).getEMFObject();
		} else if (model instanceof EMFSequence) {
			return ((EMFSequence)model).getEMFObject();
		} else {
			return model;
		}		
	}

	public IType getType(Class theTypesJavaClass) {
		return new EMFPrimitiveType(theTypesJavaClass);
	}

	public IType getType(String name) {
		return getMetaElement(name);
	}	

	public void dispose() {
		fDomain.getResourceSet().getResources().remove(fResource);
	}

	public boolean isActive() {
		return true;
	}

	public EditingDomain getDomain() {
		return fDomain;
	}	
	
}
