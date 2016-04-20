package netdb.courses.softwarestudio.lab.rpg.combat_system;
import netdb.courses.softwarestudio.lab.characters.*;

public class App {

	public static void main(String[] args) throws InterruptedException {

		// TODO: Create a hero group and a monster group
		Hero[] heros = new Hero[5];
		for(int i = 0; i < 3; i++){
			Hero hero = new Hero("Warrior");
			heros[i] = hero;
		}
		for(int i = 3; i < 5; i++){
			Hero hero = new Hero("Mage");
			heros[i] = hero;
		}
		// TODO: Add creatures to each group
		Monster[] monsters = new Monster[5];
		for(int i = 0; i < 3; i++){
			Monster monster = new Monster("Goblin");
			monsters[i] = monster;
		}
		for(int i = 3; i < 5; i++){
			Monster monster = new Monster("Wolf");
			monsters[i] = monster;
		}
		
		int heroIndex = 0, monsterIndex = 0, heroAttack = 0, monsterAttack = 0;
		boolean heroWin = false, heroTurn = true;
		while (true) {
			if(heros.length == monsterAttack || monsters.length == heroAttack){
				if(monsters.length == heroAttack)
					heroWin = true;
				break;
			}
			
			if(heroTurn){
				heros[heroIndex].attack(monsters[heroAttack]);
				Thread.sleep(1500);
				monsters[heroAttack].takeDamage(heros[heroIndex].getDamage());
				
				if(monsters[heroAttack].die()){
					heroAttack++;
					if(monsterIndex < heroAttack)monsterIndex = heroAttack;
				}
				heroIndex++;
				if(heroIndex > 4) heroIndex = monsterAttack;
				Thread.sleep(1500);
				heroTurn = false;
			}else{
				monsters[monsterIndex].attack(heros[monsterAttack]);
				Thread.sleep(1500);
				heros[monsterAttack].takeDamage(monsters[monsterIndex].getDamage());
				
				if(heros[monsterAttack].die()){
					monsterAttack++;
					if(heroIndex < monsterAttack)heroIndex = monsterAttack;
				}
				monsterIndex++;
				if(monsterIndex > 4) monsterIndex = heroAttack;
				Thread.sleep(1500);
				heroTurn = true;
				
			}
			// use this line of code to pause the program for 1.5 seconds
			// (1500 ms)
			// you can add this code after each creature attack
			
		}
		
		// TODO: print the combat result
		if(heroWin)
			System.out.println("Hero Win");
		else
			System.out.println("Monster Win");
	}
}
