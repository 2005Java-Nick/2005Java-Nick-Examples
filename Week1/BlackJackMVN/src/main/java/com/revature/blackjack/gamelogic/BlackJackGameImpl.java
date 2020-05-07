package com.revature.blackjack.gamelogic;

import com.revature.blackjack.player.Dealer;

public class BlackJackGameImpl implements BlackJackGame{

	private Dealer dealer;
	
	private int[] deck;
	
	private DealerLogic dealerLogic;
	
	@Override
	public void playDealerHand() {
		
		if(!dealerLogic.stand(dealer)) {
			dealerLogic.hit(dealer, deck);
		}
		
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
	
	public void setDealerLogic(DealerLogic dealerLogic) {
		this.dealerLogic = dealerLogic;
	}

}
