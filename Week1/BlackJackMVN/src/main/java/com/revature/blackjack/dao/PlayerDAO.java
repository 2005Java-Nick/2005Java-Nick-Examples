package com.revature.blackjack.dao;

import com.revature.blackjack.player.Player;

public interface PlayerDAO {
	
	public void savePlayer(Player p);
	
	public Player getPlayer(String playerName);

}
