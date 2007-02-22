package hub.sam.tef.templates;

import hub.sam.tef.models.IType;

public abstract class PrimitiveValueTemplate<ModelType> extends ValueTemplate<ModelType> {

	public PrimitiveValueTemplate(Template template, IType type) {
		super(template, type);
	}


	@Override
	public final String[][] getRules() {	
		return new String[][] {};
	}	
	
}
