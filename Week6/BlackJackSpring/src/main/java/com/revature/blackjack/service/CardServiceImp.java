package com.revature.blackjack.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.blackjack.dao.CardDAO;
import com.revature.blackjack.domain.Card;

@Service
public class CardServiceImp implements CardService {

	private CardDAO cardDao;
	
	@Autowired
	public void setCardDao(CardDAO cardDao) {
		this.cardDao = cardDao;
	}
	
	public Card getCard(String face, String suit) {
		return cardDao.getCard(face, suit);
	}

	public List<Card> getAllCards() {
		return cardDao.getAllCards();
	}

	public List<Card> getRandomCards(int number) {
		List<Card> cards = cardDao.getAllCards();
		Collections.shuffle(cards);
		return cards.subList(0, number);
	}

	public void createCard(Card card) {
		cardDao.createCard(card);
	}

	public void deleteCard(Card card) {
		cardDao.deleteCard(card);
	}

	public void updateCard(Card card) {
		cardDao.updateCard(card);
	}

	public List<Card> getCardsByValue(int value) {
		return cardDao.getCardsByValue(value);
	}

}
