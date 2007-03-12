package hub.sam.tef.templates;

import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IType;

public abstract class PrimitiveValueTemplate<ModelType> extends ValueTemplate<ModelType> {

	public PrimitiveValueTemplate(Template template, IType type) {
		super(template, type);
	}

	protected final void executeASTSemanticsWithConvertedValue(Object convertedValue, IModelElement owner, String property, boolean isCollection, boolean isOld) {
		if (isCollection) {
			if (!isOld || ((ICollection)owner.getValue(property)).contains(convertedValue)) {			
				getModel().getCommandFactory().add(owner, property, convertedValue);
			}
		} else {
			if (!convertedValue.equals(owner.getValue(property))) {
				getModel().getCommandFactory().set(owner, property, convertedValue).execute();
			}
		}
	}
}
