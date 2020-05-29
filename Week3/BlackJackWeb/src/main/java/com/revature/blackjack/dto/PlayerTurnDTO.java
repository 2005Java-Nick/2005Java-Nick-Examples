package com.revature.blackjack.dto;

//import java.util.List;

//import com.revature.blackjack.domain.BlackJackGame;
import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.Player;

public class PlayerTurnDTO {
	
	private Card nextCard;
	private int next;
	public PlayerTurnDTO(Player player, int next) {

		this.setNextCard(player.getHand().get(next));
	}


	public Card getNextCard() {
		return nextCard;
	}

	public void setNextCard(Card nextCard) {
		this.nextCard = nextCard;
	}


	public int getNext() {
		return next;
	}


	public void setNext(int next) {
		this.next = next;
	}
}
