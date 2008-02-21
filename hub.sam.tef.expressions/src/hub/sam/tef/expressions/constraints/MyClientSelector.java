package hub.sam.tef.expressions.constraints;

import org.eclipse.emf.validation.model.IClientSelector;

import expressions.Function;

public class MyClientSelector implements IClientSelector {
	
	public MyClientSelector() {
		super();
	}

	public boolean selects(Object object) {
		if (object instanceof Function) {
			return true;
		} else {
			return false;
		}
	}

}
