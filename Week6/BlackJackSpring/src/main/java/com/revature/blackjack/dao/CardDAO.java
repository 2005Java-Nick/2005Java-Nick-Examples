package com.revature.blackjack.dao;

import java.util.List;

import com.revature.blackjack.domain.Card;

public interface CardDAO {
	
	public List<Card> getAllCards();
	
	public Card getCard(String face, String suit);
	
	public void createCard(Card card);
	
	public void deleteCard(Card card);
	
	public void updateCard(Card card);

}
