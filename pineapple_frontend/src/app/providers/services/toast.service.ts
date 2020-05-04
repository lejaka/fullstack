    
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class ToastService {

  constructor(private toastr: ToastrService) { }
  
  green(title: string, message: string, timer: number): void { 
    let time = timer * 1000;
    this.toastr.success(message, title, { timeOut: time });
  }

  blue(title: string, message: string, timer: number): void { 
    let time = timer * 1000;
    this.toastr.info(message, title, { timeOut: time });
  }

  red(title: string, message: string, timer: number): void { 
    let time = timer * 1000;
    this.toastr.error(message, title, { timeOut: time });
  }

  orange(title: string, message: string, timer: number): void { 
    let time = timer * 1000;
    this.toastr.warning(message, title, { timeOut: time });
  }

  stays(title: string, message: string, timer: number): void { 
    let time = timer * 1000;
    this.toastr.warning(message, title, { timeOut: time });
  }

}