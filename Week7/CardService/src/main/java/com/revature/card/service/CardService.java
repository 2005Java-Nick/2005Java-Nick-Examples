package com.revature.card.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.card.domain.Card;

public interface CardService {
	
	public List<Card> getAllCards();
	
	public Card getCardByFaceSuit(String face, String suit);
	
	public void createCard(Card card);
	
	public void updateCard(Card card);
	
	public void deleteCard(Card card);

}
