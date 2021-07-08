import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './components/users/profile/profile.component';
import { UsersComponent } from './components/users/users.component';


const routes: Routes = [
  {path: 'register', component: UsersComponent},
  {path: 'profile', component: ProfileComponent}, 

];


@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
