package com.revature.blackjack.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CardId implements Serializable {

	private static final long serialVersionUID = -2982787869991976454L;

	@Column(name = "cards_face")
	private String face;
	
	@Column(name = "cards_suit")
	private String suit;

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

	public CardId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardId(String face, String suit) {
		super();
		this.face = face;
		this.suit = suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		CardId other = (CardId) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "CardId [face=" + face + ", suit=" + suit + "]";
	}
	
}

