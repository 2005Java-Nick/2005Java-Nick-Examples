package com.revature.blackjack;

import java.util.Scanner;
import java.lang.Math;
import java.lang.Double;

public class BlackJackDriver {

		
		
		//Main method
		//Static - belongs to the class
		public static void main(String[] args) {
			
			Player player = new Player();
			Dealer dealer = new Dealer();
			
			
			System.out.print("Your cards: " + player.getNewCard());
			System.out.println(" and " + player.getNewCard());
			
			System.out.println("Dealer\'s card: " + dealer.getNewCard());
			dealer.getNewCard();
			
			String playerAction = player.hitOrStay();
			
			while (playerAction.equals("hit")) {
				dealer.hitOrStay();
				playerAction = player.hitOrStay();
				if (player.getHandScore() > 21) {
					System.out.println("Bust");
					break;
				}
			}
			
			System.out.println("Your score is: " + player.getHandScore());
			System.out.println("Dealer\'s score is: " + dealer.getHandScore());
			
			
			
		}
		
		
		
}


