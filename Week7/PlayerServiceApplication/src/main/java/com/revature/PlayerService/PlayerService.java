package com.revature.PlayerService;

import java.util.List;

import com.revature.domain.Player;



public interface PlayerService {
	
public List<Player> getAllPlayers();
	
	public Player getPlayerById(int id);
	
	public void createPlayer(Player player);
	
	public void updatePlayer(Player player);
	
	public void deletePlayer(Player player);

}
