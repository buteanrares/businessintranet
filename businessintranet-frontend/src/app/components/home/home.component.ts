import { Component, OnInit } from '@angular/core';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  employee: EmployeeBaseModel;

  constructor() { }

  ngOnInit(): void {
    console.log("home component works")
  }

}
