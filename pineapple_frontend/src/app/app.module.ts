import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavComponent } from './nav/nav.component';
import { ApplyComponent } from './apply/apply.component';
import { EncrDecrService } from './providers/services/EncrDecrService';
import { httpCallService } from './providers/services/httpcall.service';
import { ToastService } from './providers/services/toast.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    ApplyComponent
    ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule
  ],
  providers: [
    EncrDecrService,
    httpCallService,
    ToastService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
