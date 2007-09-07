package hub.sam.util.container;

import java.util.Collection;
import java.util.Vector;

public abstract class AbstractWatchedDisposable implements IDisposable {

	private final Collection<IDisposbaleStatusListener> fStatusListener = new Vector<IDisposbaleStatusListener>();
	
	public void addDisposableStatusListener(IDisposbaleStatusListener statusListener) {
		fStatusListener.add(statusListener);
	}
	
	public void removeDisposableStatusListener(IDisposbaleStatusListener statusListener) {
		fStatusListener.remove(statusListener);
	}

	public void dispose() {
		for (IDisposbaleStatusListener statusListener: fStatusListener) {
			statusListener.disposed();
		}
		fStatusListener.clear();
	}
	
}
