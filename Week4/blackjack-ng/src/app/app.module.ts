import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CardComponent } from './component/card/card.component';
import { HandComponent } from './component/hand/hand.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    HandComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
