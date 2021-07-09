import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './components/profile/profile.component';
import { UsersComponent } from './components/users/users.component';
import { EventListComponent } from './components/event-list/event-list.component';

const routes: Routes = [
  {path: 'register', component: UsersComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'event', component: EventListComponent},
];


@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
