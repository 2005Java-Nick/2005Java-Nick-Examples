package com.example.demo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



//What is an object? instance variables and methods
//State and Behavior
@Entity
@Table(name = "player")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property ="id")
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private int id;

	@Column(name = "player_score")
	private int score;
	
	@Column(name = "player_name")
	private String name;
	
	@Column(name = "player_tokens")
	private int tokens;
	
	@OneToMany(mappedBy = "player", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = PlayerCard.class)
	List<PlayerCard> hand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Player(int id, int score, String name, int tokens, List<PlayerCard> hand) {
		super();
		this.id = id;
		this.score = score;
		this.name = name;
		this.tokens = tokens;
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", score=" + score + ", name=" + name + ", tokens=" + tokens + ", hand=" + hand
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Player other = (Player) obj;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		if (tokens != other.tokens)
			return false;
		return true;
	}

	public List<PlayerCard> getHand() {
		return hand;
	}

	public void setHand(List<PlayerCard> hand) {
		this.hand = hand;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
