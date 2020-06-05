package com.revature.blackjack.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.blackjack.dao.CardDAOHibernate;
import com.revature.blackjack.domain.Card;

public class CardDAOHibernateTest {
	
	private CardDAOHibernate cDao = new CardDAOHibernate();

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
	public void testCreateCard() {
		Card c = new Card();
		c.setFace("Z");
		c.setSuit("DIAMONDS");
		c.setValue(20);
		cDao.createCard(c);
	}
	
	@Test
	public void testGetCard() {
		Card c = new Card();
		c.setFace("TWO");
		c.setSuit("SPADES");
		c.setValue(2);
		Card c2 = cDao.getCard("TWO", "SPADES");
		System.out.println(c2);
		assertEquals("The 2 of SPADES should grab a card with a value of 2", c, c2);
	}

}
