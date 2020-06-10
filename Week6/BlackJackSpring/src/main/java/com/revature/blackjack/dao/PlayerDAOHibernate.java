package com.revature.blackjack.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.blackjack.domain.Player;
import com.revature.util.SessionFactoryUtil;

@Component
public class PlayerDAOHibernate implements PlayerDAO {

	private SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public void savePlayer(Player p) {
		// TODO Auto-generated method stub

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

}
