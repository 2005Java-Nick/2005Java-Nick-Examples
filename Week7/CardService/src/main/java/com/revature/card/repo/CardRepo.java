package com.revature.card.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.card.domain.Card;
import com.revature.card.domain.CardId;

@Repository
public interface CardRepo extends JpaRepository<Card, CardId> {

}
