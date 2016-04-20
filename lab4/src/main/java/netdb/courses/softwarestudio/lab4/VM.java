package netdb.courses.softwarestudio.lab4;

import java.util.*;

public class VM implements VendingMachine{
	private List<Drink> drinks = new ArrayList<Drink>();
	private Set<String> flavors = new HashSet<String>();
	int drinkNum = 0;
	
	public void addDrink(Drink drink){
		drinks.add(drink);
		flavors.add(drink.toString().split(",", 2)[0]);
	}
	
	public int getDrinkCount(){
		return drinks.size();
	}
	
	public int getDrinkFlavorCount(){
		return flavors.size();
	}
	
	public String[] getDrinksDescription(){
		String names[] = new String[100];
		for(int i = 0; i < drinks.size(); i++){
			names[i] = drinks.get(i).toString();
		}
		return names;
	}
}
