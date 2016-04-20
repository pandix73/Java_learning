package netdb.courses.sofewarestudio.collections.basic;

/**
 * A collection of elements.
 */
public interface Collection {
	/**
	 * Adds an element to this collection.
	 * 
	 * @param e element to be added
	 * @throws OverflowException if the capacity limit is reached
	 */
	void add(Object e) throws OverflowException;
	
	/**
	 * Tests whether this collection contains a specific element.
	 * 
	 * @param e element to be tested
	 * @return true if there exist an element <code>el</code> in this collection such that <code>el.equals(e)</code>
	 */
	boolean contains(Object e);
	
	/**
	 * Removes a specific element from this collection.
	 * 
	 * @param e element to be removed
	 */
	void remove(Object e);
	
	/**
	 * Counts the number of elements in this collection.
	 * 
	 * @return element count
	 */
	int size();
}
