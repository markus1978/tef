package editortest.mof.model;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;

public class MofModelElementImpl extends Mof implements IModelElement {
	
	private final cmof.reflection.Object fObject;	

	public MofModelElementImpl(final cmof.reflection.Object object) {
		super();
		fObject = object;
	}

	public void addChangeListener(ModelEventListener listener) {
		fObject.addListener(new PropertyChangeListenerWrapper(listener));
	}

	public java.lang.Object getValue(String property) {
		java.lang.Object result = fObject.get(property);
		return objectFromMofObject(result);
	}
	
	public IMetaModelElement getMetaElement() {
		return new MofMetaModelElementImpl(fObject.getMetaClass());
	}

	public void setValue(String property, java.lang.Object value) {
		fObject.set(property, mofObjectFromObject(value));
	}
	
	public cmof.reflection.Object getMofObject() {
		return fObject;
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
