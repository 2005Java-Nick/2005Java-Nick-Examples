package com.revature.blackjack.main;

import java.util.Scanner;

/*
 * Example Game:
 *  - dealer shuffles cards
 *  - deals 2 cards face up to player
 *  - deals 1 face up and 1 face down card to self
 *  - player decided to hit or stay
 *  - if get 21, blackjack (automatically wins)
 *  - if goes over 21 bust (automatically lose)
 *  - dealer then decides to hit or stay
 *  - dealer will hit until at 17 or higher
 *  - winner is decided by highest number, not over 21
 *  - dealer wins on a tie
 */

/*
 * BlackJack MVP:
 *  - can take input from user hit(take another card) or stay(end game)
 *  - be able to score/count cards
 *  - Ace needs to count as 1 or 11 (based on current score)
 *  - be able to deal a random card
 *  - keep track of player (score, cards in hand)
 *  - compare to dealers score
 */
public class BlackJackDriver {
	
	// We want to encapsulate our variables inside our classes.
	private static Scanner scan = new Scanner(System.in);
	
	private int playerScore = 0;
	
	private int[] hand = new int[2];
	
	private int dealerScore = 0;
	
	private int[] dealerHand = new int[2];
	
	private static final int LOW_CARD_VALUE = 1;
	
	private static final int HIGH_CARD_VALUE = 11;
	
	//Static - belongs to the class
	public static void main(String[] args) {
		/*
		 * BlackJackDriver bjd = new BlackJackDriver(); bjd.playerScore++;
		 * System.out.println("BJD " + bjd.playerScore); BlackJackDriver bjd2 = new
		 * BlackJackDriver(); System.out.println("BJD2 " + bjd2.playerScore);
		 */
		
		BlackJackDriver bjd = new BlackJackDriver();
		
		//generating a random number from 1 to 11
		Double card1 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		bjd.hand[0] = card1.intValue();
		
		System.out.println(bjd.hand[0]);
		
	}
	
	private void methodA() {
		int intA = 5;
	}
	
	private void methodB() {
		//Out of Scope
		//intA = 7;
	}
	
}
