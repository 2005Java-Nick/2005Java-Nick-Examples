package com.revature.blackjack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.CardId;

@Repository
public interface CardRepo extends JpaRepository<Card, CardId>{
	
	public List<Card> findByValue(int value);
	
	public List<Card> findByFace(String face);

}
