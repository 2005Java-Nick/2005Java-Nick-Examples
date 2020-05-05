package com.revature.blackjack;

public abstract class Person {

	protected static final int LOW_CARD_VALUE = 1;
	protected static final int HIGH_CARD_VALUE = 11;
	protected int[] hand = new int[14];
	protected int handIndex = 0;
	protected int handScore = 0;
	
	public int getNewCard() {
		Double doubleCard = Math.random() * HIGH_CARD_VALUE + LOW_CARD_VALUE;
		int card = doubleCard.intValue();
		hand[handIndex] = card;
		handIndex++;
		this.handScore += card;
		return card;
	}

	public int[] getHand() {
		return hand;
	}

	public int getHandIndex() {
		return handIndex;
	}

	public int getHandScore() {
		return handScore;
	}
	
	abstract public String hitOrStay();
	
	
}
