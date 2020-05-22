package com.revature.blackjack.service;

import com.revature.blackjack.dao.PlayerDAO;
import com.revature.blackjack.dao.PlayerDAOPostgres;
import com.revature.blackjack.domain.Player;

public class PlayerServiceImpl implements PlayerService {
	
	private static PlayerDAO playerDao = new PlayerDAOPostgres();

	public Player getPlayerByUsername(String username) {
		return playerDao.getPlayer(username);
	}

}
