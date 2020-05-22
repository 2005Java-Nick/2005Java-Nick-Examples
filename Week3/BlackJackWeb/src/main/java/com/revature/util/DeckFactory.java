package com.revature.util;

import java.util.LinkedList;
import java.util.List;

import com.revature.blackjack.dao.CardDAO;
import com.revature.blackjack.dao.CardDAOPostgres;
import com.revature.blackjack.domain.Card;

public class DeckFactory {

	private static CardDAO cardDao = new CardDAOPostgres();
	
	public static List<Card> buildDeck(int numberOfDecks) {

		// Why reference as a List and not an ArrayList?
		List<Card> deck = new LinkedList<Card>();
		List<Card> allCards = cardDao.getAllCards();
		for (int i = 0; i < numberOfDecks; i++) {
			deck.addAll(allCards);
		}
		return deck;

	}

}
