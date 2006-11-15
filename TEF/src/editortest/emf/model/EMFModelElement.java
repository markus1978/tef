package editortest.emf.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import editortest.model.AbstractModelElement;
import editortest.model.IMetaModelElement;
import editortest.model.ModelEventListener;

public class EMFModelElement  extends AbstractModelElement {

	private final EObject fObject;
	
	public EMFModelElement(final EObject object) {
		super();
		fObject = object;
	}

	public void addChangeListener(ModelEventListener listener) {
		// TODO Auto-generated method stub		
	}

	public void delete() {
		// empty		
	}

	public IMetaModelElement getMetaElement() {
		return new EMFMetaModelElement(fObject.eClass());
	}

	private Map<String, EStructuralFeature> featureMap = null;
	
	private void initializeFeatureMap() {
		if (featureMap == null) {
			featureMap = new HashMap<String, EStructuralFeature>();
			for (Object structuralFeatureAsObject: fObject.eClass().getEAllStructuralFeatures()) {
				EStructuralFeature structuralFeature = (EStructuralFeature)structuralFeatureAsObject;
				featureMap.put(structuralFeature.getName(), structuralFeature);
			}	
		}
	}
	
	public Object getValue(String property) {
		initializeFeatureMap();
		EStructuralFeature structuralFeature = featureMap.get(property);
		if (structuralFeature == null) {
			return null; // TODO
		} else {
			return fObject.eGet(structuralFeature);
		}
	}

	public void setValue(String property, Object value) {
		initializeFeatureMap();
		EStructuralFeature structuralFeature = featureMap.get(property);
		if (structuralFeature == null) {
			// TODO
		} else {
			fObject.eSet(structuralFeature, EMFModel.getEMFObjectForModel(value));
		}
	}
	
	protected EObject getEMFObject() {
		return fObject;
	}
}
