package com.revature.blackjack;

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
	
	private static Player player;
	
	private static Player dealer;

	// Static - belongs to the class
	public static void main(String[] args) {
		
		//Create instance of Player and Dealer
		player=new Player();
		
		dealer=new Player();
		
		// Prints out hands
		System.out.println("Players hand: ");

		player.showHand(2);
		
		//Show Score
		
		System.out.println("Player Score: "+player.calculateScore());
		
		System.out.println("Dealer showing: ");

		dealer.showHand(1);
		
		System.out.println("?");
		
		//Validates player Blackjack
		
		if(player.calculateScore()==21) {
			
			System.out.println("BLACKJACK!!!! PLAYER WINs!!!!");
			
		} else {
			
			//Players Turn
			
			System.out.println("Hit or Stay");
			
			String hitOrStay = scan.nextLine();
			
			int handIndex = 2; // keep track of position in player hand to add new card
			
			boolean playerBust=false; 
			
			while (player.calculateScore() < 21 && hitOrStay.equals("hit")) {
				
				player.drawCard(handIndex);
				
				handIndex++;

				// Show player their hand
				
				System.out.println("Players hand: ");
				
				player.showHand(handIndex);
				
				//Show Score
				
				System.out.println("Player Score: "+player.calculateScore());

				// calculate players score
				

				if (player.calculateScore() > 21) {

					playerBust=true;
					
					System.out.println("BUST");

				} 
				else if(player.calculateScore() == 21){
					
					break ;
					
				}else {

					System.out.println("Hit or Stay");
					hitOrStay = scan.nextLine();

				}

			}

				// Show dealers hand
				System.out.println("Dealers hand: ");
				
				dealer.showHand(2);

			if(!playerBust) {
					
				int dealerHandIndex = 2; // keep track of position in dealer hand to add new card
				
				while (dealer.calculateScore()< 17) {
					
					dealer.drawCard(dealerHandIndex);
					
					dealerHandIndex++;
					
					//Show dealer score
					
					System.out.println("Dealer Score: "+dealer.calculateScore());
					
					// calculate dealers score
	
					System.out.println("Dealers hand: ");
					
					dealer.showHand(dealerHandIndex);
				}
			}
			
			System.out.println("Player score: " + player.calculateScore());

			System.out.println("Dealer's Score: " + dealer.calculateScore());

			if (player.calculateScore() > dealer.calculateScore() && player.calculateScore() <= 21) {
				
				System.out.println("Player Wins");
				
			} else {
				
				System.out.println("Dealer Wins");
				
			}

		}

	}

}
