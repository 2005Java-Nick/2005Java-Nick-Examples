package com.revature.blackjack.service;

import java.util.List;

import com.revature.blackjack.domain.Player;

public interface PlayerService {
	
	public List<Player> getAllPlayers();
	
	public Player getPlayer(String playerName);
	
	public void createPlayer(Player player);
	
	public void deletePlayer(Player player);
	
	public void updatePlayer(Player player);
	
	public List<Player> getPlayersByTokens(int tokens);
	
}
