package netdb.courses.softwarestudio.lab.characters;

public class Monster implements Creature{
	private float hp = 100.0f;
	private float damage = 5.0f;
	private float defense = 5.0f; 
	private String profession;
	private int id;
	private static int goblinId = 1;
	private static int wolfId = 1;
	
	public Monster(String pro){
		this.setProfession(pro);
		if(pro.equals("Goblin")){
			this.setHp(100);
			this.setDamage(70);
			this.setDefense(30);
			this.setId(goblinId++);
		}else if(pro.equals("Wolf")){
			this.setHp(60);
			this.setDamage(100);
			this.setDefense(20);
			this.setId(wolfId++);
		}
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
		// TODO Auto-generated method stub
		if(profession.equals("Goblin"))
			System.out.println(this.getProfession() + this.getId()+"掄起棍棒，直接攻擊"+creature.getProfession()+creature.getId()+"下陰處");
		else if(profession.equals("Wolf"))
			System.out.println(this.getProfession() + this.getId()+"怒吼一聲，向"+creature.getProfession()+creature.getId()+"生殖部位咬過去");
	}

	public void takeDamage(float damage) {
		// TODO Auto-generated method stub
		float hurt = damage - this.defense;
		if(hurt < 0)hurt = 0;
		if(profession.equals("Goblin"))
			System.out.println(this.getProfession() + this.getId()+"受到"+hurt+"點傷害，跌坐在地");
		else if(profession.equals("Wolf"))
			System.out.println(this.getProfession() + this.getId()+"受到"+hurt+"點打擊，但戰意絲毫沒有降低");
		this.hp -= hurt;
	}
	
	public boolean die(){
		if(this.hp < 0){
			System.out.println(this.getProfession() + this.getId()+"的身體湧出大量鮮血，失去了生命跡象");
			return true;
		} else
			return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
}
