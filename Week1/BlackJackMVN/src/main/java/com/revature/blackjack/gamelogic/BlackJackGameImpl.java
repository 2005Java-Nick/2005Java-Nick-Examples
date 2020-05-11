package com.revature.blackjack.gamelogic;

import java.util.Collections;
import java.util.List;

import com.revature.blackjack.exception.ScoreLessThanZeroException;
import com.revature.blackjack.player.Dealer;
import com.revature.blackjack.player.Player;
import com.revature.util.DeckFactory;

public class BlackJackGameImpl implements BlackJackGame {
	
	private static BlackJackGameImpl bjgi;
	
	private static final String DEALER_NAME = "Captain Jack 'Bill' Sparrow";
	
	private static final int NUMBER_OF_DECKS = 6;

	private Player player;

	private Dealer dealer;

	private List<Integer> deck;

	private DealerLogic dealerLogic = new DealerLogicImpl();
	
	public static BlackJackGame getBlackJackGame() {
		if (bjgi == null) {
			bjgi = new BlackJackGameImpl();
		}
		
		return bjgi;
	}

	private BlackJackGameImpl() {
	}
	
	@Override
	public void playDealerHand() {

		if (!dealerLogic.stand(dealer)) {
			dealerLogic.hit(dealer, deck);
		}

	}

	@Override
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public void setPlayer(Player p) {
		this.player = player;
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
	public List<Integer> getDeck() {
		return this.deck;
	}

	@Override
	public void setDeck(List<Integer> deck) {
		this.deck = deck;
	}

	public void setDealerLogic(DealerLogic dealerLogic) {
		this.dealerLogic = dealerLogic;
	}

	@Override
	public void playerHit() {
		try {
			player.drawCard(deck.get(0));
			deck.remove(0);
		} catch (ScoreLessThanZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setUp() {
		this.dealer = new Dealer();
		dealer.setName(DEALER_NAME);
		this.deck = DeckFactory.buildDeck(NUMBER_OF_DECKS);
		Collections.shuffle(this.deck);
	}

	public String getWinner() {

		if (player.getScore() > dealer.getScore()) {
			player.setTokens(player.getTokens() + 10);
			return "Player: " + player.getName();
		} else {
			player.setTokens(player.getTokens() - 10);
			return "Dealer: " + dealer.getName();
		}

	}

	@Override
	public void dealHands() {
		try {
			player.drawCard(deck.get(0));
			deck.remove(0);
			player.drawCard(deck.get(0));
			deck.remove(0);
			dealer.drawCard(deck.get(0));
			deck.remove(0);
			dealer.drawCard(deck.get(0));
			deck.remove(0);
		} catch (ScoreLessThanZeroException e) {
			e.printStackTrace();
		}
		
	}

}
