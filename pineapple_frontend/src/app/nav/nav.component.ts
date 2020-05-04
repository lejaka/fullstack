import { Component, OnInit } from '@angular/core';
import { AuthService } from '../providers/services/auth.service'
import { NavigationService } from '../providers/services/navigation.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {
    constructor(public authenticated: AuthService, public navigationService: NavigationService) { }
  ngOnInit() {
  
  }

  logoff(){
    this.authenticated.logoff();
  }

  visitMain(){
    this.navigationService.goTo("apply");
  }
}
