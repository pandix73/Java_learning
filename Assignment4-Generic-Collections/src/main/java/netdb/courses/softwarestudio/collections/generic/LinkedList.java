package netdb.courses.softwarestudio.collections.generic;

/**
 * Double linked list.
 */
public class LinkedList<E> implements List<E>, Deque<E> {
	public static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE;
	
	/**
	 * Class for the entries (that is, nodes) kept inside this list.
	 */
	private class Entry {
		// access modifiers don't matter for a private class
		E element;
		Entry next;
		Entry previous;
		
		Entry(E e, Entry next, Entry previous) {
			element = e;
			this.next = next;
			this.previous = previous;
		}
	}
	
	/**
	 * A virtual entry before the first one and behind the last one
	 */
	private Entry header;
	
	private int size;
	
	public LinkedList() {
		header = new Entry(null, null, null);
		header.next = header.previous = header;
		size = 0;
	}
	
	private Entry addBefore(E e, Entry entry) {
		if(size == MAXIMUM_CAPACITY) 
			throw new OverflowException();
		
		Entry newEntry = new Entry(e, entry, entry.previous);
		newEntry.previous.next = newEntry;
		newEntry.next.previous = newEntry;
		size++;
		return newEntry;
	}
	
	private E remove(Entry entry) throws UnderflowException {
		if(size == 0)
			throw new UnderflowException();

		E result = entry.element;
		// entry will be garbage collected if not referenced by others
		entry.previous.next = entry.next;
		entry.next.previous = entry.previous;
		entry.next = entry.previous = null;
		entry.element = null;
		size--;
		return result;
	}
	
	@Override
	public void add(E e) throws OverflowException {
		addLast(e);
	}

	@Override
	public boolean contains(E e) {
		return indexOf(e) != -1;
	}
	
	/**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
	public int indexOf(E e) {
		int index = 0;
		if(e == null) {
			for(Entry entry = header.next; entry != header; entry = entry.next) {
				if(entry.element == null)
					return index;
				index++;
			}
		} else {
			for(Entry entry = header.next; entry != header; entry = entry.next) {
				if(e.equals(entry.element))
					return index;
				index++;
			}
		}
		return -1;
	}

	@Override
	public void remove(E e) {
		if(e == null) {
			for(Entry entry = header.next; entry != header;) {
				Entry tmp = entry.next;
				if(entry.element == null) {
					remove(entry);
				}
				entry = tmp;
			}
		} else {
			for(Entry entry = header.next; entry != header;) {
				Entry tmp = entry.next;
				if(e.equals(entry.element)) {
					remove(entry);
				}
				entry = tmp;
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(int index, E e) throws OverflowException,
			IndexOutOfBoundsException {
		addBefore(e, (index == size ? header : entry(index)));
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		return remove(entry(index));
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		return entry(index).element;
	}
	
	private Entry entry(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Entry entry = header;
		if(index < (size >> 1)) {
			for(int i = 0; i <= index; i++)
				entry = entry.next;
		} else {
			for(int i = size; i > index; i--)
				entry = entry.previous;
		}
		return entry;
	}

	@Override
	public E remove() throws UnderflowException {
		return removeFirst();
	}

	@Override
	public E get() {
		return getFirst();
	}

	@Override
	public void addFirst(E e) throws OverflowException {
		addBefore(e, header.next);
	}

	@Override
	public void addLast(E e) throws OverflowException {
		addBefore(e, header);
	}

	@Override
	public E removeFirst() throws UnderflowException {
		return remove(header.next);
	}

	@Override
	public E removeLast() throws UnderflowException {
		return remove(header.previous);
	}

	@Override
	public E getFirst() {
		if(size == 0)
			throw new UnderflowException();
		return header.next.element;
	}

	@Override
	public E getLast() {
		if(size == 0)
			throw new UnderflowException();
		return header.previous.element;
	}

}
