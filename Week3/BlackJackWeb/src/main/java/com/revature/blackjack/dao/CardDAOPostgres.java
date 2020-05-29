package com.revature.blackjack.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.revature.blackjack.domain.Card;
import com.revature.util.ConnectionFactory;

public class CardDAOPostgres implements CardDAO {

	private static final String GET_ALL_CARDS_QUERY = "Select * from blackjack.cards";

	public List<Card> getAllCards() {

		List<Card> cardList = new LinkedList<Card>();

		try { 
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.prepareStatement(GET_ALL_CARDS_QUERY).executeQuery();
			while (rs.next()) {
				cardList.add(new Card(rs.getInt("cards_value"),  rs.getString("cards_face"), rs.getString("cards_suit"))); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cardList;
	}

}
