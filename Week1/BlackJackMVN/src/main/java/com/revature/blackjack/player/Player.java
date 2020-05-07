package com.revature.blackjack.player;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.revature.blackjack.exception.ScoreLessThanZeroException;

//What is an object? instance variables and methods
//State and Behavior
public class Player {
	
	//Logs allow us to have a record of what is happening in our program
	//Logging levels include: Fatal, Error, Warn, Debug, Info, & Trace
	private static Logger log = Logger.getRootLogger();

	private int[] hand;

	private int score;

	private String name;

	// Player Logic
	public void drawCard(int index, int card) throws ScoreLessThanZeroException {

		this.getHand()[index] = card;

		try {
			calculateScore(card);
		} catch (IllegalArgumentException e) {
			log.error("Negative Score Calculated", e);
			this.getHand()[index] = 0;
			throw new ScoreLessThanZeroException(e);
		}

	}

	private void calculateScore(int card) {
		this.setScore(this.getScore() + card);
	}

	public String showHand() {
		String displayHand = "";
		for (int card : this.getHand()) {
			displayHand += card;
			displayHand += ":";
		}
		return displayHand;
	}

	// possibly will need to add an index to add cards to the hand
	// future improvements: bet/wallet/win%/skipping or joining game

	public Player() {
		// first line?
		// always super() or this()
		// super(); implicitly
		this.hand = new int[13];
		this.score = 0;
		this.name = "Player" + Math.random() * 100;
	}

	public Player(String name, int score, int[] hand) {
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
		result = prime * result + Arrays.hashCode(hand);
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
		if (!Arrays.equals(hand, other.hand))
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

	private void setScore(int score) {
		if (score >= 0) {
			this.score = score;
		} else {
			throw new IllegalArgumentException("Negative score reached");
		}
	}

	public int getScore() {
		return this.score;
	}

	protected int[] getHand() {
		return hand;
	}

	private void setHand(int[] hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "Player [hand=" + Arrays.toString(hand) + ", score=" + score + ", name=" + name + "]";
	}

}
