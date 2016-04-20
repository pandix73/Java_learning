package netdb.courses.softwarestudio.lab.teammate_finder;

import netdb.courses.softwarestudio.lab.http.HttpRetriever;
import netdb.courses.softwarestudio.lab.rpg.player.Player;
import netdb.courses.softwarestudio.lab.rpg.player.PlayerMgr;

public class App {

	private static final String SERVER_ADDR = "http://shwu10.cs.nthu.edu.tw/2016-software-studio/release-slides/raw/master/data.json";

	public static void main(String[] args) throws Exception {
		String jsonString = HttpRetriever.retrieveContent(SERVER_ADDR);

		// TODO: initialize a player manager with downloaded data.
		PlayerMgr playerMgr = new PlayerMgr(jsonString);

		// TODO: find your character
		Player me = playerMgr.getPlayer("103060013");

		// TODO: find best teammate for your character
		Player teammate = playerMgr.findTeammate(me);

		System.out.println("Hello, " + me.toString()
				+ ". The best teammate for you is : " + teammate.toString()
				+ ".");
	}
}
