package com.revature.blackjack.domain;

import java.util.List;

public class Dealer extends Player{
	
	@Override
	public String showHand() {
		String displayHand = "?:";
		for (int i = 1; i < this.getHand().size(); i++) {
			displayHand += this.getHand().get(i);
		}
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
