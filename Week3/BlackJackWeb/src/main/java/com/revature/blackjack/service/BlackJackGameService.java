package com.revature.blackjack.service;

import java.util.List;

import com.revature.blackjack.domain.BlackJackGame;
import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.Dealer;
import com.revature.blackjack.domain.Player;

public interface BlackJackGameService {
	
	public void playDealerHand(BlackJackGame blackJackGame);
	
	public void setDeck(List<Card> deck);
	
	public void playerHit(BlackJackGame blackJackGame);
	
	public void setUp(BlackJackGame blackJackGame);
	
	public String getWinner(BlackJackGame blackJackGame);
	
	public void dealHands(BlackJackGame blackJackGame);
	
}
