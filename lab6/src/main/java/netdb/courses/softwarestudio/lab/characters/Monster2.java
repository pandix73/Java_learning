package netdb.courses.softwarestudio.lab.characters;

import java.util.*;

public class Monster2{
	private String type;
	private String name;
	private int hp;
	private int armor;
	private List<Skill> skills = new ArrayList<Skill>();
	private List<TakeDamage> damaged = new ArrayList<TakeDamage>();
	private String lastwords;
	
	public void setType(String input){
		type = input;
	}
	
	public String getType(){
		return type;
	}
	
	public void setName(String input){
		name = input;
	}
	
	public String getName(){
		return name;
	}
	
	public void setHp(int input){
		hp = input;
	}
	
	public int getHp(){
		return hp;
	}
	
	public void setArmor(int input){
		armor = input;
	}
	
	public int getArmor(){
		return armor;
	}
	
	public void setSkills(List<Skill> input){
		skills = input;
	}
	
	public List<Skill> getSkills(){
		return skills;
	}
	
	public void setDamaged(List<TakeDamage> input){
		damaged = input;
	}
	
	public List<TakeDamage> getDamaged(){
		return damaged;
	}
	
	public void setLastWords(String input){
		lastwords = input;
	}
	
	public String getLastWords(){
		return lastwords;
	}
	
	public int attack() {
		// TODO Auto-generated method stub
		Skill now = skills.get((int)(Math.random()*skills.size()));
		System.out.println(type + name + now.getMessage());
		return now.getDamage();
	}

	public void takeDamage(int damage) {
		TakeDamage now = damaged.get((int)(Math.random()*damaged.size()));
		int hurt = damage - this.armor;
		System.out.println(type + name + now.getPrefix() + hurt + now.getSuffix());
		this.hp -= hurt;
	}
	
	public boolean die(){
		if(this.hp < 0){
			System.out.println(lastwords);
			return true;
		} else
			return false;
	}
	
	public String toString(){
		String s = "";
		s += " type :" + type + "\n";
		s += " name :" + name + "\n";
		s += " hp :" + hp + "\n";
		s += " armor :" + armor + "\n";
		s += " lastwords :" + lastwords + "\n";
		return s;
	}
}
