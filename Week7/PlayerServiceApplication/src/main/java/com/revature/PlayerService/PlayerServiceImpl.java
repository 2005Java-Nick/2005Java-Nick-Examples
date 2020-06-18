package com.revature.PlayerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.revature.domain.Player;
import com.revature.repo.PlayerRepo;

public class PlayerServiceImpl implements PlayerService{
private PlayerRepo playerRepo;
	
	@Autowired
	public void setPlayerRepo(PlayerRepo playerRepo) {
		this.playerRepo = playerRepo;
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}

	@Override
	public Player getPlayerById(int id) {
		return playerRepo.findById(id).get();
	}

	@Override
	public void createPlayer(Player player) {
		playerRepo.save(player);
	}

	@Override
	public void updatePlayer(Player player) {
		playerRepo.findById(player.getId()).ifPresent((existingPlayer) -> playerRepo.save(player));
		
	}

	
	@Override
	public void deletePlayer(Player player) {
		playerRepo.delete(player);
		
	}


}
