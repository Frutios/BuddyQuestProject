import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';
import { User } from '../users/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: User = new User;
  constructor(private userService: UsersService) { 
    this.user.setId =1;
    console.log("Constructeur profile");
  }

  ngOnInit(): void {
    console.log("NgInit profile");
    this.userService.findById(this.user.getId).subscribe(user => {

      this.user = user
    })

  }

  onSubmit(){
    
    
  }

}
