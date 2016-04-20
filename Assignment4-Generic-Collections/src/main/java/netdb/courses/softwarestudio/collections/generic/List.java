package netdb.courses.softwarestudio.collections.generic;

/**
 * An ordered, indexable collections that allows duplicate elements.
 */
public interface List<E> extends Collection<E> {
	/**
	 * Adds an element to the end of this list.
	 */
	@Override
	void add(E e);
	
	/**
	 * Removes the first occurrence of the specified element from this list.
	 */
	@Override
	void remove(E e);
	
	/**
	 * Adds an element into this list at a specific position.
	 * 
	 * @param index position where the element will be added. Starts from 0.
	 * @param e element to be added
	 * @throws OverflowException if the capacity limit is reached
	 * @throws IndexOutOfBoundsException if <code>index < 0 || index > size()</code>
	 */
	void add(int index, E e) throws OverflowException, IndexOutOfBoundsException;
	
	/**
	 * Removes an element at a specific position.
	 * 
	 * @param index position where the element will be removed
	 * @return the removed element
	 * @throws IndexOutOfBoundsException if <code>index < 0 || index >= size()</code>
	 */
	E remove(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Gets the element at a specific position.
	 * 
	 * @param index position of the element 
	 * @return the element
	 * @throws IndexOutOfBoundsException if <code>index < 0 || index >= size()</code>
	 */
	E get(int index) throws IndexOutOfBoundsException;
}
