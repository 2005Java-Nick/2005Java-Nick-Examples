package com.revature.blackjack.service;

import java.util.List;

import com.revature.blackjack.domain.Card;

public interface CardService {
	
	public Card getCard(String face, String suit);
	
	public List<Card> getAllCards();
	
	public List<Card> getRandomCards(int number);
	
	public void createCard(Card card);
	
	public void deleteCard(Card card);

}
