package netdb.courses.softwarestudio.lab.rpg.combat_system;
import netdb.courses.softwarestudio.lab.characters.*;
import netdb.courses.softwarestudio.lab.http.HttpRetriever;

import java.util.*;
import com.alibaba.fastjson.*;

public class App2 {
	
	private static final String SERVER_ADDR = "https://sslab5.herokuapp.com/";
	
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
		
		String jsonString = HttpRetriever.retrieveContent(SERVER_ADDR);
		
		List<Monster2> monsters = new ArrayList<Monster2>();
		
		monsters = JSON.parseArray(jsonString.replace("-", ""), Monster2.class);
		
		int heroIndex = 0, monsterIndex = 0, heroAttack = 0, monsterAttack = 0;
		boolean heroWin = false, heroTurn = true;
		while (true) {
			if(heros.length == monsterAttack || monsters.size() == heroAttack){
				if(monsters.size() == heroAttack)
					heroWin = true;
				break;
			}
			
			if(heroTurn){
				heros[heroIndex].attack(monsters.get(monsterAttack));
				Thread.sleep(1500);
				monsters.get(heroAttack).takeDamage((int)heros[heroIndex].getDamage());
				
				if(monsters.get(heroAttack).die()){
					heroAttack++;
					if(monsterIndex < heroAttack)monsterIndex = heroAttack;
				}
				heroIndex++;
				if(heroIndex > 4) heroIndex = monsterAttack;
				Thread.sleep(1500);
				heroTurn = false;
			}else{
				int att = monsters.get(monsterIndex).attack();
				Thread.sleep(1500);
				heros[monsterAttack].takeDamage((float)att);
				
				if(heros[monsterAttack].die()){
					monsterAttack++;
					if(heroIndex < monsterAttack)heroIndex = monsterAttack;
				}
				monsterIndex++;
				if(monsterIndex >= monsters.size()) monsterIndex = heroAttack;
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
