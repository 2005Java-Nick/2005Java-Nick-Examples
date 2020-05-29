import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes, Router } from '@angular/router';
import { BlackJackGameComponent } from '../component/black-jack-game/black-jack-game.component';
import { PlayerComponent } from '../component/player/player.component';
import { HomeComponent } from '../component/home/home.component';
import { LoginComponent } from '../component/login/login.component';


export const routes: Routes = [

  {path: 'game', component: BlackJackGameComponent},
  {path: 'playerDashboard', component: PlayerComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}

];



@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
