package com.revature.blackjack.main;

import java.util.Scanner;

import com.revature.blackjack.player.Player;

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

	private int dealerScore = 0;

	private int[] dealerHand = new int[13];

	private static final int LOW_CARD_VALUE = 1;

	private static final int HIGH_CARD_VALUE = 11;

	// Static - belongs to the class
	public static void main(String[] args) {
		/*
		 * BlackJackDriver bjd = new BlackJackDriver(); bjd.playerScore++;
		 * System.out.println("BJD " + bjd.playerScore); BlackJackDriver bjd2 = new
		 * BlackJackDriver(); System.out.println("BJD2 " + bjd2.playerScore);
		 */

		BlackJackDriver bjd = new BlackJackDriver();
		Player player = new Player();
		// Deal Players Hand
		// generating a random number from 1 to 11
		Double card1 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		player.drawCard(0, card1.intValue());
		
		// generating a random number from 1 to 11
		Double card2 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		player.drawCard(1, card2.intValue());
		
		// Show player their hand
		System.out.println("Players hand: ");
		System.out.println(player.showHand());

		// Dealers Hand
		// generating a random number from 1 to 11
		Double dealerCard1 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		bjd.dealerHand[0] = dealerCard1.intValue();
		// generating a random number from 1 to 11
		Double dealerCard2 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		bjd.dealerHand[1] = dealerCard2.intValue();
		// Show player their hand
		System.out.println("Dealer showing: ");
		System.out.println(bjd.dealerHand[0]);
		System.out.println("?");

		// check BlackJack
		if (player.getScore() == 21) {
			System.out.println("BLACKJACK!!!! PLAYER WINs!!!!");
		} else {
			System.out.println("Hit or Stay");
			String hitOrStay = scan.nextLine();
			int handIndex = 2; // keep track of position in player hand to add new card
			while (player.getScore() < 21 && hitOrStay.equals("hit")) {
				// Deal Player New card
				// generating a random number from 1 to 11
				Double newCard = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
				player.drawCard(handIndex, newCard.intValue());
				handIndex++;

				// Show player their hand
				System.out.println("Players hand: ");
				System.out.println(player.showHand());
				
				if (player.getScore() > 21) {

					System.out.println("BUST");

				} else {

					System.out.println("Hit or Stay");
					hitOrStay = scan.nextLine();

				}

			}

			// calculate dealers score
			bjd.dealerScore = 0;
			for (int i = 0; i < bjd.dealerHand.length; i++) {
				bjd.dealerScore += bjd.dealerHand[i];
			}

			// Show dealers hand
			System.out.println("Dealers hand: ");
			for (int i = 0; i < 2; i++) {
				System.out.println(bjd.dealerHand[i]);
			}
			
			int dealerHandIndex = 2; // keep track of position in dealer hand to add new card
			while (bjd.dealerScore < 17) {
				// Dealer hits
				// Deal Dealer New card
				// generating a random number from 1 to 11
				Double newDealerCard = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
				bjd.dealerHand[dealerHandIndex] = newDealerCard.intValue();
				dealerHandIndex++;
				
				// calculate dealers score
				bjd.dealerScore = 0;
				for (int i = 0; i < bjd.dealerHand.length; i++) {
					bjd.dealerScore += bjd.dealerHand[i];
				}
				
				// Show dealers hand
				System.out.println("Dealers hand: ");
				for (int i = 0; i < dealerHandIndex; i++) {
					System.out.println(bjd.dealerHand[i]);
				}
			}
			
			System.out.println("Player score: " + player.getScore());

			System.out.println("Dealer's Score: " + bjd.dealerScore);

			if (player.getScore() > bjd.dealerScore && player.getScore() <= 21) {
				System.out.println("Player Wins");
			} else {
				System.out.println("Dealer Wins");
			}

		}

	}

	/*
	 * private void methodA() { int intA = 5; }
	 * 
	 * private void methodB() { //Out of Scope //intA = 7; }
	 */

}
