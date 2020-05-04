import { Component, OnInit } from '@angular/core';
import { NavigationService } from '../providers/services/navigation.service';
import { httpCallService } from '../providers/services/httpcall.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.scss']
})
export class ApplyComponent implements OnInit {

  public nameOfShape: String;
  public symbolToPrint:String;
  public rowsToPrint:any;
  public triangleResults: any;
  public myTriangles: any[] = [];

  constructor(public navigationService: NavigationService, public HttpCallService: httpCallService) {
    
   }
  ngOnInit() {
    let loginStatus: any;
    if(localStorage.hasOwnProperty('basicLogin') || localStorage.getItem('basicLogin') != null){    
    loginStatus = localStorage.getItem('basicLogin');
    console.log("LoginStatus ", loginStatus);
    if(loginStatus==false){
      this.navigationService.goTo("home");
    }
  }
  else{
    this.navigationService.goTo("home");
  }

  let myData: any = JSON.parse(localStorage.getItem('myDetails'));  
  console.log(myData);
}

ngAfterViewInit() { 
  this.HttpCallService.getMyShapes().subscribe((data: any) => {
    this.myTriangles = data; 
    console.log(this.myTriangles);
    },
    response => {
      if(response.status=='400'){
        //this.toastr.error(response.error.message);
        console.log(response.error.message);
      }
      if(response.status=='401'){
        //this.toastr.error(response.error.message);
        console.log(response.error.message);
      }
      if(response.status=='403'){
        //this.toastr.error(response.error.message);
        console.log(response.error.message);
      }
      if(response.status=='404'){
        //this.toastr.error(response.error.message);
        console.log(response.error.message);
      }
      else if(response.status =='200'){
        //this.toastr.error(response.error.message);
        console.log(response.error.message);
      }
      else{
        console.log(this.myTriangles);
  
      }
    },
  () => {
      });
}

play(){
let shape: any;
shape = {
    user_id: 1,
    rowsToPrint: parseInt(this.rowsToPrint),
    symbolToPrint: this.symbolToPrint,
    nameOfShape: this.nameOfShape
  };
this.nameOfShape = "";
this.symbolToPrint = "";
this.rowsToPrint = "";
this.HttpCallService.postShape(shape).subscribe(async (myData: any) => {
  console.log("okay", myData);
  this.triangleResults = myData; 
  },
  response => {
    if(response.status=='400'){
      //this.toastr.error(response.error.message);
      console.log(response.error.message);
    }
    if(response.status=='401'){
      //this.toastr.error(response.error.message);
      console.log(response.error.message);
    }
    if(response.status=='403'){
      //this.toastr.error(response.error.message);
      console.log(response.error.message);
    }
    if(response.status=='404'){
      //this.toastr.error(response.error.message);
      console.log(response.error.message);
    }
    else if(response.status =='200'){
      console.log(this.triangleResults, " Did I get it?");
    }
    else{
      //this.toastr.error("Problem with loading content, please check network connection");
      console.log("Problem with loading content, please check network connection");

    }
  },
() => {
    });

}

viewMore(name){
  console.log(name);
}

}
