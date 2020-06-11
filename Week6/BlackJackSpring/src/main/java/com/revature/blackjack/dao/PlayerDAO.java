package com.revature.blackjack.dao;

import java.util.List;

import com.revature.blackjack.domain.Player;

public interface PlayerDAO {
	
	public List<Player> getAllPlayers();
	
	public Player getPlayer(String playerName);
	
	public void createPlayer(Player player);
	
	public void deletePlayer(Player player);
	
	public void updatePlayer(Player player);
	
	public List<Player> getPlayersByTokens(int tokens);

}
