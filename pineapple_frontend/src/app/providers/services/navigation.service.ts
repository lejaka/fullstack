import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class NavigationService {

  constructor(public router: Router) { }
  /**
   * Navigate to a new url
   * @param url
   */
  public goTo(url: string): void{
    console.log(url);
    this.router.navigateByUrl(url).then(e => {
      if(e){
        console.log(`Navigation to ${url} successful!`);
      }
      else{
        console.log(`Navigation to ${url} failed!`);
      }
    })
  }
}
