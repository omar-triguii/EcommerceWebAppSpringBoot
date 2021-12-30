import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-admin-details',
  templateUrl: './admin-details.component.html',
  styleUrls: ['./admin-details.component.css']
})
export class AdminDetailsComponent implements OnInit {
  username:""
  user:any
  constructor(private asd:AuthServiceService,private route:Router) {
  
      this.username=this.asd.getEmail()
     this.asd.getadmin(this.username).subscribe(data =>
      this.user=data
    )
 
   }
  ngOnInit(): void {
  }

  
  /*getadmin(email:String){
    this.asd.getadmin(email).subscribe(data => {
      this.user = data;
      console.log(this.user)
    }
    )
  }*/

}
