package com.revature.blackjack.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.util.ConnectionFactory;

public class StoredProcTest {

	@Test
	public void test() {
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			int score = 0;
			String name = "";
			String sql = "call proc_get_dealer_score(?, ?, ?)";
			//CallableStatement call = conn.prepareCall(sql);
			PreparedStatement call = conn.prepareCall(sql);
			call.setString(1, "Game 1");
			call.setInt(2, score);
			call.setString(3, name);
			
			ResultSet ret = call.executeQuery();
			ret.next();
			System.out.println(ret.getInt(1));
			System.out.println(ret.getString(2));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
