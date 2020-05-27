import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  getRandomCardValue() {
    return (Math.floor((Math.random() * 10)) + 2);
  }

  getRandomSuit() {
    if (Math.random() > .5) {
      return '../../assets/diamond.png';
    } else {
      return '../../assets/spade.svg.png';
    }
  }

  constructor() { }
}
