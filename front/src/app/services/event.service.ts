import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Event} from "../models/event";

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private baseUrl="http://localhost:8081/api/eventlist"
  constructor(private http: HttpClient) { }

  getEventList():Observable<Event[]>{
    return this.http.get<Event[]>(this.baseUrl);
  }
  createEvent(event:Event):Observable<Object>{
    return this.http.post(this.baseUrl,event);
  }

}
