package netdb.courses.sofewarestudio.collections.basic;


/**
 * Double linked list.
 * 
 * TODO Let this class implement {@link Deque}.
 */
public class LinkedList implements List, Deque{
	public static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE;
	
	/**
	 * Class for the entries (that is, nodes) kept inside this list.
	 */
	private class Entry {
		// access modifiers don't matter for a private class
		Object element;
		Entry next;
		Entry previous;
		
		Entry(Object e, Entry next, Entry previous) {
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
	
	private Entry addBefore(Object e, Entry entry) {
		if(size == MAXIMUM_CAPACITY) 
			throw new OverflowException();
		
		Entry newEntry = new Entry(e, entry, entry.previous);
		newEntry.previous.next = newEntry;
		newEntry.next.previous = newEntry;
		size++;
		return newEntry;
	}
	
	private Object remove(Entry entry) throws OverflowException {
		if(size == 0)
			throw new UnderflowException();

		Object result = entry.element;
		// entry will be garbage collected if not referenced by others
		entry.previous.next = entry.next;
		entry.next.previous = entry.previous;
		entry.next = entry.previous = null;
		entry.element = null;
		size--;
		return result;
	}
	
	@Override
	public void add(Object e) throws OverflowException {
		addBefore(e, header);
	}

	@Override
	public boolean contains(Object e) {
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
	public int indexOf(Object e) {
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
	public void remove(Object e) {
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
	public void add(int index, Object e) throws OverflowException,
			IndexOutOfBoundsException {
		addBefore(e, (index == size ? header : entry(index)));
	}
	
	@Override
	public void addFirst(Object e) throws OverflowException,
			IndexOutOfBoundsException {
		add(0, e);
	}
	
	@Override
	public void addLast(Object e) throws OverflowException,
			IndexOutOfBoundsException {
		add(size, e);
	}

	@Override
	public Object remove(int index) throws IndexOutOfBoundsException {
		return remove(entry(index));
	}
	
	@Override
	public Object remove(){
		return remove(0);
	}
	
	@Override
	public Object removeFirst(){
		return remove(0);
	}
	
	@Override
	public Object removeLast(){
		return remove(size-1);
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		return entry(index).element;
	}
	
	@Override
	public Object get() throws IndexOutOfBoundsException {
		return get(0);
	}
	
	@Override
	public Object getFirst() throws IndexOutOfBoundsException {
		return get(0);
	}
	
	@Override
	public Object getLast() throws IndexOutOfBoundsException {
		return get(size-1);
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
	public String toString() {
		String res = "";
		boolean fst = true;
		for(Entry entry=header.next; entry != header; entry=entry.next){
			if(fst == false) res += "/";
			res += entry.element.toString();
			fst = false;
		}
		return res;
	}
	
}
