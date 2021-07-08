import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EventListComponent } from './composants/event-list/event-list.component';
import { EventAddComponent } from './composants/event-add/event-add.component';

@NgModule({
  declarations: [
    AppComponent,
    EventListComponent,
    EventAddComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
