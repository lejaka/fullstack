import { Component, OnInit } from '@angular/core';
import { httpCallService } from '../providers/services/httpcall.service';
import { AuthService } from '../providers/services/auth.service'
import { NavigationService } from '../providers/services/navigation.service';
 
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  myDetails: {
    user_id: any,
    iud : any    
    email: any,
    displayName: any,
    photoURL: any,
    created_time: any,
    triangleList: any[]
  }
  constructor(private httpcall: httpCallService, public authenticated: AuthService, public navigationService: NavigationService) { }

  ngOnInit() {
    let loginStatus: any;
    if(localStorage.hasOwnProperty('basicLogin') || localStorage.getItem('basicLogin') != null){    
    loginStatus = localStorage.getItem('basicLogin');
    console.log("LoginStatus ", loginStatus);
    if(loginStatus==false){
      this.navigationService.goTo("home");
      localStorage.clear();
    }
  }
  
  }

  login(username, password){
    console.log(username + password);
    let credentials: any;
    credentials = {
        email: username,
        displayName: password
    }
      this.httpcall.login(credentials).subscribe((data: any) => {
      this.authenticated.loginSuccess = data;
      if(this.authenticated.loginSuccess == true){
      localStorage.setItem('basicLogin', data);
      this.navigationService.goTo("apply");
      }
      else{
        this.authenticated.loginSuccess = false;
      }

    },
      response => {
        if (response.status == 0) {
          console.log(response.status);
        }
        else {
          console.log(response.status);
        }
      });

      this.httpcall.getUserByEmail(username).subscribe((data: any) => {
        this.myDetails = data;
        console.log(this.myDetails);
        localStorage.setItem('myDetails', JSON.stringify(this.myDetails));  
      },
        response => {
          if (response.status == 0) {
            console.log(response.status);
          }
          else {
            console.log(response.status);
          }
        });
  }

  logout(){
    this.authenticated.logoff();
  }


}
