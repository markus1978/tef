package editortest.emf.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
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
	
	class EMFListener implements Adapter {		
		private final ModelEventListener fListener;
		private Notifier target = null;
		
		public EMFListener(final ModelEventListener listener) {
			super();
			fListener = listener;
		}

		public Notifier getTarget() {
			return target;
		}

		public boolean isAdapterForType(Object type) {			
			return false;
		}

		public void notifyChanged(Notification notification) {			
			switch (notification.getEventType()) {
			case Notification.ADD:
			case Notification.SET:
				fListener.propertyChanged(EMFModelElement.this, ((EStructuralFeature)notification.getFeature()).getName());
				break;
			default:
				System.err.println("Unhandles notification " + notification);
				break;
			}
		}

		public void setTarget(Notifier newTarget) {
			this.target = newTarget;
		}
		
	}

	public void addChangeListener(final ModelEventListener listener) {		
		Adapter emfListener = new EMFListener(listener);
		fObject.eAdapters().add(emfListener);
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
			return EMFModel.getModelForEMFObject(fObject.eGet(structuralFeature));
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
