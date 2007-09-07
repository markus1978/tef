package hub.sam.tef.models.extensions;

import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelChangeListener;
import hub.sam.tef.models.IModelElementExtension;
import hub.sam.tef.models.ISequence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public abstract class ModelElementExtension implements IModelElementExtension {

	private Map<String, Extension> extensions;
	private Collection<IModelChangeListener> fListeners;
	
	private final Object id;	
	
	private static final Map<Object, Map<String, Extension>> allExtensions = new HashMap<Object, Map<String,Extension>>();
	private static final Map<Object, Collection<IModelChangeListener>> allListener = new HashMap<Object, Collection<IModelChangeListener>>();
	
	public ModelElementExtension(final Object id) {
		super();
		this.id = id;
		extensions = allExtensions.get(id);
		if (extensions == null) {
			extensions = new HashMap<String, Extension>();
			allExtensions.put(id, extensions);
		}
		fListeners = allListener.get(id);
		if (fListeners == null) {
			fListeners = new Vector<IModelChangeListener>();
			allListener.put(id, fListeners);
		}
	}

	public final void addChangeListener(IModelChangeListener listener) {
		addChangeListenerToPlatformElement(listener);
		fListeners.add(listener);
	}

	public final Object getValue(String property) {
		Object originalValue = getValueFromPlatformElement(property);
		Extension extension = extensions.get(property);
		if (originalValue == null) {
			if (extension == null) {
				return originalValue;
			} else {
				return extension.getExtendedValue(originalValue);
			}	
		} else if (originalValue instanceof ISequence) {
			if (extension == null) {
				extension = new SequenceExtension(this, property);
				extensions.put(property, extension);
			}
			return extension.getExtendedValue(originalValue);				
		} else if (originalValue instanceof ICollection) {
			if (extension == null) {
				extension = new CollectionExtension(this, property);
				extensions.put(property, extension);
			}
			return extension.getExtendedValue(originalValue);
		} else {
			if (extension == null) {
				return originalValue;
			} else {
				return extension.getExtendedValue(originalValue);
			}
		}		
	}

	public final void removeChangeListener(IModelChangeListener listener) {
		removeChangeListenerFromPlatformElement(listener);
		fListeners.remove(listener);
	}	
	
	public final void setValue(String property, Object value) {
		if (value instanceof InternalModelElement) {
			extensions.put(property, new SingleValueExtension(value, this, property));			
			for (IModelChangeListener listener: fListeners) {
				listener.propertyChanged(this, property);
			}
		} else {
			setValueToPlatformElement(property, value);
		}
	}
	
	protected void remove(String property) {
		extensions.remove(property);
	}
	
	protected abstract void addChangeListenerToPlatformElement(IModelChangeListener listener);
	protected abstract void removeChangeListenerFromPlatformElement(IModelChangeListener listener);
	protected abstract Object getValueFromPlatformElement(String property);
	protected abstract void setValueToPlatformElement(String property, Object value);

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ModelElementExtension) {
			return id.equals(((ModelElementExtension)obj).id);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	
}
 