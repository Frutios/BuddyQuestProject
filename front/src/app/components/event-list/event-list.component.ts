import { Component, OnInit } from '@angular/core';
import { Event } from 'src/app/models/event';
import {EventService} from "../../services/event.service";
@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  events: Event[] | undefined;

  getEvents(){
    this.eventService.getEventList().subscribe(data=>{
      this.events = data;
    })
  }
  constructor(private eventService:EventService) { }

  ngOnInit(): void {
    this.getEvents();
  }

}
