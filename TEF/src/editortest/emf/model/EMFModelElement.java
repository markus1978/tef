package editortest.emf.model;

import hub.sam.tef.models.AbstractModelElement;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.ModelEventListener;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


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
			case Notification.REMOVE:
			case Notification.SET:
				fListener.propertyChanged(EMFModelElement.this, ((EStructuralFeature)notification.getFeature()).getName());
				break;
			case Notification.REMOVING_ADAPTER:
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
	
	
	public void removeChangeListener(ModelEventListener listener) {
		int index = 0;		
		boolean hasListener = false;
		loop: for (Object o: fObject.eAdapters()) {
			if (o instanceof EMFListener) {
				if (((EMFListener)o).fListener.equals(listener)) {
					hasListener = true;
					break loop;
				}
			}
			index++;
		}
		if (hasListener) {
			fObject.eAdapters().remove(index);
		}
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
	
	protected EStructuralFeature getEMFFeatureForProperty(String property) {
		initializeFeatureMap();
		return featureMap.get(property);
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

	public EObject getEMFObject() {
		return fObject;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EMFModelElement) {
			return ((EMFModelElement)obj).fObject.equals(fObject);
		} else {
			return false;
		}
	}


	@Override
	public int hashCode() {
		return fObject.hashCode();
	}
	
	
}
