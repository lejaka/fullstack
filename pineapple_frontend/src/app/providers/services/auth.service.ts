import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loginSuccess: any = false;

  constructor() { }
  ngOnInit() {
    if(localStorage.hasOwnProperty('basicLogin') || localStorage.getItem('basicLogin') != null){    
    this.loginSuccess = localStorage.getItem("basicLogin");
    }
  }

  logoff(){
    this.loginSuccess = false;
    localStorage.clear();
  }
}
