import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlackJackGameComponent } from './black-jack-game.component';

describe('BlackJackGameComponent', () => {
  let component: BlackJackGameComponent;
  let fixture: ComponentFixture<BlackJackGameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlackJackGameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlackJackGameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
