package netdb.courses.softwarestudio.lab4;

public class Drink {
	private String name;
	static int count = 0;
	private int id;
	
	public Drink(String name) {
		count = count + 1;
		this.name = name;
		this.id = count;
	}

	@Override
	public String toString() {
		return name + ", id:" + id;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof Drink))
			return false;

		Drink drink = (Drink) object;
		return this.toString().equals(drink.toString());
	}
}