package com.revature.blackjack.gamelogic;

import java.util.List;

import com.revature.blackjack.player.Dealer;
import com.revature.blackjack.player.Player;
import com.revature.util.Card;

public interface BlackJackGame {
	
	public void playDealerHand();
	
	public Dealer getDealer();
	
	public void setDealer(Dealer dealer);
	
	public Player getPlayer();
	
	public void setPlayer(Player p);

	public List<Card> getDeck();
	
	public void setDeck(List<Card> deck);
	
	public void playerHit();
	
	public void setUp();
	
	public String getWinner();
	
	public void dealHands();
	
}
