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
	private int[] hand = new int[14];
	private int dealerScore = 0;
	private int[] dealerHand = new int[13];

	private static final int LOW_CARD_VALUE = 1;
	private static final int HIGH_CARD_VALUE = 11;
	
	private static BlackJackDriver bjd;
	
	private int handIndex;	
	private int dealerHandIndex; // keep track of position in dealer hand to add new card
	// Static - belongs to the class
	public static void main(String[] args) {
		
		bjd = new BlackJackDriver();
		 bjd.dealHands();
		bjd.checkBlackJack();
	}
			
	private void dealHands() {		
		// Deal Players Hand                  
		//dealPlayerHand();
		// generating a random number from 1 to 11
		Double card1 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		bjd.hand[0] = card1.intValue();
		// generating a random number from 1 to 11
		Double card2 = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		bjd.hand[1] = card2.intValue();
		// Show player their hand
		System.out.println("Players hand: ");
		System.out.println(bjd.hand[0]);
		System.out.println(bjd.hand[1]);

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
	}	
	private void calcPlayerScore() {
		bjd.playerScore = 0;
		for (int i = 0; i < bjd.hand.length; i++) {
			bjd.playerScore += bjd.hand[i];
		}

	}
	private void calcDealerScore() {
		bjd.dealerScore = 0;
		for (int i = 0; i < bjd.dealerHand.length; i++) {
			bjd.dealerScore += bjd.dealerHand[i];
		}
	}
	private void showPlayerHand() {
		System.out.println("Players hand: ");
		for (int i = 0; i < handIndex; i++) {
			System.out.println(bjd.hand[i]);
		}
	}	
	private void showDealerHand() {
		System.out.println("Dealers hand: ");
		for (int i = 0; i < 2; i++) {
			System.out.println(bjd.dealerHand[i]);
		}
	}
	private void checkBlackJack() {
		// check BlackJack
		if (bjd.hand[0] + bjd.hand[1] == 21) {
			System.out.println("BLACKJACK!!!! PLAYER WINs!!!!");
		} else {
			System.out.println("Hit or Stay");
			String hitOrStay = scan.nextLine();
			handIndex = 2;
			while (bjd.playerScore < 21 && hitOrStay.equals("hit")) {
				// Deal Player New card
				// generating a random number from 1 to 11
				
				Double newCard = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
				bjd.hand[handIndex] = newCard.intValue();
				handIndex++;

				// Show player their hand
				showPlayerHand();

				// calculate players score
				calcPlayerScore();
			
				if (bjd.playerScore > 21) {

					System.out.println("BUST");

				} else {
					
					System.out.println("Hit or Stay");
					hitOrStay = scan.nextLine();
				}
			}
			// calculate players score
			// Recalculating in case the player did not hit
			calcPlayerScore();
			// calculate dealers score
			calcDealerScore();
			// Show dealers hand
			showDealerHand();
			
			while (bjd.dealerScore < 17) {
				// Dealer hits
				// Deal Dealer New card
				// generating a random number from 1 to 11
				Double newDealerCard = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
				bjd.dealerHand[dealerHandIndex] = newDealerCard.intValue();
				dealerHandIndex++;
				
				// calculate dealers score
				calcDealerScore();
				
				// Show dealers hand
				showDealerHand();
			}
			System.out.println("Player score: " + bjd.playerScore);

			System.out.println("Dealer's Score: " + bjd.dealerScore);

			if (bjd.playerScore > bjd.dealerScore && bjd.playerScore <= 21) {
				System.out.println("Player Wins");
			} else {
				System.out.println("Dealer Wins");
			}

		}
	}
}
