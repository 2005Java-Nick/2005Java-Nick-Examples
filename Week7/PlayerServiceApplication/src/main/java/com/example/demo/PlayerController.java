package com.example.demo;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerController {
	
	PlayerService playerService;
	
	@Autowired
	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}	
	@GetMapping("/player")
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}	
	@GetMapping("/player/{id}")
	public Player getPlayer(@PathParam("id")Integer id) {
		return playerService.getPlayerById(id);
	}	
	@PostMapping("/player")
	public String createPlayer(@RequestBody Player player) {
		playerService.createPlayer(player);
		return "Player successfully created";
	}	
	@PutMapping("/player")
	public String updatePlayer(@RequestBody Player player) {
		playerService.updatePlayer(player);
		return "Player successfully updated";
	}	
	@DeleteMapping("/player/{id}")
	public String deletePlayer(@PathParam("id") int id) {
		Player player = new Player();
		player.setId(id);
		playerService.deletePlayer(player);
		return "Player successfully deleted";
	}

}
