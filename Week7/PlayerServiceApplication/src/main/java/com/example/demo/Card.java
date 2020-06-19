package com.example.demo;

public class Card {
	
	private String face;
	
	private String suit;
	
	private int value;

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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (face == null) {
			if (other.face != null)
				return false;
		} else if (!face.equals(other.face))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [face=" + face + ", suit=" + suit + ", value=" + value + "]";
	}

	public Card(String face, String suit, int value) {
		super();
		this.face = face;
		this.suit = suit;
		this.value = value;
	}

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
