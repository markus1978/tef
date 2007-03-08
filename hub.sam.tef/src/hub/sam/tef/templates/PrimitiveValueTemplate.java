package hub.sam.tef.templates;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IType;

public abstract class PrimitiveValueTemplate<ModelType> extends ValueTemplate<ModelType> {

	public PrimitiveValueTemplate(Template template, IType type) {
		super(template, type);
	}

	@Override
	public final String[][] getRules() {	
		return new String[][] {};
	}	

	public void executeASTSemantics(String value, IModelElement owner, String property, boolean isCollection) {
		throw new RuntimeException("assert");
	}		
	
	protected final void executeASTSemanticsWithConvertedValue(Object convertedValue, IModelElement owner, String property, boolean isCollection) {
		if (isCollection) {
			getModel().getCommandFactory().add(owner, property, convertedValue);
		} else {
			getModel().getCommandFactory().set(owner, property, convertedValue);
		}
	}
}
