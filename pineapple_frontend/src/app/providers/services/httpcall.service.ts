import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { EncrDecrService } from '../../providers/services/EncrDecrService';
// import { ToastService } from './toast.service';

@Injectable({
  providedIn: 'root'
})
export class httpCallService {
  username: string;
  password: string;
  userData: any;
  myHttpOptions: any;
  baseUrl:string = "http://localhost:8080/";
  endpoint:string;
 
  constructor(private http: HttpClient) {    
    this.myHttpOptions = new HttpHeaders({
      "Content-Type":"application/json",
      "Accept":"application/json"
    });
   }
  
   getApplications(backendUrl){
     return this.http.get(backendUrl);
   }

   postShape(data){
     this.endpoint = "shapes/add";
     return this.http.post(this.baseUrl+this.endpoint, data, this.myHttpOptions);
   }

   getMyShapes(){
     this.endpoint = "shapes";
     return this.http.get(this.baseUrl+this.endpoint);
   }

   login(data){
     this.endpoint = "users/login";
    return this.http.post(this.baseUrl+this.endpoint, data, this.myHttpOptions);
   }

   getUserByEmail(email){
    this.endpoint = "users/user?email="+email;
    return this.http.post(this.baseUrl+this.endpoint, this.myHttpOptions);
   }
}
