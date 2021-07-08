import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from '../components/users/user';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  private userUrl: string;

  constructor(private http: HttpClient) { 
    this.userUrl = 'http://localhost:8081/api/users';
  }

  create(user : User): Observable<User>{
    return this.http.post<User>(this.userUrl, user)
  }
}
