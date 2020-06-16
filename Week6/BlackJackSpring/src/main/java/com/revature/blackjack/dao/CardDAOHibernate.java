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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.CardId;
import com.revature.util.SessionFactoryUtil;

@Component
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
public class CardDAOHibernate implements CardDAO {

	private SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	//@Transactional
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
		Session sess = sf.getCurrentSession();

		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Card> cq = cb.createQuery(Card.class);
		Root<Card> rootEntry = cq.from(Card.class);
		CriteriaQuery<Card> all = cq.select(rootEntry);
		TypedQuery<Card> allQuery = sess.createQuery(all);

		return allQuery.getResultList();
	}

	public void createCard(Card c) {

		sf.getCurrentSession().save(c);

	}

	public Card getCard(String face, String suit) {

		return sf.getCurrentSession().get(Card.class, new CardId(face, suit));
	}

	public void deleteCard(Card card) {
		sf.getCurrentSession().delete(card);
	}

	public void updateCard(Card card) {
		sf.getCurrentSession().update(card);
	}

	public List<Card> getCardsByValue(int value) {
		Session sess = sf.getCurrentSession();

		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Card> cq = cb.createQuery(Card.class);
		Root<Card> rootEntry = cq.from(Card.class);
		CriteriaQuery<Card> all = cq.select(rootEntry).where(cb.equal(rootEntry.get("value"), value));
		TypedQuery<Card> allQuery = sess.createQuery(all);

		return allQuery.getResultList();
	}
}
