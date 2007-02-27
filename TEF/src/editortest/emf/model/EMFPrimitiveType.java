package editortest.emf.model;

import hub.sam.tef.models.IType;

public class EMFPrimitiveType implements IType {

	private final Class fClass;

	public EMFPrimitiveType(final Class theClass) {
		super();
		fClass = theClass;
	}

	@Override
	public String toString() {	
		return fClass.getSimpleName();
	}

}
