package com.example.demo;

import java.util.List;




public interface PlayerService {
	
public List<Player> getAllPlayers();
	
	public Player getPlayerById(int id);
	
	public void createPlayer(Player player);
	
	public void updatePlayer(Player player);
	
	public void deletePlayer(Player player);
	
	public PlayerDTO getPlayerDTO(Player player);

}
