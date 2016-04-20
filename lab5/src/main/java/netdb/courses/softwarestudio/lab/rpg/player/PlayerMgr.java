package netdb.courses.softwarestudio.lab.rpg.player;

import java.util.*;
import com.alibaba.fastjson.*;

public class PlayerMgr {
	// TODO: declare a proper field to store the data of users
	List<Player> players = new ArrayList<Player>();
	
	public PlayerMgr(String data) {
		// TODO: parse data and generate list of players
		players = JSON.parseArray(data, Player.class);
	}

	public Player getPlayer(String login) {
		// TODO: get player with the login (you should use this method to get your own character)
		for(Player player : players){
			if(player.getLogin().equals(login))
				return player;
		}
		return null;
	}

	public Player findTeammate(Player player) {
		// TODO: find the best team-mate for `player`
		Player bestTeammate = player;
		for(Player playerNow : players){
			int nowDeltaLevel = Math.abs(playerNow.getLevel() - player.getLevel());
			int bestDeltaLevel = Math.abs(bestTeammate.getLevel() - player.getLevel());
			if(!playerNow.equals(player)){
				if(bestTeammate.equals(player)){
					bestTeammate = playerNow;
				} else if(nowDeltaLevel < bestDeltaLevel){
					bestTeammate = playerNow;
				} else if(nowDeltaLevel == bestDeltaLevel){
					boolean nowFit = ((playerNow.getProfession() + player.getProfession()).length() == 11);
					boolean bestFit = ((bestTeammate.getProfession() + player.getProfession()).length() == 11);
					if(nowFit && !bestFit){
						bestTeammate = playerNow;
					} else if(nowFit && bestFit){
						if(playerNow.getId() < bestTeammate.getId())
							bestTeammate = playerNow;
					}
				}
			}
		}
		return bestTeammate;
	}

}
