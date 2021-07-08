import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private baseUrl="http://localhost:8080/api/eventList"
  constructor(private http: HttpClient) { }

  getEventList():Observable<any>{
    return this.http.get(this.baseUrl);
  }

}
