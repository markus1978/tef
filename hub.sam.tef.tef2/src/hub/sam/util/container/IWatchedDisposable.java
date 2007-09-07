package hub.sam.util.container;


public interface IWatchedDisposable extends IDisposable {
	
	public void addDisposableStatusListener(IDisposbaleStatusListener statusListener);
	
	public void removeDisposableStatusListener(IDisposbaleStatusListener statusListener);
}
