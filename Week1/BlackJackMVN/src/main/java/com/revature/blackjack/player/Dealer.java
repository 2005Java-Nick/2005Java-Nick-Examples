package com.revature.blackjack.player;

import java.util.List;

import com.revature.util.Card;

public class Dealer extends Player{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3056488063136524247L;

	@Override
	public String showHand() {
		String displayHand = "?, ";
		for (int i = 1; i < this.getHand().size(); i++) {
			displayHand += this.getHand().get(i).getCardName() + ", ";
		}
		displayHand = displayHand.replaceFirst(", $", "");
		return displayHand;
	}
	
	public String showHiddenCards() {
		return super.showHand();
	}

	public Dealer() {
		super();
	}

	public Dealer(String name, int score, List<Card> hand) {
		super(name, score, hand);
	}
	
	

}
