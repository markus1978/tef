package hub.sam.tef.util;

public interface IAdaptable {
	public <T> T getAdapter(Class<T> adapterClass);
}
