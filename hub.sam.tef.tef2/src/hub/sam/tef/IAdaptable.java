package hub.sam.tef;

public interface IAdaptable {

	public <T> T getAdapter(Class<T> adapter);	
}
