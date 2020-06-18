package com.revature.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.revature.Exception.ScoreLessThanZeroException;


//What is an object? instance variables and methods
//State and Behavior
@Entity
@Table(name = "player")
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private int id;
	
	@ManyToMany()
	@JoinTable(name = "hand",
	joinColumns = @JoinColumn(name = "player_id"),
	inverseJoinColumns = {@JoinColumn(name = "cards_face"), @JoinColumn(name = "cards_suit")})
	//private List<Card> hand;

	@Column(name = "player_score")
	private int score;
	
	@Column(name = "player_name")
	private String name;
	
	@Column(name = "player_tokens")
	private int tokens;
	
	//Logs allow us to have a record of what is happening in our program
	//Logging levels include: Fatal, Error, Warn, Debug, Info, & Trace
	private static Logger log = Logger.getRootLogger();

	// Player Logic
	public void drawCard(Card card) throws ScoreLessThanZeroException {
		this.drawCard(this.getHand().size(), card);
	}
	
	public void drawCard(int index, Card card) throws ScoreLessThanZeroException {

		this.getHand().add(index, card);

		try {
			calculateScore(card.getValue());
		} catch (IllegalArgumentException e) {
			log.error("Negative Score Calculated", e);
			this.getHand().set(index, new Card(0));
			throw new ScoreLessThanZeroException(e);
		}

	}

	private void calculateScore(int card) {
		this.setScore(this.getScore() + card);
	}

	public String showHand() {
		String displayHand = "";
		for (Card card : this.getHand()) {
			displayHand += card;
			displayHand += ":";
		}
		return displayHand;
	}

	// possibly will need to add an index to add cards to the hand
	// future improvements: bet/wallet/win%/skipping or joining game

	public Player() {
		// first line?
		// always super() or this()
		// super(); implicitly
		this.hand = new ArrayList<Card>();
		this.score = 0;
		this.name = "Player" + Math.random() * 100;
	}

	public Player(String name, int score, List<Card> hand) {
		this();
		// super();
		this.name = name;
		this.score = score;
		this.hand = hand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hand.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	// HashCode Equals Contract: all objects that are equal must have the same
	// hashCode
	// Not all objects that have the same hashCode, are required to be equal
	// Collision
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (!hand.equals(other.hand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	private void setScore(int score) {
		if (score >= 0) {
			this.score = score;
		} else {
			throw new IllegalArgumentException("Negative score reached");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return this.score;
	}

	public List<Card> getHand() {
		return hand;
	}

	private void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	@Override
	public String toString() {
		return "Player [hand=" + hand + ", score=" + score + ", name=" + name + ", tokens=" + tokens + "]";
	}

	

}
