import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  dataReceived:any
  IsLoggedIn:Boolean=false
  constructor(private aus:AuthServiceService,private route:Router) { }

  ngOnInit(): void {
  }


  loginadmin(f:any){
    let data=f.value
    this.aus.login(data).subscribe((response)=>
      {this.dataReceived=response
        this.aus.saveDataProfil(this.dataReceived.token)
        this.IsLoggedIn=true
      console.log(this.dataReceived)
      console.log(this.IsLoggedIn)
      this.route.navigate(['home'])
      }
      ,err=>console.log(err))
    

  }
}
