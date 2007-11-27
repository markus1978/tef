package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.tsl.PropertyBinding;

public interface IDefaultValuePrintSemantics {
	
	public boolean printDefaultValue(Object parentValue, PropertyBinding binding, 
			PrettyPrintState state) throws ModelCreatingException;		
}
