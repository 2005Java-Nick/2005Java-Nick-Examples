package com.revature.blackjack.domain;

public class Card {
	private int value;
	private String face;
	private String suit;
	
	public Card(int value, String face, String suit) {
		super();
		this.value = value;
		this.face = face;
		this.suit = suit;
	}

	public Card(int value)
	{
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	
}
