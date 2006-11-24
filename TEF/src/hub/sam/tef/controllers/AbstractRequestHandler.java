package hub.sam.tef.controllers;

import hub.sam.tef.models.IModelElement;

public class AbstractRequestHandler<ElementType> {

	private final IModelElement fOwner;
	private final String fProperty;
	private final ElementType fValue;
	
	public AbstractRequestHandler(final IModelElement owner, final String property, final ElementType value) {
		super();
		fOwner = owner;
		fProperty = property;
		fValue = value;
	}

	public IModelElement getOwner() {
		return fOwner;
	}

	public String getProperty() {
		return fProperty;
	}

	public ElementType getValue() {
		return fValue;
	}
	
	
}
