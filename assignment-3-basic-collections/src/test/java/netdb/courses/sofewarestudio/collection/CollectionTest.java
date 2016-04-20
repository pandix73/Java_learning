package netdb.courses.sofewarestudio.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import netdb.courses.sofewarestudio.collections.basic.LinkedList;

public class CollectionTest {
	private LinkedList list;
	
	@Before
	public void setup(){
		list = new LinkedList();
	}
	
	@After
	public void tearDown(){
		list = null;
	}
	
	@Test
	public void isEasyCorrect(){
		list.add(6.5);
		list.addFirst("6");
		list.addLast(1);
		Assert.assertEquals(3, list.size());
		Assert.assertEquals(true, list.contains(6.5));
		Assert.assertEquals(false, list.contains("6.0"));
		Assert.assertEquals("6", list.get());
		Assert.assertEquals(1, list.getLast());
		Assert.assertEquals("6/6.5/1", list.toString());
	}
	
	@Test
	public void isRemoveCorrect(){
		list.add("6");
		list.add(6.5);
		list.add(1);		
		list.add("87");
		list.add("JIZZZRAY");
		Assert.assertEquals("6/6.5/1/87/JIZZZRAY", list.toString());
		
		list.remove(87);
		Assert.assertEquals("6/6.5/1/87/JIZZZRAY", list.toString());
		Assert.assertEquals(5, list.size());
		
		list.remove("87");
		Assert.assertEquals("6/6.5/1/JIZZZRAY", list.toString());
		Assert.assertEquals(4, list.size());
		
		list.removeFirst();
		Assert.assertEquals("6.5/1/JIZZZRAY", list.toString());
		Assert.assertEquals(3, list.size());
		
		list.removeLast();
		Assert.assertEquals("6.5/1", list.toString());
		Assert.assertEquals(2, list.size());
	}
}