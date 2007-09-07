package hub.sam.tef.models.extensions;

import java.util.Collection;
import java.util.Vector;

import hub.sam.tef.models.ICommand;

public abstract class AbstractCommand implements ICommand {

	private final Collection fResult = new Vector();
	
	protected final void addResult(Object obj) {
		fResult.add(obj);
	}
	
	public final Collection getResult() {
		return fResult;
	}

}
