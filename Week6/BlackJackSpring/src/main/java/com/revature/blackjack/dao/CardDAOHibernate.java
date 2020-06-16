package com.revature.blackjack.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.CardId;
import com.revature.util.SessionFactoryUtil;

@Component
public class CardDAOHibernate implements CardDAO {

	private SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public List<Card> getAllCards() {

		/*
		 * Criteria - Depricated Robust read only API for querying the DB used
		 * Restrictions put on the Criteria Not JPA complient
		 * 
		 * CriteriaQuery - JPA complient alternative to Criteria
		 * 
		 * Query - a Hibernate way to run DML commands on our DB can accept HQL
		 * (Hibernate Query Language)
		 * 
		 */
		Session sess = sf.openSession();

		Transaction tx = sess.beginTransaction();

		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Card> cq = cb.createQuery(Card.class);
		Root<Card> rootEntry = cq.from(Card.class);
		CriteriaQuery<Card> all = cq.select(rootEntry);
		TypedQuery<Card> allQuery = sess.createQuery(all);

		return allQuery.getResultList();
	}

	public void createCard(Card c) {

		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(c);
		tx.commit();
		sess.close();

	}

	public Card getCard(String face, String suit) {

		Session sess = sf.openSession();
		Card c = sess.get(Card.class, new CardId(face, suit));
		sess.close();
		return c;

	}

	public void deleteCard(Card card) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(card);
		tx.commit();
		sess.close();
	}

	public void updateCard(Card card) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(card);
		tx.commit();
		sess.close();
	}

	public List<Card> getCardsByValue(int value) {
		Session sess = sf.openSession();

		Transaction tx = sess.beginTransaction();

		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Card> cq = cb.createQuery(Card.class);
		Root<Card> rootEntry = cq.from(Card.class);
		CriteriaQuery<Card> all = cq.select(rootEntry).where(cb.equal(rootEntry.get("value"), value));
		TypedQuery<Card> allQuery = sess.createQuery(all);

		return allQuery.getResultList();
	}
}