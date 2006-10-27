package editortest.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PropertyChangeListenerWrapper implements PropertyChangeListener {

	private final ModelEventListener fListener;

	public PropertyChangeListenerWrapper(final ModelEventListener listener) {
		super();
		fListener = listener;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		fListener.propertyChanged(evt.getNewValue(), evt.getPropertyName());		
	}		
	
}
