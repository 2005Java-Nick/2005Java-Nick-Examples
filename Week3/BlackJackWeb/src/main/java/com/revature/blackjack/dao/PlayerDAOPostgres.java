package com.revature.blackjack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.blackjack.domain.Player;
import com.revature.util.ConnectionFactory;

public class PlayerDAOPostgres implements PlayerDAO {
	
	//private static final String SAVE_PLAYER_QUERY = "update  player set player_tokens = ";
	//private static final String SAVE_PLAYER_QUERY_2 = " where player_name = ";
	private static final String SAVE_PLAYER_QUERY = "update  player set player_tokens = ? where player_name = ?";
	
	private static final String GET_PLAYER_QUERY = "select * from player where player_name = ?";

	public void savePlayer(Player p) {
		Connection conn = ConnectionFactory.getConnection();
		//conn.setSchema(schema);
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(SAVE_PLAYER_QUERY);
			//"update player set player_tokens = '510' where player_name = 'DoomSlayer'"
			//stmt.executeUpdate(SAVE_PLAYER_QUERY + "'" + p.getTokens() + "'" + SAVE_PLAYER_QUERY_2 + "'" + p.getName() + "'");
			stmt.setInt(1, p.getTokens());
			stmt.setString(2, p.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	public Player getPlayer(String playerName) {
		Connection conn = ConnectionFactory.getConnection();
		//conn.setSchema(schema);
		//Statement stmt;
		PreparedStatement stmt;
		Player p = new Player();
		try {
			stmt = conn.prepareStatement(GET_PLAYER_QUERY);
			stmt.setString(1, playerName);
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next()) {
				p.setName(res.getString("player_name"));
				p.setTokens(res.getInt("player_tokens"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return p;
	}

}
