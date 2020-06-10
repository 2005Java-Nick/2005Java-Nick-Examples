package com.revature.blackjack.dto;

import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.Dealer;

public class DealerDTO {
	
	private String name;
	
	private Card shownCard;
	
	public DealerDTO(Dealer dealer) {
		this.name = dealer.getName();
		this.shownCard = dealer.getHand().get(1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card getShownCard() {
		return shownCard;
	}

	public void setShownCard(Card shownCard) {
		this.shownCard = shownCard;
	}

	@Override
	public String toString() {
		return "DealerDTO [name=" + name + ", shownCard=" + shownCard + "]";
	}
	
}
