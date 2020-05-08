package com.revature.util;

import java.util.LinkedList;
import java.util.List;

public class DeckFactory {

	public static List<Integer> buildDeck(int numberOfDecks) {

		// Why reference as a List and not an ArrayList?
		List<Integer> deck = new LinkedList<Integer>();
		
		for (int k = 0; k < numberOfDecks; k++) {
			for (int i = 2; i <= 11; i++) {
				for (int j = 0; j < 4; j++) {
					deck.add(i);
					if (i == 10) {
						deck.add(i);
						deck.add(i);
						deck.add(i);
					}
				}
			}
		}
		
		return deck;

	}

}
