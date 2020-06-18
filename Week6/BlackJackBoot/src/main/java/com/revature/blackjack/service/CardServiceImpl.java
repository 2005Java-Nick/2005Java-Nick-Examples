package com.revature.blackjack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.blackjack.domain.Card;
import com.revature.blackjack.domain.CardId;
import com.revature.blackjack.repo.CardRepo;

@Service
public class CardServiceImpl implements CardService {

	private CardRepo cardRepo;
	
	@Autowired
	public void setCardRepo(CardRepo cardRepo) {
		this.cardRepo = cardRepo;
	}
	
	@Override
	public Card getCard(String face, String suit) {
		return cardRepo.getOne(new CardId(face, suit));
	}

	@Override
	public List<Card> getAllCards() {
		return cardRepo.findAll();
	}

	@Override
	public List<Card> getRandomCards(int number) {
		return null;
	}

	@Override
	public void createCard(Card card) {
		cardRepo.save(card);
	}

	@Override
	public void deleteCard(Card card) {
		cardRepo.delete(card);
	}

	@Override
	public void updateCard(Card card) {
		cardRepo.save(card);
	}

	@Override
	public List<Card> getCardsByValue(int value) {
		// TODO Auto-generated method stub
		return cardRepo.findByValue(value);
	}

}
