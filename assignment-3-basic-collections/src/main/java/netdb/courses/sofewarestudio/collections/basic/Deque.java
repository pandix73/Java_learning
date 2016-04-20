package netdb.courses.sofewarestudio.collections.basic;

/**
 * A collection with two heads representing the first and last positions
 * respectively. Note the methods {@link #add(Object)}, {@link #remove()}, and
 * {@link #get()} are overridden.
 */
public interface Deque extends Queue {
	/**
	 * Adds an element to the last position.
	 * 
	 * @see #addLast(Object)
	 */
	@Override
	void add(Object e) throws OverflowException;
	
	/**
	 * Removes the element at the first position. 
	 * 
	 * @see #removeFirst()
	 */
	@Override
	Object remove() throws UnderflowException;
	
	/**
	 * Gets the element at the first position.
	 * 
	 * @see #getFirst()
	 */
	@Override
	Object get();
	
	/**
	 * Adds an element to the first position.
	 * 
	 * @param e element to be added
	 * @throws OverflowException if the capacity limit is reached
	 */
	void addFirst(Object e) throws OverflowException;
	
	/**
	 * Adds an element to the last position.
	 * 
	 * @param e element to be added
	 * @throws OverflowException if the capacity limit is reached
	 */
	void addLast(Object e) throws OverflowException;
	
	/**
	 * Removes the element at the first position.
	 * 
	 * @return the removed element
	 * @throws UnderflowException if this queue is empty
	 */
	Object removeFirst() throws UnderflowException;
	
	/**
	 * Removes the element at the last position.
	 * 
	 * @return the removed element
	 * @throws UnderflowException if this queue is empty
	 */
	Object removeLast() throws UnderflowException;
	
	/**
	 * Gets the element at the first position.
	 * 
	 * @return the element
	 */
	Object getFirst();
	
	/**
	 * Gets the element at the last position.
	 * 
	 * @return the element
	 */
	Object getLast();
}
