package com.revature.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.card.domain.Card;
import com.revature.card.domain.CardId;
import com.revature.card.repo.CardRepo;

@Service
public class CardServiceImpl implements CardService {
	
	private CardRepo cardRepo;
	
	@Autowired
	public void setCardRepo(CardRepo cardRepo) {
		this.cardRepo = cardRepo;
	}

	@Override
	public List<Card> getAllCards() {
		return cardRepo.findAll();
	}

	@Override
	public Card getCardByFaceSuit(String face, String suit) {
		return cardRepo.findById(new CardId(face, suit)).get();
	}

	@Override
	public void createCard(Card card) {
		cardRepo.save(card);
	}

	@Override
	public void updateCard(Card card) {
		cardRepo.findById(new CardId(card.getFace(), card.getSuit())).ifPresent((existingCard) -> cardRepo.save(card));
		
	}

	@Override
	public void deleteCard(Card card) {
		cardRepo.delete(card);
	}

}
