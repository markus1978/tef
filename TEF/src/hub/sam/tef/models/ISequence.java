package hub.sam.tef.models;


public interface ISequence<T> extends ICollection<T> {

	public void insert(int index, T value);
}
