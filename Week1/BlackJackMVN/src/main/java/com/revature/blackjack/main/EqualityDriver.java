package com.revature.blackjack.main;

import com.revature.blackjack.player.Player;

public class EqualityDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player();
		Player p2 = new Player();
		p1.setName("Nick");
		p2.setName("Nick");

		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("Equals: " + p1.equals(p2));
		System.out.println("==" + (p1 == p2));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		Player p3 = p2;
		
		p3.setName("Anastasia");
		System.out.println(p2);
		System.out.println(p3==p2);
	}

}
