package com.revature.blackjack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.util.ConnectionFactory;

public class ConnectionTest {

	@Test
	public void test() {
		ConnectionFactory.getConnection();
	}

}
