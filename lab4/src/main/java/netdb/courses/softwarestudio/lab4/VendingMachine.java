package netdb.courses.softwarestudio.lab4;

public interface VendingMachine {
	
	public void addDrink(Drink drink);
	
	public int getDrinkCount();
	
	public int getDrinkFlavorCount();
	
	public String[] getDrinksDescription();
}