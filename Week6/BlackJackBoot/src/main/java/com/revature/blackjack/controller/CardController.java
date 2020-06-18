package com.revature.blackjack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.blackjack.domain.Card;
import com.revature.blackjack.service.CardService;

@RestController
public class CardController {
	
	private CardService cardService;
	
	@Autowired
	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	
	@GetMapping("/card")
	public List<Card> getAllCards(@RequestParam(name = "value") Integer value) {
		
		if (value != null) {
			return cardService.getCardsByValue(value);
		}
		
		return cardService.getAllCards();
	}
	
	@PostMapping("/card")
	public String createCard(@RequestBody Card card) {
		cardService.createCard(card);
		return "Card Successfully Created";
	}

}
