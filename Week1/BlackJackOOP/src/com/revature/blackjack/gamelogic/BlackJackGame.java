package com.revature.blackjack.gamelogic;

import com.revature.blackjack.player.Dealer;

public interface BlackJackGame {
	
	public void playDealerHand();
	
	public Dealer getDealer();
	
	public void setDealer(Dealer dealer);

	public int[] getDeck();
	
	public void setDeck(int[] deck);
	
}
