package editortest.model;

import cmof.common.ReflectiveCollection;
import cmof.reflection.Object;

public class MofModelElementImpl implements IModelElement {
	
	private final cmof.reflection.Object fObject;	

	public MofModelElementImpl(final cmof.reflection.Object object) {
		super();
		fObject = object;
	}

	public void addModelEventListener(ModelEventListener listener) {
		fObject.addListener(new PropertyChangeListenerWrapper(listener));
	}

	public java.lang.Object getValue(String property) {
		java.lang.Object result = fObject.get(property);
		if (result instanceof cmof.reflection.Object) {
			return new MofModelElementImpl((cmof.reflection.Object)result);
		} else if (result instanceof ReflectiveCollection) {
			return new MofSetImpl((ReflectiveCollection)result);
		} else {
			return result;
		}
	}

	public void setValue(String property, java.lang.Object value) {
		if (value instanceof MofModelElementImpl) {
			fObject.set(property, ((MofModelElementImpl)value).getMofObject());
		} else {
			fObject.set(property, value);
		}
	}
	
	public cmof.reflection.Object getMofObject() {
		return fObject;
	}
}
