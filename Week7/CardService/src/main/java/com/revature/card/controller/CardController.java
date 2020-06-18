package com.revature.card.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.card.domain.Card;
import com.revature.card.service.CardService;

@RestController
public class CardController {
	
	private CardService cardService;

	@Autowired
	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	
	@GetMapping("/card")
	public List<Card> getAllCards() {
		return cardService.getAllCards();
	}
	
	@GetMapping("/card/{suit}/face/{face}")
	public Card getCard(@PathParam("suit") String suit, @PathParam("face") String face) {
		return cardService.getCardByFaceSuit(face, suit);
	}
	
	@PostMapping("/card")
	public String createCard(@RequestBody Card card) {
		cardService.createCard(card);
		return "Card successfully created";
	}
	
	@PutMapping("/card")
	public String updateCard(@RequestBody Card card) {
		cardService.updateCard(card);
		return "Card successfully updated";
	}
	
	@DeleteMapping("/card/{suit}/face/{face}")
	public String deleteCard(@PathParam("suit") String suit, @PathParam("face") String face) {
		Card card = new Card();
		card.setFace(face);
		card.setSuit(suit);
		cardService.deleteCard(card);
		return "Card successfully deleted";
	}
	
}
