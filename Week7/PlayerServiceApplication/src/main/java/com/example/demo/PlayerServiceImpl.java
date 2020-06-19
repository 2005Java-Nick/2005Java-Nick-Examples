package com.example.demo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

	private PlayerRepo playerRepo;

	private CardService cardService;
	
	private PlayerCardRepo playerCardRepo;
	
	@Autowired
	public void setPlayerCardRepo (PlayerCardRepo playerCardRepo) {
		this.playerCardRepo = playerCardRepo;
	}
	
	@Autowired
	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	
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
		
		Player newPlayer = playerRepo.save(player);
		for (PlayerCard pc: player.getHand()) {
			pc.setPlayer(newPlayer);
			playerCardRepo.save(pc);
		}
	}

	@Override
	public void updatePlayer(Player player) {
		playerRepo.findById(player.getId()).ifPresent((existingPlayer) -> playerRepo.save(player));
		
	}

	
	@Override
	public void deletePlayer(Player player) {
		playerRepo.delete(player);
		
	}

	@Override
	public PlayerDTO getPlayerDTO(Player player) {
		
		PlayerDTO pDTO = new PlayerDTO();
		pDTO.setName(player.getName());
		pDTO.setPlayerId(player.getId());
		pDTO.setScore(player.getScore());
		pDTO.setTokens(player.getTokens());
		List<Card> hand = new LinkedList<>();
		
		for (PlayerCard pc : player.getHand()) {
			hand.add(cardService.getCardByFaceSuit(pc.getFace(), pc.getSuit()));
		}
		pDTO.setHand(hand);
		
		
		return pDTO;
		
	}

	

}
