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
		
		//Draw inital hands
		blackJackGame.dealHands();
		
		//display hands
		System.out.println("Player hand: " + blackJackGame.getPlayer().showHand());
		System.out.println("Dealer hand: " + blackJackGame.getDealer().showHand());
		
		//Run dealer on own Thread
		Runnable r = new DealerThread(blackJackGame);
		Thread t = new Thread(r);
		t.start();
		
		//Player play hand
		String answer = "";
		do {
			System.out.println("Hit or stand");
			answer = scan.nextLine();
			if ("hit".equalsIgnoreCase(answer)) {
				blackJackGame.playerHit();
			}
			//display hands
			System.out.println("Player hand: " + blackJackGame.getPlayer().showHand());
			System.out.println("Dealer hand: " + blackJackGame.getDealer().showHand());
		} while (!"stand".equalsIgnoreCase(answer));
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Final hands: ");
		System.out.println(blackJackGame.getPlayer().getName() + ": " + blackJackGame.getPlayer().showHand());
		System.out.println(blackJackGame.getDealer().getName() + ": " + blackJackGame.getDealer().showHiddenCards());
		
		System.out.println("Winner: " + blackJackGame.getWinner());
		
		System.out.println("Congratulations " + blackJackGame.getPlayer().getName() + 
				" You now have " + blackJackGame.getPlayer().getTokens() + " Tokens");
		
		playerDao.savePlayer(blackJackGame.getPlayer());
		
	}

}
