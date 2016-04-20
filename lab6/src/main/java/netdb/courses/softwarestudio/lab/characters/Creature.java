package netdb.courses.softwarestudio.lab.characters;

public interface Creature {
	float getHp();
	void setHp(float HP);
	
	void setDamage(float damage);
	float getDamage();
	
	String getProfession();
	void setProfession(String pro);
	
	float getDefense();
	void setDefense(float def);
	
	void attack(Creature creature);
	void takeDamage(float damage);
	
	boolean die();
	
	int getId();
	void setId(int id);
}
