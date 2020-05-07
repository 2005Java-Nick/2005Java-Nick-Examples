package com.revature.blackjack.gamelogic;

import com.revature.blackjack.player.Dealer;

public class BlackJackGameImpl implements BlackJackGame{

	private Dealer dealer;
	
	private int[] deck;
	
	@Override
	public void playDealerHand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dealer getDealer() {
		return dealer;
	}

	@Override
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	@Override
	public int[] getDeck() {
		return this.deck;
	}

	@Override
	public void setDeck(int[] deck) {
		this.deck = deck;
	}

}
