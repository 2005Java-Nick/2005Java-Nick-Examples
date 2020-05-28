import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CardComponent } from './component/card/card.component';
import { HandComponent } from './component/hand/hand.component';
import { CardValuePipe } from './pipe/card-value.pipe';
import { BlackJackGameComponent } from './component/black-jack-game/black-jack-game.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    HandComponent,
    CardValuePipe,
    BlackJackGameComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
