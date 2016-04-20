package netdb.courses.sofewarestudio.collections.basic;

/**
 * A table that maps keys to their corresponding values.
 */
public interface Map {
	/**
	 * Stores a key-value entry into this map. If this map previously contained 
	 * an entry for the key, the old value is replaced by the specified value.
	 * 
	 * @param k key
	 * @param v value
	 * @return the previous value mapped from key, or <code>null</code> if there
	 *         was no mapping for key. A <code>null</code> return can also 
	 *         indicate that the previous value is <code>null</code>.
	 * @throws OverflowException if the capacity limit is reached
	 */
	Object put(Object k, Object v) throws OverflowException;
	
	/**
	 * Tests whether this map contains a specific key.
	 * 
	 * @param k key to be tested
	 * @return true if there exists a key <code>ky</code> in this map such that <code>ky.equals(k)</code> 
	 */
	boolean containsKey(Object k);
	
	/**
	 * Tests whether this map contains a specific value.
	 * 
	 * @param v value to be tested
	 * @return true if there exists a value <code>va</code> in this map such that <code>va.equals(v)</code> 
	 */
	boolean containsValue(Object v);
	
	/**
	 * Gets the value mapped from a key.
	 * 
	 * @param k key
	 * @return value mapped from the key, or <code>null</code> if there was no mapping for key
	 */
	Object get(Object k);
	
	/**
	 * Removes a key and its mapping value.
	 * 
	 * @param k key
	 * @return value mapped from the key, or <code>null</code> if there was no mapping for key
	 */
	Object remove(Object k);
	
	/**
	 * Counts the number of key-value entries in this map.
	 * 
	 * @return entry count
	 */
	int size();
}
