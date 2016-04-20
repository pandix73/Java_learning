package netdb.courses.softwarestudio.lab.characters;

public class Hero implements Creature{
	private float hp = 100.0f;
	private float damage = 5.0f;
	private float defense = 5.0f; 
	private String profession;
	private int id;
	private static int mageId = 1;
	private static int warriorId = 1;
	public Hero(String pro){
		this.setProfession(pro);
		if(pro.equals("Warrior")){
			this.setHp(120);
			this.setDamage(65);
			this.setDefense(35);
			this.setId(warriorId++);
		}else if(pro.equals("Mage")){
			this.setHp(80);
			this.setDamage(110);
			this.setDefense(10);
			this.setId(mageId++);
		}
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public float getHp(){
		return hp;
	}
	public void setHp(float HP){
		hp = HP;
	}
	
	public void setDamage(float damage){
		this.damage = damage;
	}
	
	public float getDamage(){
		return damage;
	}
	
	public String getProfession(){
		return this.profession;
	}
	public void setProfession(String pro){
		this.profession = pro;
	}
	public void setDefense(float def){
		defense = def;
	}
	public float getDefense(){
		return defense;
	}

	public void attack(Creature creature) {
		String s = new String();
		s = this.getProfession() + this.getId();
		if(this.getProfession() == "Mage"){
			s += "用法術攻擊了" + creature.getProfession() + creature.getId();
		}else{
			s += "用斧頭劈向了" + creature.getProfession() + creature.getId();
		}
		System.out.println(s);
	}
	
	public void attack(Monster2 m) {
		String s = new String();
		s = this.getProfession() + this.getId();
		if(this.getProfession() == "Mage"){
			s += "用法術攻擊了" + m.getType() + m.getName();
		}else{
			s += "用斧頭劈向了" + m.getType() + m.getName();
		}
		System.out.println(s);
	}

	public void takeDamage(float damage) {
		float hurt = damage - this.defense;
		if(hurt < 0)hurt = 0;
		String s = new String();
		s = this.getProfession() + this.getId();
		s += "受到了" + hurt + "點傷害";
		this.hp -= hurt;
		
		System.out.println(s);
	}
	
	public boolean die(){
		if(this.hp < 0){
			String s = new String();
			s = this.getProfession() + this.getId();
			s += "英勇的犧牲了";
			System.out.println(s);
			return true;
		}else
			return false;
	}
}
