package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlayerCard {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int handId;
	
	@ManyToOne
	@JoinColumn(name = "playerId")
	private Player player;
	
	@Column
	private String face;
	
	@Column
	private String suit;

	public int getHandId() {
		return handId;
	}

	public void setHandId(int handId) {
		this.handId = handId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		result = prime * result + handId;
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
		PlayerCard other = (PlayerCard) obj;
		if (face == null) {
			if (other.face != null)
				return false;
		} else if (!face.equals(other.face))
			return false;
		if (handId != other.handId)
			return false;
		if (player != other.player)
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
		return "PlayerHand [handId=" + handId + ", playerId=" + player + ", face=" + face + ", suit=" + suit + "]";
	}

	public PlayerCard(int handId, Player player, String face, String suit) {
		super();
		this.handId = handId;
		this.player = player;
		this.face = face;
		this.suit = suit;
	}

	public PlayerCard() {
		super();
	}

}
