package com.revature.blackjack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.blackjack.dao.PlayerDAO;
import com.revature.blackjack.domain.Player;

@Service
public class PlayerServiceImp implements PlayerService{

	private PlayerDAO playerDao;
	
	@Autowired
	public void setCardDao(PlayerDAO playerDao) {
		this.playerDao = playerDao;
	}
	
	public List<Player> getAllPlayers() {
		
		return playerDao.getAllPlayers();
	}

	public Player getPlayer(String playerName) {
		// TODO Auto-generated method stub
		return playerDao.getPlayer(playerName);
	}

	public void createPlayer(Player player) {
		playerDao.createPlayer(player);
	}

	public void deletePlayer(Player player) {
		System.out.println("In delete service");
		playerDao.deletePlayer(player);
	}

	public void updatePlayer(Player player) {
		playerDao.updatePlayer(player);
	}

	public List<Player> getPlayersByTokens(int tokens) {
		return playerDao.getPlayersByTokens(tokens);
	}

}
