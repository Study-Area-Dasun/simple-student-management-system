import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Course} from "../dto/courses";

@Component({
  selector: 'app-manage-courses',
  templateUrl: './manage-courses.component.html',
  styleUrls: ['./manage-courses.component.scss']
})
export class ManageCoursesComponent {

  courseList: Array<Course> = [];

  constructor(private http: HttpClient) {
    http.get<Array<Course>>('http://34.31.21.81:8081/api/v1/courses')
      .subscribe(courseList => this.courseList = courseList);
  }

  saveCourse(txtId: HTMLInputElement ,txtDescription: HTMLInputElement, txtDuration:HTMLInputElement){
    const id = txtId.value;
    const description = txtDescription.value;
    const duration = txtDuration.value;

    const newCourse = new Course(id, description, duration);

    this.http.post('http://34.31.21.81:8081/api/v1/courses', newCourse)
      .subscribe(result => {
        this.courseList.push(newCourse);
        txtId.value='';
        txtDescription.value='';
        txtDuration.value='';
      });
  }
  deleteCourse(id:string){
    this.http.delete(`http://34.31.21.81:8081/api/v1/courses/${id}`)
      .subscribe(result =>{
        const index = this.courseList.findIndex(course => course.id === id);
        this.courseList.splice(index,1);
      });
  }

}
