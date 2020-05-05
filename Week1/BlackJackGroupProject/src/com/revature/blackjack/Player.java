package com.revature.blackjack;

import java.util.Scanner;

public class Player extends Person {
	
	Scanner scan = new Scanner(System.in);
	
	
	public String hitOrStay() {
		
		System.out.println("Hit or Stay?");
		
		String answer = scan.nextLine();
		
		while(!(answer.equals("hit") || answer.equals("stay"))) {
			System.out.println("Wrong input. Hit or Stay?");
			answer = scan.nextLine();
		}
		
		if(answer.equals("hit")) {
			System.out.println(getNewCard());
			return "hit";
		}
		else {
			return "stay";
		}

	}
}
