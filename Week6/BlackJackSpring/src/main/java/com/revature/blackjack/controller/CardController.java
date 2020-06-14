package com.revature.blackjack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.blackjack.domain.Card;
import com.revature.blackjack.service.CardService;

@Controller
public class CardController {

	private CardService cardService;
	
	@Autowired
	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	
	@RequestMapping(path = "/card", method = RequestMethod.GET)
	@ResponseBody
	public List<Card> getAllCards(@RequestParam(name = "value", required = false) Integer value) {
		
		if (value != null) {
			return cardService.getCardsByValue(value);
		}
		
		return cardService.getAllCards();
	}
	
	@RequestMapping(path = "/card/random", method = RequestMethod.GET)
	@ResponseBody
	public List<Card> getRandomCards(@RequestParam(name = "numCards", required = true) int numberOfCards) {
		return cardService.getRandomCards(numberOfCards);
	}
	
	@RequestMapping(path = "/card", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteCard(@RequestBody Card card) {
		cardService.deleteCard(card);
		return "Card successfully deleted";
	}
	
	@RequestMapping(path = "/card", method = RequestMethod.POST)
	@ResponseBody
	public String addCard(@RequestBody Card card) {
		cardService.createCard(card);
		return "Card successfully added";
	}
	
	@RequestMapping(path = "/card", method = RequestMethod.PUT)
	@ResponseBody
	public String updateCard(@RequestBody Card card) {
		cardService.updateCard(card);
		return "Card updated successfully";
	}
	
	@RequestMapping(path = "/card/suit/{suit}/face/{face}", method = RequestMethod.GET)
	@ResponseBody
	public Card getCard(@PathVariable String suit, @PathVariable String face) {
		return cardService.getCard(face, suit);
	}
	
	
}
