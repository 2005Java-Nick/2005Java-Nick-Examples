package com.revature.card.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card implements Serializable{
	
	private static final long serialVersionUID = 3635551378827905726L;

	@Column(name = "cards_value")
	private int value;
	
	@EmbeddedId
	private CardId cardId;
	
	public Card(int value, String face, String suit) {
		this();
		this.value = value;
		this.setFace(face);
		this.setSuit(suit);
	}

	public Card(int value)
	{
		this();
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getFace() {
		return cardId.getFace();
	}
	public void setFace(String face) {
		this.cardId.setFace(face);
	}
	public String getSuit() {
		return this.cardId.getSuit();
	}
	public void setSuit(String suit) {
		this.cardId.setSuit(suit);
	}

	public Card() {
		super();
		this.cardId = new CardId();
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", cardId=" + cardId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardId == null) ? 0 : cardId.hashCode());
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
		if (cardId == null) {
			if (other.cardId != null)
				return false;
		} else if (!cardId.equals(other.cardId))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
}
