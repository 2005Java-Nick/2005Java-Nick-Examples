package com.revature.blackjack.player;

import java.util.Arrays;

//What is an object? instance variables and methods
//State and Behavior
public class Player {
	
	private int[] hand;
	
	private int score;
	
	private String playerName;
	
	//possibly will need to add an index to add cards to the hand
	//future improvements: bet/wallet/win%
	
	public Player() {
		//first line?
		//always super() or this()
		//super(); implicitly
		this.hand = new int[13];
		this.score = 0;
		this.playerName = "Player" + Math.random()*100;
	}
	
	public Player(String playerName, int score, int[] hand) {
		this();
		//super();
		this.playerName = playerName;
		this.score = score;
		this.hand = hand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(hand);
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + score;
		return result;
	}

	//HashCode Equals Contract: all objects that are equal must have the same hashCode
	//Not all objects that have the same hashCode, are required to be equal
	//Collision
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
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int[] getHand() {
		return hand;
	}

	public void setHand(int[] hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "Player [hand=" + Arrays.toString(hand) + ", score=" + score + ", playerName=" + playerName + "]";
	}
	
	

}
