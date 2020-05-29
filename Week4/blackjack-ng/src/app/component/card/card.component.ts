import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input()
  value: number;

  @Input()
  suit: string;

  getSuitStyles() {

    if (this.suit === '../../assets/hidden.png') {
      console.log('hidden card style');
      return {
        'align-self': 'center',
        'width' : '100%',
        'height' : '100%'
      }
    }

  }

  constructor() { }

  ngOnInit(): void {
  }

}
