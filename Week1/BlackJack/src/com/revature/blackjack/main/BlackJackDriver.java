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

/*
 * 	Improvements:
 * 	- create ShowHand method
 * 	- create Deal method
 * 	- create Participant class with score and hand variables, deal and show hand methods
 */



class Participant {
	private static final int LOW_CARD_VALUE = 1;
	private static final int HIGH_CARD_VALUE = 11;
	int score = 0;
	int[] hand = new int[14];
	int handIndex = 0;
	
	public void Deal() {
		Double card = ((Math.random() * HIGH_CARD_VALUE) + LOW_CARD_VALUE);
		this.hand[handIndex] = card.intValue();
		this.score += card.intValue();
		this.handIndex++;
	}
	
	public void DealAce() {
		this.hand[handIndex] = 11;
		this.score += 11;
		this.handIndex++;
	}
	
	public void ShowHand() {
		for (int i = 0; i < handIndex; i++) {
			System.out.println(this.hand[i]);
		}
	}
}

class Dealer extends Participant {
	public void ShowDealerHand() {
		for (int i = 0; i < handIndex; i++) {
			if (i == 1) {
				System.out.println("?");
			} else {
				System.out.println(this.hand[i]);
			}
		}
	}
}

public class BlackJackDriver {

	// We want to encapsulate our variables inside our classes.
	private static Scanner scan = new Scanner(System.in);

	// Static - belongs to the class
	public static void main(String[] args) {
		/*
		 * BlackJackDriver bjd = new BlackJackDriver(); bjd.playerScore++;
		 * System.out.println("BJD " + bjd.playerScore); BlackJackDriver bjd2 = new
		 * BlackJackDriver(); System.out.println("BJD2 " + bjd2.playerScore);
		 */

		BlackJackDriver bjd = new BlackJackDriver();
		Participant player = new Participant();
		Dealer dealer = new Dealer();
		// Deal Players Hand
		player.Deal();
		player.DealAce();
		// Show player their hand
		System.out.println("Players hand: ");
		player.ShowHand();
		
		
		// Dealers Hand
		dealer.Deal();
		dealer.Deal();
		// Show player their hand
		System.out.println("Dealer showing: ");
		dealer.ShowDealerHand();

		// check BlackJack
		if (player.score == 21) {
			System.out.println("BLACKJACK!!!! PLAYER WINs!!!!");
		} else {
			System.out.println("Hit or Stay");
			String hitOrStay = scan.nextLine();
			while (player.score < 21 && hitOrStay.equals("hit")) {
				// Deal Player New card
				player.Deal();

				// Show player their hand
				System.out.println("Players hand: ");
				player.ShowHand();

				if (player.score > 21) {
					for(int i = 0; i < player.handIndex; i++) {
						if (player.hand[i] == 11) {
							player.hand[i] = 1;
							player.score -= 10;
							break;
						}
					}
					System.out.println("BUST");
				} else {
					System.out.println("Hit or Stay");
					hitOrStay = scan.nextLine();
				}

			}

			// Show dealers hand
			dealer.ShowHand();
			
			while (dealer.score < 17) {
				// Dealer hits
				// Deal Dealer New card
				dealer.Deal();
				
				// Show dealers hand
				dealer.ShowHand();
			}
			
			System.out.println("Player score: " + player.score);

			System.out.println("Dealer's Score: " + dealer.score);

			if (player.score > dealer.score && player.score <= 21) {
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
