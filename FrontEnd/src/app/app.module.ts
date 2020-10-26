import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PatientComponent } from './patient/patient.component';
import { HttpClientModule } from '@angular/common/http';
import { PatientService } from './services/patient.service';
import { DoctorComponent } from './doctor/doctor.component';
import { DoctorService } from './services/doctor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminComponent } from './admin/admin.component';
import { NavComponent } from './nav/nav.component';
import { DoctorAccComponent } from './doctor/doctor-acc/doctor-acc.component';
import { DoctorAddPComponent } from './doctor/doctor-add-p/doctor-add-p.component';
import { DoctorViewPComponent } from './doctor/doctor-view-p/doctor-view-p.component';
import { DoctorConsultPComponent } from './doctor/doctor-consult-p/doctor-consult-p.component';
import { AdminConsultWaitComponent } from './admin/admin-consult-wait/admin-consult-wait.component';
import { AdminNoActivityComponent } from './admin/admin-no-activity/admin-no-activity.component';
import { LogoutComponent } from './logout/logout.component';
import { FooterComponent } from './footer/footer.component';
import { PatientModule } from './patient/patient.module';









@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    DoctorComponent,
    AdminComponent,
	  NavComponent,
	  DoctorAccComponent,
	  DoctorAddPComponent,
	  DoctorViewPComponent,
	  DoctorConsultPComponent,
	  AdminConsultWaitComponent,
    AdminNoActivityComponent,
    LogoutComponent,
    FooterComponent,
	  
 
  
  
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    PatientModule
   
    
    ],

  providers: [PatientService,DoctorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
