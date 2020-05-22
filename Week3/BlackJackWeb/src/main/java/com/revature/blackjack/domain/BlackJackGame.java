package com.revature.blackjack.domain;

import java.util.List;

public class BlackJackGame {
	
	private Player player;
	
	private Dealer dealer;
	
	private List<Card> deck;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public BlackJackGame(Player player, Dealer dealer, List<Card> deck) {
		super();
		this.player = player;
		this.dealer = dealer;
		this.deck = deck;
	}

	public BlackJackGame() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BlackJackGame [player=" + player + ", dealer=" + dealer + ", deck=" + deck + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dealer == null) ? 0 : dealer.hashCode());
		result = prime * result + ((deck == null) ? 0 : deck.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackJackGame other = (BlackJackGame) obj;
		if (dealer == null) {
			if (other.dealer != null)
				return false;
		} else if (!dealer.equals(other.dealer))
			return false;
		if (deck == null) {
			if (other.deck != null)
				return false;
		} else if (!deck.equals(other.deck))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}
	
}
