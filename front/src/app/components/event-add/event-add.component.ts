import { Component, OnInit } from '@angular/core';
import {Event} from "../../models/event";
import {EventService} from "../../services/event.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-event-add',
  templateUrl: './event-add.component.html',
  styleUrls: ['./event-add.component.css']
})
export class EventAddComponent implements OnInit {

  event: Event = new Event();

  constructor(private eventService:EventService, private router:Router) { }

  ngOnInit(): void {
  }
  saveEvent(){
    this.eventService.createEvent(this.event).subscribe(data =>{
      this.goToEventList();
    },
      error => console.log(error));
  }
  goToEventList(){
    this.router.navigate(['/events'])
  }
  onSubmit(){
    this.saveEvent();
  }
}
