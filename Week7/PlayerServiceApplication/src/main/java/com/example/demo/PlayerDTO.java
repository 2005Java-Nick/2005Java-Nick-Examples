package com.example.demo;

import java.util.List;

public class PlayerDTO {
	
	private int playerId;
	
	private String name;
	
	private int tokens;
	
	private int score;
	
	private List<Card> hand;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + playerId;
		result = prime * result + score;
		result = prime * result + tokens;
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
		PlayerDTO other = (PlayerDTO) obj;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (playerId != other.playerId)
			return false;
		if (score != other.score)
			return false;
		if (tokens != other.tokens)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerDTO [playerId=" + playerId + ", name=" + name + ", tokens=" + tokens + ", score=" + score
				+ ", hand=" + hand + "]";
	}

	public PlayerDTO(int playerId, String name, int tokens, int score, List<Card> hand) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.tokens = tokens;
		this.score = score;
		this.hand = hand;
	}

	public PlayerDTO() {
		super();
	}
	
	

}
