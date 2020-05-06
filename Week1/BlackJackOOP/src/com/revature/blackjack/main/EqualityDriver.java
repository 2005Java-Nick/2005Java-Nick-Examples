package com.revature.blackjack.main;

import com.revature.blackjack.player.Player;

public class EqualityDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player();
		Player p2 = new Player();
		p1.setPlayerName("Nick");
		p2.setPlayerName("Nick");
		p1.setScore(10);
		p2.setScore(10);
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("Equals: " + p1.equals(p2));
		System.out.println("==" + (p1 == p2));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		Player p3 = p2;
		
		p3.setPlayerName("Anastasia");
		System.out.println(p2);
		System.out.println(p3==p2);
	}

}
