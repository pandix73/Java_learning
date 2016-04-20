package netdb.courses.softwarestudio.lab.rpg.player;

public class Player {
	// TODO: fill the Player class with proper fields and methods
	private int id;
	private String login;
	private String profession;
	private int level;
	private String name;
	
	public void setId(int input){
		id = input;
	}
	
	public int getId(){
		return id;
	}
	
	public void setLogin(String input){
		login = input;
	}
	
	public String getLogin(){
		return login;
	}
	
	public void setProfession(String input){
		profession = input;
	}
	
	public String getProfession(){
		return profession;
	}
	
	public void setLevel(int input){
		level = input;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setName(String input){
		name = input;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString() {
		// TODO: return the string of the player with the format
		// ${id}/${login}/${profession}/${level}/${name}
		// For example:
		// 12/103062512/Archer/20/CoolBrandon
		return id + "/" + login + "/" + profession + "/" + level + "/" + name;
	}
}
