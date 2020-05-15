package com.revature.util;

import java.util.LinkedList;
import java.util.List;

public class DeckFactory {

	public static List<Card> buildDeck(int numberOfDecks) {

		// Why reference as a List and not an ArrayList?
		List<Card> deck = new LinkedList<Card>();
		
		for (int k = 0; k < numberOfDecks; k++) {
			for (int i = 2; i <= 11; i++) {
				for (int j = 0; j < 4; j++) {
					deck.add(new Card(i));
					if (i == 10) {
						deck.add(new Card(i));
						deck.add(new Card(i));
						deck.add(new Card(i));
					}
				}
			}
		}
		
		return deck;

	}

}
