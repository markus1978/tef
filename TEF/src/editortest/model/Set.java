package editortest.model;

public interface Set<T> extends Iterable<T> {
	public void add(T element);
	
	public void addChangeListener(ModelEventListener listener);
}
