package netdb.courses.softwarestudio.lab.characters;

public class Skill {
	private String message;
	private int damage;
	
	public void setMessage(String input){
		message = input;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setDamage(int input){
		damage = input;
	}
	
	public int getDamage(){
		return damage;
	}
}
