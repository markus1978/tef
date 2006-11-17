package hub.sam.util.container;

/**
 * A contianer is an abstract interface for classes that can contain abitraty information.
 * This interface allows to attach other objects to a container instance using the objects class
 * as key.
 */
public interface IContainer {

	/**
	 * Adds an element to a list of elements stored under a given key.
	 * 
	 * @param <T>
	 *            The value type.
	 * @param key
	 *            The key, it must be the value type.
	 * @param value
	 *            The value.
	 */
	public <T> void addElement(Class<T> key, T value);
	
	/**
	 * Sets an element and stores it under a given key.
	 * 
	 * @param <T>
	 *            The value type.
	 * @param key
	 *            The key, it must be the value type.
	 * @param value
	 *            The value.
	 */
	public <T> void setElement(Class<T> key, T value);
	
	/**
	 * Retrieves the element set under a given key.
	 * 
	 * @param <T>
	 *            The value type.
	 * @param key
	 *            The key, it must be the value type.
	 * @return The Value.
	 */
	public <T> T getElement(Class<T> key);
	
	/**
	 * Retrieves all elements added under a given key.
	 * 
	 * @param <T>
	 *            The value type.
	 * @param key
	 *            The key, it must be the value type.
	 * @return The Values.
	 */
	public <T> Iterable<T> getAllElements(Class<T> key);

	/**
	 * Removes a element set under a given key.
	 * 
	 * @param <T>
	 *            The value type.
	 * @param key
	 *            The key, it must be the value type.
	 */
	public <T> void removeElement(Class<T> key);
	
	/**
	 * Removes all elements added under a given key.
	 * 
	 * @param <T>
	 *            The value type.
	 * @param key
	 *            The key, it must be the value type.
	 */
	public <T> void removeAllElements(Class<T> key);
	
}
