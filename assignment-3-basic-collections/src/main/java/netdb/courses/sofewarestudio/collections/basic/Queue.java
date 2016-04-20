package netdb.courses.sofewarestudio.collections.basic;

/**
 * A collection with a head position. Note the method {@link #add(Object)} is
 * overridden.
 */
public interface Queue extends Collection {
	/**
	 * Adds an element to the head.
	 */
	@Override
	void add(Object e) throws OverflowException;

	/**
	 * Removes the element at head.
	 * 
	 * @return the removed element
	 * @throws UnderflowException if this queue is empty
	 */
	Object remove() throws UnderflowException;

	/**
	 * Gets the element at head.
	 * 
	 * @return the element
	 */
	Object get();
}
