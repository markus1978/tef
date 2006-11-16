package editortest.emf.model;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import editortest.model.ICollection;
import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;

public class EMFModel implements IModel {

	private final EFactory fFactory;
	private final EPackage fPacakge;
	private final Resource fResource;
	
	public EMFModel(final EFactory factory, final EPackage thePackage, final Resource resource) {
		super();
		fFactory = factory;
		fResource = resource;
		fPacakge = thePackage;
	}

	public IModelElement createElement(IMetaModelElement metaElement) {
		EObject result = fFactory.create(((EMFMetaModelElement)metaElement).getEMFObject());
		fResource.getContents().add(result);
		return new EMFModelElement(result);
	}

	public Iterable<IModelElement> getElements(IMetaModelElement metaElement) {
		// TODO performance !!!
		EList result = new BasicEList();
		Iterator iterator = fResource.getAllContents();
		while (iterator.hasNext()) {
			Object next = iterator.next();
			if (next instanceof EObject) {
				EObject nextObject = (EObject)next;
				if (nextObject.eClass().equals(((EMFMetaModelElement)metaElement).getEMFObject())) {
					result.add(nextObject);
				}
			}
		}
		return new EMFSequence(result);
	}

	public IMetaModelElement getMetaElement(String name) {		
		EClassifier classifier = fPacakge.getEClassifier(name);
		if (classifier instanceof EClass) {
			return new EMFMetaModelElement((EClass)classifier);
		} else {
			// TODO
			System.err.println("Non class meta-element requested.");
			return null;
		}
	}

	public ICollection getOutermostComposites() {
		TreeIterator iterator = fResource.getAllContents();
		EList result  = new BasicEList();
		iterator.prune();
		while(iterator.hasNext()) {
			result.add(iterator.next());
			iterator.prune();
		}
		return new EMFSequence(result);
	}

	protected static Object getModelForEMFObject(Object emfObject) {
		if (emfObject instanceof EObject) {
			return new EMFModelElement((EObject)emfObject);
		} else if (emfObject instanceof EList) {
			return new EMFSequence((EList)emfObject);
		} else {
			return emfObject;
		}
	}

	protected static Object getEMFObjectForModel(Object model) {
		if (model instanceof EMFModelElement) {
			return ((EMFModelElement)model).getEMFObject();
		} else if (model instanceof EMFSequence) {
			return ((EMFSequence)model).getEMFObject();
		} else {
			return model;
		}		
	}
}
