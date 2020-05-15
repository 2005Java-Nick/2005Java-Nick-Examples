package com.revature.blackjack.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.blackjack.exception.ScoreLessThanZeroException;
import com.revature.util.Card;

//What is an object? instance variables and methods
//State and Behavior
public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6672840687700942664L;

	//Logs allow us to have a record of what is happening in our program
	//Logging levels include: Fatal, Error, Warn, Debug, Info, & Trace
	private static Logger log = Logger.getRootLogger();

	private transient List<Card> hand;

	private transient int score;

	private String name;
	
	private int tokens;

	// Player Logic
	public void drawCard(Card card) throws ScoreLessThanZeroException {
		this.drawCard(this.getHand().size(), card);
	}
	
	public void drawCard(int index, Card card) throws ScoreLessThanZeroException {

		this.getHand().add(index, card);

		try {
			calculateScore(card);
		} catch (IllegalArgumentException e) {
			log.error("Negative Score Calculated", e);
			this.getHand().remove(index);
			throw new ScoreLessThanZeroException(e);
		}

	}

	private void calculateScore(Card card) {
		this.setScore(this.getScore() + card.getValue());
	}

	public String showHand() {
		String displayHand = "";
		for (Card card : this.getHand()) {
			displayHand += card.getCardName();
			displayHand += ", ";
		}
		displayHand = displayHand.replaceAll(", $", "");
		return displayHand;
	}

	public boolean reduceAce() {
		for(Card c : hand) {
			if(c.getValue() == 11) {
				c.setValue(1);
				return true;
			}
		}
		return false;
	}
	// possibly will need to add an index to add cards to the hand
	// future improvements: bet/wallet/win%/skipping or joining game

	public Player() {
		// first line?
		// always super() or this()
		// super(); implicitly
		this.hand = new ArrayList<Card>();
		this.score = 0;
		this.name = "Player" + Math.random() * 100;
	}

	public Player(String name, int score, List<Card> hand) {
		this();
		// super();
		this.name = name;
		this.score = score;
		this.hand = hand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hand.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	// HashCode Equals Contract: all objects that are equal must have the same
	// hashCode
	// Not all objects that have the same hashCode, are required to be equal
	// Collision
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (!hand.equals(other.hand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setScore(int score) {
		if (score >= 0) {
			this.score = score;
		} else {
			throw new IllegalArgumentException("Negative score reached");
		}
	}

	public int getScore() {
		return this.score;
	}

	protected List<Card> getHand() {
		return hand;
	}

	private void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	@Override
	public String toString() {
		return "Player [hand=" + hand.toString() + ", score=" + score + ", name=" + name + "]";
	}

}
