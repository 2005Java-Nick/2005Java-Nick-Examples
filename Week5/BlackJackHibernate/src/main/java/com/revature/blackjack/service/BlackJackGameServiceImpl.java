package com.revature.blackjack.service;

import java.util.Collections;
import java.util.List;

import com.revature.blackjack.domain.BlackJackGame;
import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.Dealer;
import com.revature.blackjack.exception.ScoreLessThanZeroException;
import com.revature.util.DeckFactory;

public class BlackJackGameServiceImpl implements BlackJackGameService {

	private static final String DEALER_NAME = "Captain Jack 'Bill' Sparrow";

	private static final int NUMBER_OF_DECKS = 6;

	public void playDealerHand(BlackJackGame blackJackGame) {
		// TODO Auto-generated method stub

	}

	public void setDeck(List<Card> deck) {
		// TODO Auto-generated method stub

	}

	public void playerHit(BlackJackGame blackJackGame) {
		// TODO Auto-generated method stub

	}

	public void setUp(BlackJackGame blackJackGame) {
		Dealer dealer = new Dealer();
		blackJackGame.setDealer(dealer);
		dealer.setName(DEALER_NAME);
		List<Card> deck = DeckFactory.buildDeck(NUMBER_OF_DECKS);
		Collections.shuffle(deck);
		blackJackGame.setDeck(deck);
		dealHands(blackJackGame);

	}

	public String getWinner(BlackJackGame blackJackGame) {
		// TODO Auto-generated method stub
		return null;
	}

	public void dealHands(BlackJackGame blackJackGame) {
		try {
			blackJackGame.getPlayer().drawCard(blackJackGame.getDeck().get(0));
			blackJackGame.getDeck().remove(0);
			blackJackGame.getPlayer().drawCard(blackJackGame.getDeck().get(0));
			blackJackGame.getDeck().remove(0);
			blackJackGame.getDealer().drawCard(blackJackGame.getDeck().get(0));
			blackJackGame.getDeck().remove(0);
			blackJackGame.getDealer().drawCard(blackJackGame.getDeck().get(0));
			blackJackGame.getDeck().remove(0);
		} catch (ScoreLessThanZeroException e) {
			e.printStackTrace();
		}

	}

}
