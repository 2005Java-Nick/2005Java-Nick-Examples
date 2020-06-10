package com.revature.blackjack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public List<Card> getAllCards() {
		return cardService.getAllCards();
	}
	
}
