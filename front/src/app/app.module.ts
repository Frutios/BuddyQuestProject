import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UsersComponent } from './components/users/users.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventListComponent } from './composants/event-list/event-list.component';
import { EventAddComponent } from './composants/event-add/event-add.component';
import { AppRoutingModule } from './app-routing.module';
import { ProfileComponent } from './components/users/profile/profile.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    EventListComponent,
    EventAddComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
