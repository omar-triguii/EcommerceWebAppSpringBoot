import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username:""
  constructor(private asd:AuthServiceService,private route:Router) {
  
      this.username=this.asd.getEmail()
     
 
   }
  ngOnInit(): void {
  }

  user:any
  getadmin(email:String){
    this.asd.getadmin(email).subscribe(data => {
      this.user = data;
      console.log(this.user)
    }
    )
  }

}
