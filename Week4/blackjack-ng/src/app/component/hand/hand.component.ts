import { Component, OnInit } from '@angular/core';
import { CardService } from 'src/app/service/card.service';
import { Card } from 'src/app/types/Card';

@Component({
  selector: 'app-hand',
  templateUrl: './hand.component.html',
  styleUrls: ['./hand.component.css'],
  providers: []
})
export class HandComponent implements OnInit {

  cards: Card[];

  score: number;

  calculateScore() {

    let total = 0;

    this.cards.forEach(card => {
      total += card.getValue();
    });

    this.score = total;

  }

  addCard() {
    const card = new Card();

    card.setValue(this.cardService.getRandomCardValue());
    card.setSuit(this.cardService.getRandomSuit());

    this.cards.push(card);

    this.calculateScore();

    console.log(this.cards);

  }

  constructor(private cardService: CardService) { 
    this.cards = [];
  }

  ngOnInit(): void {

    this.addCard();
    this.addCard();

  }

}
