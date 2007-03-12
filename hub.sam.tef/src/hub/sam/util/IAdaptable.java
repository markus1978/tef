package hub.sam.util;

public interface IAdaptable {

	public <T> T getAdapter(Class<T> adapter);	
}
