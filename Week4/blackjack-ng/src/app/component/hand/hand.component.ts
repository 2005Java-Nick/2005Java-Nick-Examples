import { Component, OnInit, Input } from '@angular/core';
import { CardService } from 'src/app/service/card.service';
import { Card } from 'src/app/types/Card';

@Component({
  selector: 'app-hand',
  templateUrl: './hand.component.html',
  styleUrls: ['./hand.component.css'],
  providers: []
})
export class HandComponent implements OnInit {

  @Input()
  isDealer: boolean;

  @Input()
  cards: Card[];

  @Input()
  score: number;

  private readonly HEART = 'HEARTS';
  private readonly SPADE = 'SPADES';
  private readonly DIAMOND = 'DIAMONDS';
  private readonly CLUB = 'CLUBS';


  getSuitUrl(suit: string) {

    switch (suit) {
      case this.HEART:
        return '../../assets/hearts.png';
      case this.SPADE:
        return '../../assets/spade.svg.png';
      case this.DIAMOND:
        return '../../assets/diamond.png';
      case this.CLUB:
        return '../../assets/club.png';
      default:
        return '../../assets/hidden.png';

    }

  }

  /*   calculateScore() {
  
      let total = 0;
  
      this.cards.forEach(card => {
        total += card.getValue();
      });
  
      this.score = total;
  
    }
  */
  addCard() {
    /* const card = new Card();

    card.setValue(this.cardService.getRandomCardValue());
    card.setSuit(this.cardService.getRandomSuit());

    this.cards.push(card);

    this.calculateScore();

    console.log(this.cards); */

    console.log('tried to hit');

  }

  constructor(private cardService: CardService) {
    this.cards = [];
  }

  ngOnInit(): void {

  }

}
