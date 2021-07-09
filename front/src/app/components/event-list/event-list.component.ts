import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import { Event } from 'src/app/models/event';
import {EventService} from "../../services/event.service";
@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  listEvent:Observable<Event[]> | undefined;

  reloadData(){
    this.listEvent =this.eventService.getEventList();
  }
  constructor(private eventService:EventService) { }

  ngOnInit(): void {
    this.reloadData();
  }

}
