package com.revature.blackjack;

public class Player {

	private int score;
	
	private int[] hand = new int[14];
	
	private static final int LOW_CARD_VALUE = 1;

	private static final int HIGH_CARD_VALUE = 11;
	
	public Player() {
		this.score=0;
		Double card1 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		hand[0] = card1.intValue();
		// generating a random number from 1 to 11
		Double card2 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		hand[1] = card2.intValue();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int[] getHand() {
		return hand;
	}

	public void setHand(int[] hand) {
		this.hand = hand;
	}
	
	public int calculateScore() {
		score=0;
		for (int i = 0; i < hand.length; i++) {
			score += hand[i];
		}
		return score;
	}
	
	public void showHand(int handIndex)
	{
		for (int i = 0; i < handIndex; i++) {
			System.out.println(hand[i]);
		}
		
	}
	
	public void drawCard(int handIndex) {
		Double newCard = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		hand[handIndex] = newCard.intValue();
	}
	
	
	

}
