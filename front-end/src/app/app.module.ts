import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ManageStudentComponent } from './view/manage-student/manage-student.component';
import { ManageCoursesComponent } from './view/manage-courses/manage-courses.component';
import { HomeComponent } from './view/home/home.component';
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

const routs:Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'student',
    component:ManageStudentComponent
  },
  {
    path:'course',
    component:ManageCoursesComponent
  }
  ];

@NgModule({
  declarations: [
    AppComponent,
    ManageStudentComponent,
    ManageCoursesComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routs),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
