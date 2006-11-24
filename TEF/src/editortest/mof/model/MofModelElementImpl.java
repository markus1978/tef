package editortest.mof.model;

import hub.sam.tef.models.AbstractModelElement;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.ModelEventListener;

import java.beans.PropertyChangeListener;


public class MofModelElementImpl extends AbstractModelElement {
	
	private final cmof.reflection.Object fObject;	

	public MofModelElementImpl(final cmof.reflection.Object object) {
		super();
		fObject = object;
	}

	public void addChangeListener(ModelEventListener listener) {
		fObject.addListener(new PropertyChangeListenerWrapper(listener));
	}

	public void removeChangeListener(ModelEventListener listener) {
		fObject.removeListener(new PropertyChangeListenerWrapper(listener));		
	}

	public java.lang.Object getValue(String property) {
		java.lang.Object result = fObject.get(property);
		return Mof.objectFromMofObject(result);
	}
	
	public IMetaModelElement getMetaElement() {
		return new MofMetaModelElementImpl(fObject.getMetaClass());
	}

	public void setValue(String property, java.lang.Object value) {
		fObject.set(property, Mof.mofObjectFromObject(value));
	}
	
	public cmof.reflection.Object getMofObject() {
		return fObject;
	}

	
	public void delete() {
		fObject.delete();	
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MofModelElementImpl) {
			return fObject.equals(((MofModelElementImpl)obj).fObject);
		} else {
			return false;
		}
	}	

	@Override
	public int hashCode() {
		return fObject.hashCode();
	}
}
