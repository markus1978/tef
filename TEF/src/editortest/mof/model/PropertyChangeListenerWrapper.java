package editortest.mof.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.swt.widgets.Listener;

import editortest.model.ModelEventListener;

public class PropertyChangeListenerWrapper implements PropertyChangeListener {

	private final ModelEventListener fListener;

	public PropertyChangeListenerWrapper(final ModelEventListener listener) {
		super();
		fListener = listener;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		Object value = evt.getNewValue();
		
		if (value instanceof cmof.reflection.Object) {
			value = new MofModelElementImpl((cmof.reflection.Object)value);
		}
		fListener.propertyChanged(value, evt.getPropertyName());		
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropertyChangeListenerWrapper) {
			return ((PropertyChangeListenerWrapper)obj).fListener.equals(fListener);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return fListener.hashCode();
	}		
	
	
	
}
