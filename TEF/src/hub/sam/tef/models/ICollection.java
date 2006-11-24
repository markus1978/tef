package hub.sam.tef.models;

public interface ICollection<T> extends Iterable<T> {
	public void add(T element);
	
	public boolean remove(T element);
	
	public void replace(T oldElement, T newElement);
	
	public int size();
}
