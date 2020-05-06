package com.revature.blackjack.player;

public class Dealer extends Player{
	
	@Override
	public String showHand() {
		String displayHand = "?:";
		for (int i = 1; i < this.getHand().length; i++) {
			displayHand += this.getHand()[i];
		}
		return displayHand;
	}
	
	public String showHiddenCards() {
		return super.showHand();
	}

}
