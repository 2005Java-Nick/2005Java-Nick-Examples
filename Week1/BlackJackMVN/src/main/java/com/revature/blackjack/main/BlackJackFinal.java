package com.revature.blackjack.main;

import java.util.Scanner;

import com.revature.blackjack.dao.PlayerDAO;
import com.revature.blackjack.dao.PlayerDAOSerialization;
import com.revature.blackjack.gamelogic.BlackJackGame;
import com.revature.blackjack.gamelogic.BlackJackGameImpl;
import com.revature.blackjack.player.Player;
import com.revature.util.DealerThread;

public class BlackJackFinal {
	
	private static final BlackJackGame blackJackGame = BlackJackGameImpl.getBlackJackGame();
	
	private static PlayerDAO playerDao = new PlayerDAOSerialization();

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		blackJackGame.setUp();
		
		System.out.println("Hello player. What is your name?");
		
		String playername = scan.nextLine();
		
		Player p = playerDao.getPlayer(playername);
		
		if (p == null) {
			p = new Player();
			p.setName(playername);
		}
		
		blackJackGame.setPlayer(p);
		
		//Draw initial hands
		blackJackGame.dealHands();
		
		//display hands
		System.out.println("Shuffling cards...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("Dealing cards...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("Player hand: " + blackJackGame.getPlayer().showHand());
		System.out.println("Dealer hand: " + blackJackGame.getDealer().showHand());
		
		//Run dealer on own Thread
		Runnable r = new DealerThread(blackJackGame);
		Thread t = new Thread(r);
		
		
		//Player play hand
		String answer = "";
		do {
			System.out.println("Hit or stand");
			answer = scan.nextLine();
			if ("hit".equalsIgnoreCase(answer)) {
				blackJackGame.playerHit();
			}
			System.out.println("Player hand: " + blackJackGame.getPlayer().showHand());
			System.out.println("Dealer hand: " + blackJackGame.getDealer().showHand());
			if(blackJackGame.getPlayer().getScore() > 21) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(blackJackGame.getPlayer().reduceAce()) {
					blackJackGame.getPlayer().setScore(blackJackGame.getPlayer().getScore()-10);
					System.out.println("The value of your ace was reduced from 11 to 1.");
				} else {
					System.out.println("Bust!");
				}
			}
			if(blackJackGame.getPlayer().getScore() == 21) {
				System.out.println("Your hand is now worth 21 points!");
			}
		} while (!"stand".equalsIgnoreCase(answer) && blackJackGame.getPlayer().getScore() < 21);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(blackJackGame.getPlayer().getScore() < 22) {
			t.start();
		}
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nWinner: " + blackJackGame.getWinner() + "\n");
		System.out.println("Player hand: " + blackJackGame.getPlayer().showHand());
		System.out.println("Player score: " + blackJackGame.getPlayer().getScore());
		System.out.println("Dealer hand: " + blackJackGame.getDealer().showHiddenCards());
		System.out.println("Dealer score: " + blackJackGame.getDealer().getScore());
		System.out.println(blackJackGame.getPlayer().getName() + 
				", you now have " + blackJackGame.getPlayer().getTokens() + " Tokens.");
		
		playerDao.savePlayer(blackJackGame.getPlayer());
		
	}

}
