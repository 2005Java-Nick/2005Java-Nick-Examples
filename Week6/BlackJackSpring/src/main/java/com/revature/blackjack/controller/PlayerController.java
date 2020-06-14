package com.revature.blackjack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.revature.blackjack.domain.Player;
import com.revature.blackjack.service.PlayerService;

@Controller
public class PlayerController {

	private PlayerService playerService;
	
	@Autowired
	public void setPlayerService(PlayerService playerService) {
		this.playerService=playerService;
	}
	
	@RequestMapping(path = "/player", method = RequestMethod.GET)
	@ResponseBody
	public List<Player> getAllPlayers(@RequestParam(name = "tokens", required = false) Integer tokens) {
		
		if (tokens != null) {
			return playerService.getPlayersByTokens(tokens);
		}
		return playerService.getAllPlayers();
	}
	
	@RequestMapping(path = "/player", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletePlayer(@RequestBody Player player) {
		playerService.deletePlayer(player);
		return "Player successfully deleted";
	}
	
	@RequestMapping(path = "/player", method = RequestMethod.POST)
	@ResponseBody
	public String addPlayer(@RequestBody Player player) {
		playerService.createPlayer(player);
		return "Player successfully added";
	}
	
	
	@RequestMapping(path = "/player", method = RequestMethod.PUT)
	@ResponseBody
	public String updatePlayer(@RequestBody Player player) {
		playerService.updatePlayer(player);
		return "Player updated successfully";
	}
	/*
	@RequestMapping(path = "/card/suit/{suit}/face/{face}", method = RequestMethod.GET)
	@ResponseBody
	public Card getCard(@PathVariable String suit, @PathVariable String face) {
		return cardService.getCard(face, suit);
	}*/
	
	
}
