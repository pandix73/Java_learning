package netdb.courses.softwarestudio.collections.generic;

/**
 * A collection with two heads representing the first and last positions
 * respectively. Note the methods {@link #add(Object)}, {@link #remove()}, and
 * {@link #get()} are overridden.
 */
public interface Deque<E> extends Queue<E> {
	/**
	 * Adds an element to the last position.
	 * 
	 * @see #addLast(Object)
	 */
	@Override
	void add(E e) throws OverflowException;
	
	/**
	 * Removes the element at the first position. 
	 * 
	 * @see #removeFirst()
	 */
	@Override
	E remove() throws UnderflowException;
	
	/**
	 * Gets the element at the first position.
	 * 
	 * @see #getFirst()
	 */
	@Override
	E get();
	
	/**
	 * Adds an element to the first position.
	 * 
	 * @param e element to be added
	 * @throws OverflowException if the capacity limit is reached
	 */
	void addFirst(E e) throws OverflowException;
	
	/**
	 * Adds an element to the last position.
	 * 
	 * @param e element to be added
	 * @throws OverflowException if the capacity limit is reached
	 */
	void addLast(E e) throws OverflowException;
	
	/**
	 * Removes the element at the first position.
	 * 
	 * @return the removed element
	 * @throws UnderflowException if this queue is empty
	 */
	E removeFirst() throws UnderflowException;
	
	/**
	 * Removes the element at the last position.
	 * 
	 * @return the removed element
	 * @throws UnderflowException if this queue is empty
	 */
	E removeLast() throws UnderflowException;
	
	/**
	 * Gets the element at the first position.
	 * 
	 * @return the element
	 */
	E getFirst();
	
	/**
	 * Gets the element at the last position.
	 * 
	 * @return the element
	 */
	E getLast();
}
