package com.revature.blackjack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.blackjack.dao.PlayerDAOHibernate;

public class PlayerDAOHibernateTest {

	private PlayerDAOHibernate pDao = new PlayerDAOHibernate();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(pDao.getPlayer("DoomSlayer"));
	}

}
