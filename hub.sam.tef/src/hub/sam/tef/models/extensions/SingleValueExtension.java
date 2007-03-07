package hub.sam.tef.models.extensions;

public class SingleValueExtension extends Extension {
	private final Object fValue;
	private ModelElementExtension fExtension;	
	private final String fProperty;

	public SingleValueExtension(final Object value, ModelElementExtension extension, final String property) {
		super();
		fValue = value;
		fExtension = extension;
		fProperty = property;
	}

	@Override
	public Object getExtendedValue(Object originalValue) {
		if (originalValue == null) {
			return fValue;
		} else {
			// remove the extension because there is a real value
			fExtension.remove(fProperty);
			fExtension = null;
			return originalValue;
		}
	}	
	
}
