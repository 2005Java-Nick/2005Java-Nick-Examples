package com.revature.util;

import java.util.LinkedList;
import java.util.List;

public class DeckFactory {

	public static List<Card> buildDeck(int numberOfDecks) {

		// Why reference as a List and not an ArrayList?
		List<Card> deck = new LinkedList<Card>();
		
		for (int i = 0; i < numberOfDecks; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 1; k <= 13; k++) {
					deck.add(makeCard(j, k));
				}
			}
		}
		return deck;
	}
	
	private static Card makeCard(int s, int f) {
		String suit = "";
		String face = "";
		switch(s) {
			case 0:
				suit = "Spades";
				break;
			case 1:
				suit = "Diamonds";
				break;
			case 2:
				suit = "Clubs";
				break;
			case 3:
				suit = "Hearts";
				break;
		}
		switch(f) {
			case 1:
				face = "Ace";
				break;
			case 2:
				face = "Two";
				break;
			case 3:
				face = "Three";
				break;
			case 4:
				face = "Four";
				break;
			case 5:
				face = "Five";
				break;
			case 6:
				face = "Six";
				break;
			case 7:
				face = "Seven";
				break;
			case 8:
				face = "Eight";
				break;
			case 9:
				face = "Nine";
				break;
			case 10:
				face = "Ten";
				break;
			case 11:
				face = "Jack";
				break;
			case 12:
				face = "Queen";
				break;
			case 13:
				face = "King";
				break;
		}
		return new Card(suit, face);
	}

}
