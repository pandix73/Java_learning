package netdb.courses.softwarestudio.collections.generic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * You can use this class to write some test cases
 * 
 */
public class AppTest {
	
	private LinkedList<Integer> intList;
	private LinkedList<String> stringList;
	
	@Before
	public void setup(){
		intList = new LinkedList<Integer>();
		stringList = new LinkedList<String>();
	}
	
	@After
	public void tearDown(){
		intList = null;
		stringList = null;
	}
	
	@Test
	public void test(){
		intList.add(1);
		intList.add(73);
		intList.remove((Integer)1);
		stringList.add("73");
		System.out.println(intList.get(0) + stringList.get(0));
	}
   
}
