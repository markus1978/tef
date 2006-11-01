package editortest.model;


public interface ISequence<T> extends ICollection<T> {

	public void insert(int index, T value);
}
