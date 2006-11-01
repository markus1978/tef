package editortest.model;

public interface ICollection<T> extends Iterable<T> {
	public void add(T element);
	
	public void addChangeListener(ModelEventListener listener);
	
	public int size();
}
