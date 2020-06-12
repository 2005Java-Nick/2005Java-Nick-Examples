package com.revature.blackjack.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.Player;
import com.revature.util.SessionFactoryUtil;

@Component
public class PlayerDAOHibernate implements PlayerDAO {

	private SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public Player getPlayer(String playerName) {

		Session sess = sf.openSession();

		Transaction tx = sess.beginTransaction();

		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> rootEntry = cq.from(Player.class);
		cq.where(cb.equal(rootEntry.get("name"), playerName));
		CriteriaQuery<Player> all = cq.select(rootEntry);
		TypedQuery<Player> allQuery = sess.createQuery(all);

		List<Player> players = allQuery.getResultList();

		if (players.size() != 1) {
			return null;
		} else {
			return players.get(0);
		}
	}

	public List<Player> getAllPlayers() {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> rootEntry = cq.from(Player.class);
		CriteriaQuery<Player> all = cq.select(rootEntry);
		TypedQuery<Player> allQuery = sess.createQuery(all);
		return allQuery.getResultList();
	}

	public void createPlayer(Player player) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(player);
		tx.commit();
		sess.close();
	}

	public void deletePlayer(Player player) {
		System.out.println("In delete player DAO");
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(player);
		System.out.println("After delete");
		tx.commit();
		sess.close();
	}

	public void updatePlayer(Player player) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(player);
		tx.commit();
		sess.close();
	}

	public List<Player> getPlayersByTokens(int tokens) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> rootEntry = cq.from(Player.class);
		CriteriaQuery<Player> all = cq.select(rootEntry).where(cb.equal(rootEntry.get("tokens"), tokens));
		TypedQuery<Player> allQuery = sess.createQuery(all);

		return allQuery.getResultList();
	}

}
