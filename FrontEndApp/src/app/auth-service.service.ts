import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';

const AUTH_API = 'http://localhost:8081';
@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  helper= new JwtHelperService
  constructor(private http: HttpClient) { }
  
  register(email: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'register', {
      email,
      password
    }, );
  }
  
  login(body:any){
    return this.http.post('http://localhost:8081/auth',body)
  }

 
  getadmin(email:String){
    
    return this.http.get(`http://localhost:8081/getadmin/${email}`)
  }

  saveDataProfil(token:any){
    
    //  let decodeToken= this.helper.decodeToken(token)
      
     localStorage.setItem('token',token)
    let decodeToken=this.helper.decodeToken(token)

    console.log(decodeToken.sub)
    
    }
    getEmail(){
     let token:any= localStorage.getItem('token')
    let decodeToken=this.helper.decodeToken(token)
      return decodeToken.sub
    }
}


