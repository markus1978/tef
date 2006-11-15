package editortest.emf.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;

import cmof.reflection.Factory;

import editortest.model.ICollection;
import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;

public class EMFModel implements IModel {

	private final EFactory fFactory;
	
	public EMFModel(final EFactory factory) {
		super();
		fFactory = factory;
	}

	public IModelElement createElement(IMetaModelElement metaElement) {
		return new EMFModelElement(fFactory.create(((EMFMetaModelElement)metaElement).getEMFObject()));
	}

	public Iterable<IModelElement> getElements(IMetaModelElement metaElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public IMetaModelElement getMetaElement(String name) {		
		// TODO Auto-generated method stub
		return null;
	}

	public ICollection getOutermostComposites() {
		// TODO Auto-generated method stub
		return null;
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
