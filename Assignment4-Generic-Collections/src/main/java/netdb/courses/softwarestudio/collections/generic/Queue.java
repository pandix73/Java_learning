package netdb.courses.softwarestudio.collections.generic;

/**
 * A collection with a head position. Note the method {@link #add(Object)} is
 * overridden.
 */
public interface Queue<E> extends Collection<E> {
	/**
	 * Adds an element to the head.
	 */
	@Override
	void add(E e) throws OverflowException;

	/**
	 * Removes the element at head.
	 * 
	 * @return the removed element
	 * @throws UnderflowException if this queue is empty
	 */
	E remove() throws UnderflowException;

	/**
	 * Gets the element at head.
	 * 
	 * @return the element
	 */
	E get();
}
