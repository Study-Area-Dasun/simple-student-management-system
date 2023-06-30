import { Component } from '@angular/core';
import {Student} from "../dto/student";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-manage-student',
  templateUrl: './manage-student.component.html',
  styleUrls: ['./manage-student.component.scss']
})
export class ManageStudentComponent {

  studentList: Array<Student> = [];

  constructor(private http: HttpClient) {
    http.get<Array<Student>>('http://localhost:8080/api/v1/students')
      .subscribe(studentList => this.studentList = studentList);
  }

  saveStudent(txtName: HTMLInputElement, txtAddress:HTMLInputElement){
    const name = txtName.value;
    const address = txtAddress.value;

    const newStudent = new Student(0,name,address);

    this.http.post('http://localhost:8080/api/v1/students', newStudent)
      .subscribe(result => {
        this.studentList.push(<Student>result);
        txtName.value='';
        txtAddress.value='';
      });
  }
  deleteStudent(id:number){
    this.http.delete(`http://localhost:8080/students/${id}`)
      .subscribe(result =>{
        const index = this.studentList.findIndex(student => student.id === id);
        this.studentList.splice(index,1);
      });
  }

}
