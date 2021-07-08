import { Component} from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { User } from './user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {
  user: User;
  constructor(private usersServices: UsersService) {
    this.user = new User();
   }
  
  onSubmit(){
    this.usersServices.create(this.user).subscribe(user => user = this.user);
    
  }
  
  

}
