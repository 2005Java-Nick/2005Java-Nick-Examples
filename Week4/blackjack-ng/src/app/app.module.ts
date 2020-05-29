import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CardComponent } from './component/card/card.component';
import { HandComponent } from './component/hand/hand.component';
import { CardValuePipe } from './pipe/card-value.pipe';
import { BlackJackGameComponent } from './component/black-jack-game/black-jack-game.component';
import { PlayerComponent } from './component/player/player.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    HandComponent,
    CardValuePipe,
    BlackJackGameComponent,
    PlayerComponent,
    HomeComponent,
    LoginComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
