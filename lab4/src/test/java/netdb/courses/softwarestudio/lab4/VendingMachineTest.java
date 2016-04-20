package netdb.courses.softwarestudio.lab4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	private VendingMachine vm;
	
	@Before
	public void setup(){
		// TODO new your Vending Machine and assign it to vm
		vm = new VM();
	}
	
	@After
	public void tearDown(){
		vm = null;
	}
	
	@Test
	public void itShouldReturnCorrectDrinkDescription(){
		Drink drink = new Drink("Cola");
		vm.addDrink(drink);
		Assert.assertEquals("Cola, id:7", vm.getDrinksDescription()[0]);
	}
	
	@Test
	public void itShouldReturnCorrectDrinkCount(){
		Drink drink = new Drink("Cola");
		Drink drink2 = new Drink("Juice");
		Drink drink3 = new Drink("Cola");
		vm.addDrink(drink);
		vm.addDrink(drink2);
		vm.addDrink(drink3);
		Assert.assertEquals( 3, vm.getDrinkCount());
	}
	
	@Test
	public void itShouldReturnCorrectDrinkFlavorCount(){
		Drink drink = new Drink("Cola");
		Drink drink2 = new Drink("Juice");
		Drink drink3 = new Drink("Cola");
		vm.addDrink(drink);
		vm.addDrink(drink2);
		vm.addDrink(drink3);
		Assert.assertEquals( 2, vm.getDrinkFlavorCount());
	}
	
	// TODO Implement other test cases
}