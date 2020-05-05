package com.revature.blackjack;

public class Dealer extends Person {

	public String hitOrStay() {
		if(this.handScore < 17 ) {
			getNewCard();
			return "hit";
		}
		else {
			return "stay";
		}
	}

}
